package com.async.entity;

public class User {
	
	private String name;
	private String blog;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBlog() {
		return blog;
	}
	public void setBlog(String blog) {
		this.blog = blog;
	}
	public User(String name, String blog) {
		super();
		this.name = name;
		this.blog = blog;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", blog=" + blog + "]";
	}
	
	

}
