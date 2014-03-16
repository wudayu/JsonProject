package com.qianfeng.service;

import java.util.ArrayList;
import java.util.List;

import com.qianfeng.domain.Person;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JsonTools {

	public JsonTools() {
		// TODO Auto-generated constructor stub
	}

	public static String getString(Person person) {
		JSON json = JSONSerializer.toJSON(JsonList.getPerson());
		return json.toString();
	}

	/**
	 * 
	 * @param msgString
	 * @return
	 */
	public static Person getPerson(String msgString) {
		Person person = new Person();
		JSONArray array = new JSONArray();
		array.add(msgString);
		JSONObject obj = array.getJSONObject(0);
		// System.out.println(obj.get("age"));
		// System.out.println(obj.get("name"));
		person.setAge(obj.getInt("age"));
		person.setName(obj.getString("name"));
		return person;
	}

	public static String getListString(List<Person> listPersons) {
		JSON json = JSONSerializer.toJSON(listPersons);
		return json.toString();
	}

	
	/**
	 * 将一个json格式的字符串转换成行对应的对象
	 * @param str
	 * @return
	 */
	public static List<Person> getPersons(String str) {
		List<Person> list = new ArrayList<Person>();
		JSONArray array = new JSONArray();
		array.add(str);
		JSONArray array2 = array.getJSONArray(0);
		for (int i = 0; i <array2.size(); i++) {
			JSONObject jsonObject =  array2.getJSONObject(i);
			Person person = new Person();
			person.setAge(jsonObject.getInt("age"));
			person.setName(jsonObject.getString("name"));
			list.add(person);
		}
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// JSON json = JSONSerializer.toJSON(JsonList.getList());
		// System.out.println(getString(new Person(23,"jack")));
		// System.out.println(getPerson("{'age':1002,'name':'李四2'}").toString());
		// System.out.println(getListString(JsonList.getList()));
		String msgString = "[{'age':1002,'name':'李四2'},{'age':1003,'name':'李四3'},{'age':1001,'name':'李四1'}]";
		List<Person> lPersons = getPersons(msgString);
		for(Person p:lPersons){
			System.out.println(p.toString());
		}
	}

}
