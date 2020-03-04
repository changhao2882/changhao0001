package test001;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "D://test2.txt";
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try{
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));
			fileReader = new FileReader(filePath);
			bufferedReader = new BufferedReader(fileReader);
			String str = null;
			while((str = bufferedReader.readLine()) != null){
				System.out.println(str);
				if("威锋网".equals(str)){
					System.out.println(FixFileName("D://aa.txt",str));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(fileReader != null){fileReader.close();}
				if(bufferedReader != null){bufferedReader.close();}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	private static String FixFileName(String filePath, String newFileName) {
         File f = new File(filePath);
         System.out.println(f);
         if (!f.exists()) { // 判断原文件是否存在（防止文件名冲突）
             return null;
         }
         newFileName = newFileName.trim();
         if ("".equals(newFileName) || newFileName == null) // 文件名不能为空
             return null;
         String newFilePath = null;
         if (f.isDirectory()) { // 判断是否为文件夹
             newFilePath = filePath.substring(0, filePath.lastIndexOf("/")) + "/" + newFileName;
         } else {
             newFilePath = filePath.substring(0, filePath.lastIndexOf("/")) + "/" + newFileName
                     + filePath.substring(filePath.lastIndexOf("."));
         }
         
         File nf = new File(newFilePath);
         System.out.println(nf);
         try {
             //; // 修改文件名
             System.out.println(f.renameTo(nf));
         } catch (Exception err) {
             err.printStackTrace();
             return null;
         }
         return newFilePath;
     }

}
