package com.example.vaadin1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {
	private long id;
	private String name;
	private int age;
	private String gender;
	private String maritalStatus;
	
	private PropertyChangeSupport propChangeSupp;
	
	public Person(long id, String name, int age, String gender, String maritalStatus) {
			this.id = id;
			this.name = name;
			this.age = age;
			this.gender=gender;
			this.maritalStatus = maritalStatus;
			propChangeSupp = new PropertyChangeSupport(this);
		}
	
	public Person(){
		  id = 0l;
          name = "";
          age = 0;
          gender = "";
          maritalStatus = "";
          propChangeSupp = new PropertyChangeSupport(this);
      }
	
	public void setId(long id) {
			long oldId = this.id;
			this.id = id;
			PropertyChangeEvent event = new PropertyChangeEvent(this, "id", oldId, id);
			propChangeSupp.firePropertyChange(event);
		}
	
	public void setName(String name) {
			String oldName = this.name;
			this.name = name;
			PropertyChangeEvent event = new PropertyChangeEvent(this, "name", oldName, name);
			propChangeSupp.firePropertyChange(event);
		}
	
	public void setAge(int age) {
			int oldAge = this.age;
			this.age = age;
			PropertyChangeEvent event = new PropertyChangeEvent(this, "age", oldAge, age);
			propChangeSupp.firePropertyChange(event);
		}
	  
	public void setGender(String gender) {
		String oldGender = this.gender;
			this.gender = gender;
			PropertyChangeEvent event = new PropertyChangeEvent(this, "gender", oldGender, gender);
			propChangeSupp.firePropertyChange(event);
		}
	  
	public void setMaritalStatus(String maritalStatus) {
		String oldMaritalStatus = this.maritalStatus;
			this.maritalStatus = maritalStatus;
			PropertyChangeEvent event = new PropertyChangeEvent(this, "maritalStatus", oldMaritalStatus, maritalStatus);
			propChangeSupp.firePropertyChange(event);
		}
	  
	public long getId() {
			return id;
		}
	
	public String getName() {
			return name;
		}
	
	public int getAge() {
		  return age;
		}
	  
	public String getGender() {
			return gender;
		}
	
	public String getMaritalStatus() {
			return maritalStatus;
		}
	  
	public void addPropertyChangeListener(PropertyChangeListener listener) {
			propChangeSupp.addPropertyChangeListener(listener);
		}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
			propChangeSupp.removePropertyChangeListener(listener);
		}

}
