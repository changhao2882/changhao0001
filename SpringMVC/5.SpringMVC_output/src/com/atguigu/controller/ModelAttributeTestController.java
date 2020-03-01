package com.atguigu.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.SessionAttributes;

//就是自始至终都在修改同一个Book对象
import com.atguigu.bean.Book;

/**
 * 测试ModelAttribute注解；
 * 使用场景：书城的图书修改为例；
 * 1）页面端；
 * 		显示要修改的图书的信息，图书的所有字段都在
 * 2）servlet收到修改请求，调用dao；
 * 		String sql="update bs_book set title=?,
 * 					author=?,price=?,
 * 					sales=?,stock=?,img_path=? 
 * 				where id=?";
 * 3）实际场景？
 * 		并不是全字段修改；只会修改部分字段，以修改用户信息为例；
 * 		username  password  address;
 * 		1）、不修改的字段可以在页面进行展示但是不要提供修改输入框；
 * 		2）、为了简单，Controller直接在参数位置来写Book对象
 * 		3）、SpringMVC为我们自动封装book；（没有带的值是null）
 * 		4）、如果接下来调用了一个全字段更新的dao操作；会将其他的字段可能变为null；
 * 			sql = "update bs_book set"
 * 			if(book.getBookName()){
 * 				sql +="bookName=?,"
 * 			}
 * 			if(book.getPrice()){
 * 				sql +="price=?"
 * 			}
 * 
 * 4）、如何能保证全字段更新的时候，只更新了页面携带的数据；
 * 		1）、修改dao；代价大？
 * 		2）、Book对象是如何封装的？
 * 			1）、SpringMVC创建一个book对象，每个属性都有默认值，bookName就是null；
 * 				1、让SpringMVC别创建book对象，直接从数据库中先取出一个id=100的book对象的信息
 * 				2、Book [id=100, bookName=西游记, author=张三, stock=12, sales=32, price=98.98]
 * 
 * 			2）、将请求中所有与book对应的属性一一设置过来；
 * 				3、使用刚才从数据库取出的book对象，给它 的里面设置值；（请求参数带了哪些值就覆盖之前的值）
 * 				4、带了的字段就改为携带的值，没带的字段就保持之前的值
 * 			3）、调用全字段更新就有问题；
 * 				5、将之前从数据库中查到的对象，并且封装了请求参数的对象。进行保存；
 * 
 */
//@SessionAttributes(value="book1")
/**
 * Session attribute 'book1' required - not found in session
 */

@Controller
public class ModelAttributeTestController {
	private Object o1;
	private Object o2;
	
	private Object b1;
	private Object b2;
	
	//bookDao.update(book);
	//Book [id=100, bookName=null, author=张三, stock=12, sales=32, price=98.98]
	/**
	 *		String sql="update bs_book set bookName=?,
					author=?,price=?,
					sales=?,stock=?,img_path=? 
				where id=?";
	 */
	/**
	 * 可以告诉SpringMVC不要new这个book了我刚才保存了一个book；
	 * 哪个就是从数据库中查询出来的；用我这个book?
	 * 
	 *  
	 * 同都是BindingAwareModelMap
	 * @param book
	 * @return
	 */
	
