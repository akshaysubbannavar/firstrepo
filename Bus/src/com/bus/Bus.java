package com.bus;

public class Bus {
	
	String name;
	double price;
	
	public Bus() {	
	}

	public Bus(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Bus [name=" + name + ", price=" + price + "]";
	}
	
	
}
