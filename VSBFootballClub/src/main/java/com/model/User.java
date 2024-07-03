package com.model;

public class User {
		// TODO Auto-generated method stub

	String Name;
	int Age;
	String Gender;
	String Address;	
	
	public User(String name,int age, String gender, String address) {
			super();
			this.Name= name;
			this.Age = age;
			this.Gender = gender;
			this.Address = address;

		}
		public String getName() {
			return Name;
		}
		public int getAge() {
			return Age;
		}
		public String getGender() {
			return Gender;
		}
		public String getAddress() {
			return Address;
		}
	

		} 