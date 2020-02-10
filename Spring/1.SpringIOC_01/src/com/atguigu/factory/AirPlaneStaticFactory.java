package com.atguigu.factory;

import com.atguigu.bean.AirPlane;

/**
 * 静态工厂
 * @author 67557
 *
 */
public class AirPlaneStaticFactory {
	//AipPlaneStaticFactory.getAirPlane()
	public static AirPlane getAirPlane(String jzName){
		System.out.println("AirPlaneStaticFactory开始造飞机。。。");
		AirPlane airPlane = new AirPlane();
		airPlane.setFdj("太行");
		airPlane.setFjsName("哈哈");
		airPlane.setJzName(jzName);
		airPlane.setPersonNum(300);
		airPlane.setYc("198.98cm");
		return airPlane;
	}
}
