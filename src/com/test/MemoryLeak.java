package com.test;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class MemoryLeak {

	public static void main(String[] args) {
		UserCache cache = new UserCache();
		for(int i=0;i<10000000;i++) {
			cache.addUser(i, new User(i,"name_"+i));
		}
		System.out.println("Cache size before gc: "+cache.cache.size());
		System.gc();
		System.out.println("Cache size after gc: "+cache.cache.size());

	}

}

class UserCache{
	Map<Integer, SoftReference<User>> cache = null;
	
	public UserCache() {
		cache = new WeakHashMap<Integer, SoftReference<User>>();
	}
	
	public void addUser(Integer id, User user) {
		cache.put(id, new SoftReference<User>(user));
	}
	public User getUser(Integer id) {
		SoftReference<User> ref = cache.get(id);
		return ref!=null ? ref.get() : null;
	}
}

class User{
	private Integer id;
	private String name;
	public User(Integer id, String name) {		
		this.id = id;
		this.name = name;
	}
	
	
	
}
