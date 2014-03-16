package com.qianfeng.service;

import java.util.ArrayList;
import java.util.List;

import com.qianfeng.domain.Person;



public class JsonList {

	public JsonList() {
		// TODO Auto-generated constructor stub
	}

	public static List<Person> getList() {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person(1002,"李四2"));
		list.add(new Person(1003,"李四3"));
		list.add(new Person(1001,"李四1"));
		return list;
	}
	public static Person getPerson(){
		return new Person(1002,"李四2"); 
	}
}
