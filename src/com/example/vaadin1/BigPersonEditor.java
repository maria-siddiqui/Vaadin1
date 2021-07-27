package com.example.vaadin1;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class BigPersonEditor extends PersonEditor implements PropertyChangeListener {
	
	VerticalLayout vL = new VerticalLayout();
	Button add = new Button("Add Person");
	Button remove = new Button("Remove Person");

	public BigPersonEditor(BigPerson bigPerson) {
		super(bigPerson); //passes bigPerson in PersonEditor and runs PersonEditor
		init();
		addComponent(vL);
		vL.setImmediate(true);
	}
	
	public void init() {
		add=new Button("Add Person");
		remove=new Button("Remove Person");
		addComponent(add);
		addComponent(remove);		
		
		add.addListener(new ClickListener() { //add button listener
			@Override
			public void buttonClick(ClickEvent event) {
				BigPerson bigPerson=(BigPerson) getPerson();				
				Person person = new Person();
				
				person.setId(Long.parseLong(idText.getValue().toString()));
				person.setName(nameText.getValue().toString());
				person.setAge(Integer.parseInt(ageText.getValue().toString()));
				person.setGender(genderOption.getValue().toString());
				person.setIsMarried(Boolean.parseBoolean(maritalCheck.getValue().toString()));
				
				bigPerson.addChildAt(0, person); //adds person in bigPerson list
				System.out.println(bigPerson.toString());
//				PersonEditor pE = new PersonEditor(person);
//				vL.addComponent(pE);
				vL.addComponent(new PersonEditor(person)); //adds PersonEditor UI of person in  layout
				}
			});
		
		remove.addListener(new ClickListener() { //remove button listener
			@Override
			public void buttonClick(ClickEvent event) {
				BigPerson bigPerson=(BigPerson) getPerson(); //gets person in bigPerson list				

				if(!bigPerson.getList().isEmpty()){ //if list is not empty
					bigPerson.removeChildAt(0); //removes person from BigPerson's list at index 0
						vL.removeAllComponents(); //removes all components from layout
						for (Person person : bigPerson.getList()) {
							vL.addComponent(new PersonEditor(person)); //adds remaining persons editors of BigPerson's list in layout 
						}
				}
			}
		});
	}
}