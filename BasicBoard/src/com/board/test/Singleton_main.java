package com.board.test;

public class Singleton_main {
	
	public static void main(String[] args) {
		 Singleton singleton1 = Singleton.GetInstance();
		 Singleton singleton2 = Singleton.GetInstance();
		 
		 if(singleton1== singleton2) {
			 System.out.println("�����ϴ�.");
		 }else {
			 System.out.println("�ٸ��ϴ�");
		 }
	}

}
