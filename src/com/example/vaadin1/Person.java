package com.example.vaadin1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {
	
	private long id;
	private String name;
	private int age;
	private String gender;
	private boolean isMarried;
	
	private PropertyChangeSupport propChangeSupp; //PropertyChangeSupport is a utility class used by beans that support bound properties. It manages a list of listeners and dispatches PropertyChangeEvents to them.
	
	public Person(long id, String name, int age, String gender, boolean isMarried) {
			this.id = id;
			this.name = name;
			this.age = age;
			this.gender=gender;
			this.isMarried = isMarried;
			propChangeSupp = new PropertyChangeSupport(this);
	}
	
	public Person(){
		  id = 0;
          name = "";
          age = 0;
          gender = "";
          isMarried = false;
          propChangeSupp = new PropertyChangeSupport(this);
    }
	
	public void setId(long id) {
			long oldId = this.id;
			this.id = id;
			PropertyChangeEvent event = new PropertyChangeEvent(this, "id", oldId, id); //PropertyChange event gets fired whenever a bean changes a "bound" property.
			propChangeSupp.firePropertyChange(event);
	}
	
	public void setName(String name) {
			String oldName = this.name;
			this.name = name;
			PropertyChangeEvent event = new PropertyChangeEvent(this, "name", oldName, name);
			propChangeSupp.firePropertyChange(event); //Publishes a property change event to all listeners of that property.
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
	  
	public void setIsMarried(boolean isMarried) {
		boolean oldIsMarried = this.isMarried;
			this.isMarried = isMarried;
			PropertyChangeEvent event = new PropertyChangeEvent(this, "isMarried", oldIsMarried, isMarried);
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
	
	public boolean getIsMarried() {
		return isMarried;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", isMarried="
				+ isMarried + "]";
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
			propChangeSupp.addPropertyChangeListener(listener);
	}
	
	public PropertyChangeSupport getPropChangeSupp() {
		return propChangeSupp;
	}

	public void setPropChangeSupp(PropertyChangeSupport propChangeSupp) {
		this.propChangeSupp = propChangeSupp;
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
			propChangeSupp.removePropertyChangeListener(listener);
	}

}