package com.atguigu.factory;

import com.atguigu.bean.AirPlane;

/**
 * 实例工厂
 * @author 67557
 *
 */
public class AirPlaneInstanceFactory {
	//new AirPlaneInstanceFactory().getAirPlane()
	public AirPlane getAirPlane(String jzName){
		System.out.println("AirPlaneInstanceFactory开始造飞机。。。");
		AirPlane airPlane = new AirPlane();
		airPlane.setFdj("太行");
		airPlane.setFjsName("哈哈");
		airPlane.setJzName(jzName);
		airPlane.setPersonNum(300);
		airPlane.setYc("198.98cm");
		return airPlane;
	}
}