	@RequestMapping("/updateBook") 
	public String updateBook(@ModelAttribute("book1")Book book,HttpServletRequest request,@RequestParam(value="author")String author,
			Map<String, Object> model,@ModelAttribute("i")int i,@ModelAttribute("int")int j){   //model只有添加方法
		
		System.out.println("传入的model："+model.getClass());
		o2 = model;
		System.out.println("o1==o2?"+(o1 == o2));  //o1==o2?true提前运行的方法的东西跟本方法的东西一模一样
		
		b2  = book;
		Object haha = model.get("book");
		System.out.println("b1==b2?"+(b1 == b2)+"-->"+(b2 == haha)); //b1==b2?true-->true
		
		System.out.println("页面要提交过来的图书信息："+book);
		System.out.println("***************");
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(haha);
		System.out.println("***************");
		/**
		 * @ModelAttribute("book")
		 * {book=Book [id=100, bookName=西游记, author=啊啊, stock=222, sales=333, price=111.0], void=null, org.springframework.validation.BindingResult.book=org.springframework.validation.BeanPropertyBindingResult: 0 errors}
			{book=Book [id=100, bookName=西游记, author=啊啊, stock=222, sales=333, price=111.0], void=null, org.springframework.validation.BindingResult.book=org.springframework.validation.BeanPropertyBindingResult: 0 errors}
			Book [id=100, bookName=西游记, author=啊啊, stock=222, sales=333, price=111.0]
			Book [id=100, bookName=西游记, author=啊啊, stock=222, sales=333, price=111.0]
			Book [id=100, bookName=西游记, author=啊啊, stock=222, sales=333, price=111.0]
			
			@ModelAttribute("book1")
			***************
			{book=Book [id=100, bookName=西游记, author=吴承恩, stock=98, sales=10, price=98.98], void=null, int=3, i=2, book1=Book [id=100, bookName=null, author=11, stock=11, sales=11, price=11.0], org.springframework.validation.BindingResult.book1=org.springframework.validation.BeanPropertyBindingResult: 0 errors, org.springframework.validation.BindingResult.i=org.springframework.validation.BeanPropertyBindingResult: 0 errors, org.springframework.validation.BindingResult.int=org.springframework.validation.BeanPropertyBindingResult: 0 errors}
			{book=Book [id=100, bookName=西游记, author=吴承恩, stock=98, sales=10, price=98.98], void=null, int=3, i=2, book1=Book [id=100, bookName=null, author=11, stock=11, sales=11, price=11.0], org.springframework.validation.BindingResult.book1=org.springframework.validation.BeanPropertyBindingResult: 0 errors, org.springframework.validation.BindingResult.i=org.springframework.validation.BeanPropertyBindingResult: 0 errors, org.springframework.validation.BindingResult.int=org.springframework.validation.BeanPropertyBindingResult: 0 errors}
			Book [id=100, bookName=西游记, author=吴承恩, stock=98, sales=10, price=98.98]
			Book [id=100, bookName=null, author=11, stock=11, sales=11, price=11.0]
			Book [id=100, bookName=西游记, author=吴承恩, stock=98, sales=10, price=98.98]
			***************
		 */
		System.out.println("i="+i+",j="+j);
		return "success";
	}
	/**
	 * 1）、SpringMVC要封装请求参数的Book对象不应该是自己new出来的。
	 * 		而应该是【从数据库中】拿到的准备好的对象
	 * 2）、再来使用这个对象封装请求参数
	 * 
	 * @ModelAttribute：
	 * 		参数：取出刚才保存的数据
	 * 		方法位置：这个方法就会提前于目标方法先运行；
	 * 			1)我们可以在这里提前查出数据库中图书的信息
	 * 			2)将这个图书信息保存起来（方便下一个方法还能使用）
	 * 
	 * 参数的map：BindingAwareModelMap
	 * 
	 * @ModelAttribute:会提前运行，并把方法的运行结果放在隐含模型中
	 * 		放的时候会使用一个key
	 * 		如果@ModelAttribute(values="key")指定了，就用指定的
	 * 		没指定就用返回值类型首字母小写
	 */
	@ModelAttribute    //map model都行
	public void hahaMyModelAttribute(Map<String, Object> map){
		
		Book book = new Book(100, "西游记", "吴承恩", 98, 10, 98.98);
		System.out.println("数据库中查到的图书信息是："+book);
		map.put("book", book);
		
		b1 = book;
		o1 = map;
		System.out.println("--------------------");
		System.out.println(o1);
		System.out.println(b1);
		System.out.println("--------------------");
		/**
		 * {book=Book [id=100, bookName=西游记, author=吴承恩, stock=98, sales=10, price=98.98]}
			Book [id=100, bookName=西游记, author=吴承恩, stock=98, sales=10, price=98.98]
		 */
		
		System.out.println("modelAttribute方法...查询了图书并给你保存起来了...他用的map的类型："+map.getClass());
		
		System.out.println("001");
	}
	@ModelAttribute(value="i")
	public int hhh(){
		System.out.println("002");
		return 1+1;
	}
	@ModelAttribute
	public int hhh1(){
		System.out.println("003");
		return 1+2;
	}
	
	/**
	 * 数据库中查到的图书信息是：Book [id=100, bookName=西游记, author=吴承恩, stock=98, sales=10, price=98.98]
		--------------------
		{book=Book [id=100, bookName=西游记, author=吴承恩, stock=98, sales=10, price=98.98]}
		Book [id=100, bookName=西游记, author=吴承恩, stock=98, sales=10, price=98.98]
		--------------------
		modelAttribute方法...查询了图书并给你保存起来了...他用的map的类型：class org.springframework.validation.support.BindingAwareModelMap
		001
		002
		003
		传入的model：class org.springframework.validation.support.BindingAwareModelMap
		o1==o2?true
		b1==b2?true-->true
		页面要提交过来的图书信息：Book [id=100, bookName=西游记, author=ew, stock=2, sales=3, price=1.0]
		***************
		{book=Book [id=100, bookName=西游记, author=ew, stock=2, sales=3, price=1.0], void=null, i=2, int=3, org.springframework.validation.BindingResult.book=org.springframework.validation.BeanPropertyBindingResult: 0 errors, org.springframework.validation.BindingResult.i=org.springframework.validation.BeanPropertyBindingResult: 0 errors, org.springframework.validation.BindingResult.int=org.springframework.validation.BeanPropertyBindingResult: 0 errors}
		{book=Book [id=100, bookName=西游记, author=ew, stock=2, sales=3, price=1.0], void=null, i=2, int=3, org.springframework.validation.BindingResult.book=org.springframework.validation.BeanPropertyBindingResult: 0 errors, org.springframework.validation.BindingResult.i=org.springframework.validation.BeanPropertyBindingResult: 0 errors, org.springframework.validation.BindingResult.int=org.springframework.validation.BeanPropertyBindingResult: 0 errors}
		Book [id=100, bookName=西游记, author=ew, stock=2, sales=3, price=1.0]
		Book [id=100, bookName=西游记, author=ew, stock=2, sales=3, price=1.0]
		Book [id=100, bookName=西游记, author=ew, stock=2, sales=3, price=1.0]
		***************
		i=2,j=3
		来到页面了....
	 */

}
