package test001;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class FileEncode {
	
	public static void main(String[] args) {
		charset("D://test3.txt");
	}
	
	/**
     * 判断文本文件的字符集，文件开头三个字节表明编码格式。 
     * <a href="http://blog.163.com/wf_shunqiziran/blog/static/176307209201258102217810/">参考的博客地址</a>
     * 
     * @param path
     * @return
     * @throws Exception
     * @throws Exception
     */
    public static String charset(String path) {
        String charset = "GBK";
        byte[] first3Bytes = new byte[3];
        try {
            boolean checked = false;
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
            bis.mark(0); // 读者注： bis.mark(0);修改为 bis.mark(100);我用过这段代码，需要修改上面标出的地方。 
                        // Wagsn注：不过暂时使用正常，遂不改之
            int read = bis.read(first3Bytes, 0, 3);
            if (read == -1) {
                bis.close();
                return charset; // 文件编码为 ANSI
            } else if (first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE) {
                charset = "UTF-16LE"; // 文件编码为 Unicode
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xFE && first3Bytes[1] == (byte) 0xFF) {
                charset = "UTF-16BE"; // 文件编码为 Unicode big endian
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xEF && first3Bytes[1] == (byte) 0xBB
                    && first3Bytes[2] == (byte) 0xBF) {
                charset = "UTF-8"; // 文件编码为 UTF-8
                checked = true;
            }
            bis.reset();
            if (!checked) {
                while ((read = bis.read()) != -1) {
                    if (read >= 0xF0)
                        break;
                    if (0x80 <= read && read <= 0xBF) // 单独出现BF以下的，也算是GBK
                        break;
                    if (0xC0 <= read && read <= 0xDF) {
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) // 双字节 (0xC0 - 0xDF)
                            // (0x80 - 0xBF),也可能在GB编码内
                            continue;
                        else
                            break;
                    } else if (0xE0 <= read && read <= 0xEF) { // 也有可能出错，但是几率较小
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) {
                            read = bis.read();
                            if (0x80 <= read && read <= 0xBF) {
                                charset = "UTF-8";
                                break;
                            } else
                                break;
                        } else
                            break;
                    }
                }
            }
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--文件-> [" + path + "] 采用的字符集为: [" + charset + "]");
        return charset;
    }
    
    /**
	 * <div>
	 * 利用第三方开源包cpdetector获取文件编码格式.<br/>
	 * --1、cpDetector内置了一些常用的探测实现类,这些探测实现类的实例可以通过add方法加进来,
	 *   如:ParsingDetector、 JChardetFacade、ASCIIDetector、UnicodeDetector. <br/>
	 * --2、detector按照“谁最先返回非空的探测结果,就以该结果为准”的原则. <br/>
	 * --3、cpDetector是基于统计学原理的,不保证完全正确.<br/>
	 * </div>
	 * @param filePath
	 * @return 返回文件编码类型：GBK、UTF-8、UTF-16BE、ISO_8859_1
	 * @throws Exception 
	 */
	public static String getFileCharset(String filePath) throws Exception {
		CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
		/*ParsingDetector可用于检查HTML、XML等文件或字符流的编码,
		 * 构造方法中的参数用于指示是否显示探测过程的详细信息，为false不显示。
	    */
		detector.add(new ParsingDetector(false));
		/*JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码测定。
		 * 所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以再多加几个探测器，
		 * 比如下面的ASCIIDetector、UnicodeDetector等。
        */
		detector.add(JChardetFacade.getInstance());
		detector.add(ASCIIDetector.getInstance());
		detector.add(UnicodeDetector.getInstance());
		Charset charset = null;
		File file = new File(filePath);
		try {
			//charset = detector.detectCodepage(file.toURI().toURL());
			InputStream is = new BufferedInputStream(new FileInputStream(filePath));
			charset = detector.detectCodepage(is, 8);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
 
		String charsetName = "GBK";
		if (charset != null) {
			if (charset.name().equals("US-ASCII")) {
				charsetName = "ISO_8859_1";
			} else if (charset.name().startsWith("UTF")) {
				charsetName = charset.name();// 例如:UTF-8,UTF-16BE.
			}
		}
		return charsetName;
	}

}
