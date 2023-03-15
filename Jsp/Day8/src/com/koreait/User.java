package com.koreait;

public class User {
	private int idx;
	private String userid;
	private String name;
	private int age;
	private String hp;
	private String address;
	public User(int idx, String userid, String name, int age, String hp, String address) {
		super();
		this.idx = idx;
		this.userid = userid;
		this.name = name;
		this.age = age;
		this.hp = hp;
		this.address = address;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
