package com.atguigu.inter;
/**
 * 接口不加载在容器中
 * 实际上可以加，加了也不创建对象，只要这个组件是一个接口
 * 相当于告诉Spring，ioc容器中可能有这种类型的组件
 * @author 67557
 *
 */
public interface Calculator {
	public int add(int i,int j);
	public int sub(int i,int j);
	public int mul(int i,int j);
	public int div(int i,int j);

}
