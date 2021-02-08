package model;

import java.io.Serializable;

public class Movies implements Serializable{
	/**
	 * NUPUR ADHVARYU
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	String day;
	String time;
	int seats;
	
	public Movies() {
		
	}
	public Movies(int id,String n, String dy,String t,int seats) {
		this.id=id;
		this.time=t;
		this.day=dy;
		this.name=n;
		this.seats = seats;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	
	
}
