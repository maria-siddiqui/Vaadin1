package com.example.vaadin1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class BigPerson extends Person{
	
	private ArrayList<Person> list = new ArrayList<>();

	public int getChildCount(){
		return list.size();
	}
	
	public Person getChildAt(int index){
		return list.get(index);
	}
	
	public void addChildAt(int index,Person person){
		list.add(index,person);	
		PropertyChangeEvent event = new PropertyChangeEvent(this, "list", null, list);
		getPropChangeSupp().firePropertyChange(event);
	}
	
	public void removeChildAt(int index){
		list.remove(index);
		PropertyChangeEvent event = new PropertyChangeEvent(this, "list", null, list);
		getPropChangeSupp().firePropertyChange(event);
	}

		public ArrayList<Person> getList() {
		return list;
	}

	public void setList(ArrayList<Person> list) {
		ArrayList<Person> oldList = this.list;
		this.list = list;
		PropertyChangeEvent event = new PropertyChangeEvent(this, "list", oldList, list);
		super.getPropChangeSupp().firePropertyChange(event);
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		super.addPropertyChangeListener(listener);
	}
}
