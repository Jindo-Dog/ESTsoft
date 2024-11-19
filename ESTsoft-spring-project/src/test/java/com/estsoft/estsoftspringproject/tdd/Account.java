package com.estsoft.estsoftspringproject.tdd;

public class Account {
	private int balance;

	public Account(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return this.balance;
	}

	public void deposit(int balance) {
		this.balance += balance;
	}
}
