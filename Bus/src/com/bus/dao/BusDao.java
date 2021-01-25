package com.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bus.Bus;
import com.bus.jdbc.BusConnection;

public class BusDao {

	BusConnection busConnection = new BusConnection();

	public void add(Bus bus) throws SQLException {

		String query = "insert into bus (name,price) values (?,?)";
		Connection connection = busConnection.getConnection();
		PreparedStatement p = connection.prepareStatement(query);
		p.setString(1, bus.getName());
		p.setDouble(2, bus.getPrice());

		System.out.println(p);
		p.executeUpdate();

		p.close();

	}

	public List<Bus> list() throws SQLException {
		String query = "select name,bus_no, price from bus";
		Connection connection = busConnection.getConnection();
		PreparedStatement p = connection.prepareStatement(query);
		
		List<Bus> list = new ArrayList<>();
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			Bus bus = new Bus();
			bus.setName(rs.getString("name"));
			bus.setPrice(rs.getDouble("price"));
			list.add(bus);
		}
		return list;
	}

	public int count() throws SQLException {
		String q = "select count(*) from bus";
		Connection connection = busConnection.getConnection();
		PreparedStatement p = connection.prepareStatement(q);
		
		ResultSet rs = p.executeQuery();
		int count = 0;
		while(rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	public List<Bus> descList() throws SQLException {
		String query = "select name,bus_no, price from bus order by price desc";
		Connection connection = busConnection.getConnection();
		PreparedStatement p = connection.prepareStatement(query);
		
		List<Bus> list = new ArrayList<>();
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			Bus bus = new Bus();
			bus.setName(rs.getString("name"));
			bus.setPrice(rs.getDouble("price"));
			list.add(bus);
		}
		return list;
	}

	public List<Bus> find(String name) throws SQLException {
		String query = "select name,bus_no, price from bus where name ILIKE ?";
		Connection connection = busConnection.getConnection();
		PreparedStatement p = connection.prepareStatement(query);
		p.setString(1, name);
		
		List<Bus> list = new ArrayList<>();
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			Bus bus = new Bus();
			bus.setName(rs.getString("name"));
			bus.setPrice(rs.getDouble("price"));
			list.add(bus);
		}
		return list;
	}

	public List<Bus> fetchLowestFareBus() throws SQLException {
		String query = "select name,bus_no, price from bus where price = (select MIN(price) from bus)";
		Connection connection = busConnection.getConnection();
		PreparedStatement p = connection.prepareStatement(query);
		
		List<Bus> list = new ArrayList<>();
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			Bus bus = new Bus();
			bus.setName(rs.getString("name"));
			bus.setPrice(rs.getDouble("price"));
			list.add(bus);
		}
		return list;
	}
	
	
}
