package com.example.vaadin1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {
	private long id;
	private String name;
	private int age;
	private String status;
	
	private PropertyChangeSupport propChangeSupp;
	
	public Person(long id, String name, int age, String status) {
			this.id = id;
			this.name = name;
			this.age = age;
			this.status = status;
			propChangeSupp = new PropertyChangeSupport(this);
		}
	
	  public Person(){
		  id = 0l;
          name = "";
          age = 0;
          status = "";
          propChangeSupp = new PropertyChangeSupport(this);
      }
	  
	  public void setId(long id) {
			Long oldId = this.id;
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
	  public void setStatus(String status) {
			String oldStatus = this.status;
			this.status = status;
			PropertyChangeEvent event = new PropertyChangeEvent(this, "status", oldStatus, status);
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
	  public String getStatus() {
			return status;
		}
		
	  public void addPropertyChangeListener(PropertyChangeListener listener) {
			propChangeSupp.addPropertyChangeListener(listener);
		}
	  public void removePropertyChangeListener(PropertyChangeListener listener) {
			propChangeSupp.removePropertyChangeListener(listener);
		}

}
