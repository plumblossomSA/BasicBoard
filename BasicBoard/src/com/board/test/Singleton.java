package com.board.test;

public class Singleton {
	
	private static Singleton singleton = new Singleton();
	private Singleton() {
		System.out.println("Singleton Instance Create..");
	}
	
	public static Singleton GetInstance() {
		return singleton;
	}
	


}
