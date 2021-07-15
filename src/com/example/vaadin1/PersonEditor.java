package com.example.vaadin1;

import java.awt.CheckboxGroup;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PersonEditor extends VerticalLayout {
	
	private PropertyChangeSupport propChangeSupp;
//	BeanItemContainer<Person> container = new BeanItemContainer<Person>(Person.class);

	Person person = new Person();
	public PersonEditor(Person person){
		this.person = person;
		propChangeSupp = new PropertyChangeSupport(this);
		}
	public void setPerson(Person person) {
			Person oldPerson = this.person;
			this.person = person;
			PropertyChangeEvent event = new PropertyChangeEvent(this, "person", oldPerson, person);
			propChangeSupp.firePropertyChange(event);
			}
	public Person getPerson() {
			return person;
		}
	TextField t1 = new TextField("Enter Name");
	TextField t2 = new TextField("Enter ID");
	TextField t3 = new TextField("Enter Age");
	CheckBox check1 = new CheckBox("Gender");
	OptionGroup optionGroup1 = new OptionGroup("Gender");
	Select mySelect1 = new Select();
	Label l2 = new Label("Marital Status");
	final CheckBox checkBox2 = new CheckBox("Married");
	HorizontalLayout horizontal = new HorizontalLayout();
	
	public PersonEditor() {
		super();
		initUI();
		}
	public void initUI(){
		t1.setMaxLength(15);
		t1.setImmediate(true);
		
		
//		Label l1 = new Label("Enter Date Of Birth");
//		DateField dof = new DateField();
//		// Display only year, month, and day in ISO format
//		dof.setDateFormat("yyyy-MM-dd");
		
		optionGroup1.addItem("Male");
		optionGroup1.addItem("Female");
		mySelect1.setMultiSelect(false);// Use the single selection mode.
		
//		CheckBox check2 = new CheckBox("Marital Status");
//		OptionGroup optionGroup2 = new OptionGroup("Marital Status");
//		// Use the single selection mode.
//		optionGroup2.addItem("Single");
//		optionGroup2.addItem("Married");
//		Select mySelect2 = new Select();
//		mySelect2.setMultiSelect(false);
		
//		final CheckBox checkBox3 = new CheckBox("Single");
//		HorizontalLayout horizontalLayout = new HorizontalLayout();
//		horizontalLayout.addComponent(checkBox2);
//		horizontalLayout.addComponent(checkBox3);
		
		horizontal.setSpacing(true);
		horizontal.setMargin(true, true, true, true);
		
		setSpacing(true);
		setMargin(true, true, true, true);
		
		addComponent(t1);
		addComponent(t2);
		addComponent(t3);
//		addComponent(l1);
//		addComponent(dof);
		addComponent(optionGroup1);
//		addComponent(optionGroup2);
//		addComponent(horizontalLayout);
		addComponent(l2);
		addComponent(checkBox2);
	}
}

