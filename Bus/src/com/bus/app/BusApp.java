package com.bus.app;

import java.sql.SQLException;
import java.util.List;

import com.bus.Bus;
import com.bus.dao.BusDao;

public class BusApp {

	public static void main(String[] args) throws SQLException {
		Bus bus = new Bus("MRS", 500);
		BusDao busDao = new BusDao();
		busDao.add(bus);
		
//		List<Bus> list = busDao.list();
//		for(Bus b : list) {
//			System.out.println(b);
//		}
//		
//		System.out.println(busDao.count());
		
//		List<Bus> descList = busDao.descList();
//		for(Bus b : descList) {
//			System.out.println(b);
//		}
		
//		List<Bus> busList = busDao.find("vrl");
//		
//		for(Bus b : busList) {
//			System.out.println(b);
//		}
		
		List<Bus> minFareBusList = busDao.fetchLowestFareBus();
		
		System.out.println(minFareBusList);
	}

}
