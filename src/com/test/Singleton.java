package com.test;

public class Singleton {	
	
	private static Singleton INSTANCE;
	private Singleton() {
		
	}
	
	/*private static class SingletonInstance {
		
		private static Singleton INSTANCE = new Singleton();
		
	}*/
	
	public Singleton getInstance() {
		if(INSTANCE==null) {
			synchronized (INSTANCE) {				
					if(INSTANCE==null) {
						INSTANCE = new Singleton();
					}
			}
		}
		return INSTANCE;
	}
	

}




