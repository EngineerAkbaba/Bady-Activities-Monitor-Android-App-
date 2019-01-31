package com.classes.health;

import android.os.Bundle;

public class Person {

	private Body body;
	private String personName;
	private Activity activity;

	

	public Person(String personName) {
		super();
		this.personName = personName;
		
		body = new Body();
		activity = new Activity("", 0);
		
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
}	
