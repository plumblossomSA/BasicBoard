package com.board.test;

public class Singleton_main {
	
	public static void main(String[] args) {
		 Singleton singleton1 = Singleton.GetInstance();
		 Singleton singleton2 = Singleton.GetInstance();
		 
		 if(singleton1== singleton2) {
			 System.out.println("같습니다.");
		 }else {
			 System.out.println("다름니다");
		 }
	}

}
