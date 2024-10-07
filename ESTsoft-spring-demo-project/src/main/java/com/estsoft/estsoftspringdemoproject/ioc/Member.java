package com.estsoft.estsoftspringdemoproject.ioc;

public class Member {
	// 필드
	private int id;
	private String name;
	private String address;

	public Member(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
}
