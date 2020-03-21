package com.atguigu.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.dao.CatDao;
import com.atguigu.dao.EmployeeDao;
import com.atguigu.dao.KeyDao;
import com.atguigu.dao.LockDao;
import com.atguigu.bean.Cat;
import com.atguigu.bean.Employee;
import com.atguigu.bean.Key;
import com.atguigu.bean.Lock;

public class MyBatisCRUDTest {
	
	//工厂来一个就行了
	SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void initSqlSessionFactory() throws IOException{
		//1.根据全局配置文件创建一个sqlSessionFactory
		//SqlSessionFactory：是SqlSession工厂，负责创建SqlSession对象；
		//SqlSession：sql会话（代表和数据库的一次会话）
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//查询
	@Test
	public void test() throws IOException {
		
		//initSqlSessionFactory();  @Before相当于每次运行之前提前运行
		//2.获取和数据库的一次会话：openSession();;;;;每个线程都应该有一个连接，放在全局那里，相当于多个线程共用一个连接
		SqlSession openSession = sqlSessionFactory.openSession();
		
		Employee employee = null;
		try {
			//3.使用SqlSession操作数据库,获取到dao接口的实现
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			//4.调用之前的方法
			employee = employeeDao.getEmpById(1);
			System.out.println(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			openSession.close();
		}
	}
	
	//插入
	@Test
	public void test1() {
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			//调用之前的方法测试
//			Employee employee = new Employee(null,"tomcat","wtomcat@qq.com",0);
//			int i = employeeDao.insertEmployee(employee);
//			System.out.println("--->"+i);
//			System.out.println("刚才插入的id:"+employee.getId());
			Employee employee = new Employee(null,"tomcat","wtomcat@qq.com",0);
			int i = employeeDao.insertEmployee2(employee);
			System.out.println("--->"+i);
			System.out.println("刚才插入的id:"+employee.getId());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//更新数据库手动提交
			openSession.commit();
			openSession.close();
		}
	}
	
	//修改
	@Test
	public void test2() {
		
		//设置true是自动提交
		SqlSession openSession = sqlSessionFactory.openSession(true);
		try {
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			//调用之前的方法测试
			int i = employeeDao.updateEmployee(new Employee(3,"tomcat","tomcat@qq.com",1));
			System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			openSession.close();
		}
	}

	//删除
	@Test
	public void test3() {
		
		//设置true是自动提交
		SqlSession openSession = sqlSessionFactory.openSession(true);
		try {
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			//class com.sun.proxy.$Proxy3  代理对象
			System.out.println(employeeDao.getClass());
			
			//调用之前的方法测试
			boolean i = employeeDao.deleteEmployee(3);
			System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			openSession.close();
		}
	}
	//getEmpByIdAndEmpName
	//查询
		@Test
		public void testgetEmpByIdAndEmpName() throws IOException {
			
			//initSqlSessionFactory();  @Before相当于每次运行之前提前运行
			//2.获取和数据库的一次会话：openSession();;;;;每个线程都应该有一个连接，放在全局那里，相当于多个线程共用一个连接
			SqlSession openSession = sqlSessionFactory.openSession();
			
			Employee employee = null;
			try {
				//3.使用SqlSession操作数据库,获取到dao接口的实现
				EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
				//4.调用之前的方法
				employee = employeeDao.getEmpByIdAndEmpName(1,"admin");
				System.out.println(employee);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				openSession.close();
			}
		}
		//getEmployeeByIdAndEmpName
		@Test
		public void testgetEmployeeByIdAndEmpName() throws IOException {
			
			//initSqlSessionFactory();  @Before相当于每次运行之前提前运行
			//2.获取和数据库的一次会话：openSession();;;;;每个线程都应该有一个连接，放在全局那里，相当于多个线程共用一个连接
			SqlSession openSession = sqlSessionFactory.openSession();
			
			Employee employee = null;
			try {
				//3.使用SqlSession操作数据库,获取到dao接口的实现
				EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("tableName", "t_employee");
				map.put("id", "1");
				map.put("empName", "admin");
				//4.调用之前的方法
				employee = employeeDao.getEmployeeByIdAndEmpName(map);
				System.out.println(employee);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				openSession.close();
			}
		}

		//getAllEmps
		@Test
		public void testgetAllEmps() throws IOException {
			
			//initSqlSessionFactory();  @Before相当于每次运行之前提前运行
			//2.获取和数据库的一次会话：openSession();;;;;每个线程都应该有一个连接，放在全局那里，相当于多个线程共用一个连接
			SqlSession openSession = sqlSessionFactory.openSession();
			
			List<Employee> employee = null;
			try {
				//3.使用SqlSession操作数据库,获取到dao接口的实现
				EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
				//4.调用之前的方法
				employee = employeeDao.getAllEmps();
				for (Employee employee2 : employee) {
					System.out.println(employee2);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				openSession.close();
			}
		}
		
		//getEmpByIdReturnMap
		@Test
		public void testgetEmpByIdReturnMap() throws IOException {
			
			//initSqlSessionFactory();  @Before相当于每次运行之前提前运行
			//2.获取和数据库的一次会话：openSession();;;;;每个线程都应该有一个连接，放在全局那里，相当于多个线程共用一个连接
			SqlSession openSession = sqlSessionFactory.openSession();
			
			Map<String, Object> employee = null;
			try {
				//3.使用SqlSession操作数据库,获取到dao接口的实现
				EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
				//4.调用之前的方法
				employee = employeeDao.getEmpByIdReturnMap(1);
				System.out.println(employee.get("id"));
				System.out.println(employee.get("empname"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				openSession.close();
			}
		}
		
		//getAllEmpsReturnMap
		@Test
		public void testgetAllEmpsReturnMap() throws IOException {
			
			//initSqlSessionFactory();  @Before相当于每次运行之前提前运行
			//2.获取和数据库的一次会话：openSession();;;;;每个线程都应该有一个连接，放在全局那里，相当于多个线程共用一个连接
			SqlSession openSession = sqlSessionFactory.openSession();
			
			Map<Integer, Employee> employee = null;
			try {
				//3.使用SqlSession操作数据库,获取到dao接口的实现
				EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
				//4.调用之前的方法
				employee = employeeDao.getAllEmpsReturnMap();
				Employee employee2 = employee.get(1);
				System.out.println(employee2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				openSession.close();
			}
		}
		
		/**
		 * 默认mybatis自动封装结果集；
		 * 1）、按照列名和属性名一一对应的规则（不区分大小写）；
		 * 2）、如果不一一对应；
		 * 		1）、开启驼峰命名法（满足驼峰命名规则  aaa_bbb  aaaBbb）
		 * 		2）、起别名：
		 */
		//getCatById
		@Test
		public void testgetCatById() throws IOException {
			
			//initSqlSessionFactory();  @Before相当于每次运行之前提前运行
			//2.获取和数据库的一次会话：openSession();;;;;每个线程都应该有一个连接，放在全局那里，相当于多个线程共用一个连接
			SqlSession openSession = sqlSessionFactory.openSession();
			
			Cat cat = null;
			try {
				//3.使用SqlSession操作数据库,获取到dao接口的实现
				CatDao catDao = openSession.getMapper(CatDao.class);
				//4.调用之前的方法
				cat = catDao.getCatById(1);
				System.out.println(cat);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				openSession.close();
			}
		}
		
		/**
		 * 联合查询情况下
		 * 1、使用级联属性封装联合查询后的所有结果
		 */
		//getKeyById
		@Test
		public void testgetKeyById() throws IOException {
			
			//initSqlSessionFactory();  @Before相当于每次运行之前提前运行
			//2.获取和数据库的一次会话：openSession();;;;;每个线程都应该有一个连接，放在全局那里，相当于多个线程共用一个连接
			SqlSession openSession = sqlSessionFactory.openSession();
			
			Key key = null;
			try {
				//3.使用SqlSession操作数据库,获取到dao接口的实现
				KeyDao keyDao = openSession.getMapper(KeyDao.class);
				//4.调用之前的方法
				key = keyDao.getKeyById(1);
				System.out.println(key);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				openSession.close();
			}
		}
		
		//getLockById
		@Test
		public void testgetLockById() throws IOException {
			
			//initSqlSessionFactory();  @Before相当于每次运行之前提前运行
			//2.获取和数据库的一次会话：openSession();;;;;每个线程都应该有一个连接，放在全局那里，相当于多个线程共用一个连接
			SqlSession openSession = sqlSessionFactory.openSession();
			
			Lock lock = null;
			try {
				//3.使用SqlSession操作数据库,获取到dao接口的实现
				LockDao lockDao = openSession.getMapper(LockDao.class);
				//4.调用之前的方法
				lock = lockDao.getLockById(3);
				System.out.println(lock);
				System.out.println("所有锁子如下：");
				List<Key> keys = lock.getKeys();
				for (Key key : keys) {
					System.out.println(key);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				openSession.close();
			}
		}
		
		/*
		 * 分步查询：
		 * 0）、查询钥匙的时候顺便查出锁子；
		 * 1）、Key key = keyDao.getKeyById(1);
		 * 2）、Lock lock = lockDao.getLockById(1);
		 */
		@Test
		public void test07() throws InterruptedException{
			
			SqlSession openSession = sqlSessionFactory.openSession();
			try {
				KeyDao mapper = openSession.getMapper(KeyDao.class);
				
				Key key = mapper.getKeyByIdSimple(1);
				//严重性能；
				System.out.println(key.getKeyName());
				//按需加载；需要的时候再去查询；全局开启按需加载策略；mybatis-config.xml中有设置
				//延迟加载：不着急加载（查询对象）
				Thread.sleep(3000);
				String lockName = key.getLock().getLockName();
				System.out.println(lockName);
				
			} finally {
				openSession.close();
			}
		}
		
		/**
		 * 一般我们在工作的时候；写成两个方法
		 * public Key getKeySimple(Integer id);
		 * 
		 * 推荐都来写连接查询
		 * public Key getKeyAssicate()
		 */
		@Test
		public void test08(){
			SqlSession openSession = sqlSessionFactory.openSession();
			try {
				
				LockDao mapper = openSession.getMapper(LockDao.class);
				Lock lock = mapper.getLockByIdByStep(3);
				System.out.println(lock.getLockName());
				
				List<Key> keys = lock.getKeys();
				for (Key key : keys) {
					System.out.println(key.getKeyName());
				}
				
				
			} finally {
				openSession.close();
			}
		}
		
		
		
		
		
		
		
		
}
