package com.example.vaadin1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Form;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import javafx.beans.value.ChangeListener;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;

public class PersonEditor extends VerticalLayout implements PropertyChangeListener{	

	private PropertyChangeSupport propChangeSupp;

	TextField idText;
	TextField nameText = new TextField("Enter Name");
	TextField ageText = new TextField("Enter Age");
	OptionGroup genderOption = new OptionGroup("Gender");
	Label label = new Label("Marital Status");
	final CheckBox maritalCheck = new CheckBox("Married");

	private Person person;

	public Person getPerson(){
		return person;
	}
	
	public PropertyChangeSupport getPropChangeSupp() {
		return propChangeSupp;
	}

	private BeanItem<Person> personBean; //creates Person type person bean

	public PersonEditor() { //default constructor	
		super();
		propChangeSupp = new PropertyChangeSupport(this);
		initUI();
	}

	public PersonEditor(Person person){//parameterized constructor, calls from main class
		this();  //runs above default constructor
		setPerson(person);
		setPersonBean(); 
	}

	public void setPerson(Person person) { 
		Person oldPerson = this.person;
		this.person = person; 
		person.addPropertyChangeListener(this);// calling person's class property change listener function
		propChangeSupp.firePropertyChange( "person", oldPerson, person);
	}

	public void setPersonBean() {
		personBean = new BeanItem<Person>(this.person); //defining person bean that it is of person class
		idText.setPropertyDataSource(personBean.getItemProperty("id")); // connecting idText to id attribute of person class. Through idText we can change and update id attribute of person class
		nameText.setPropertyDataSource(personBean.getItemProperty("name")); // Same as above
		ageText.setPropertyDataSource(personBean.getItemProperty("age"));
		genderOption.setPropertyDataSource(personBean.getItemProperty("gender"));
		maritalCheck.setPropertyDataSource(personBean.getItemProperty("isMarried"));
		updateToId();
		updateToName();
		updateToAge();
		updateToGender();
		updateToIsMarried();	
	}

	public void initUI(){
		this.idText = new TextField("Enter Id");
		nameText.setMaxLength(15);
		genderOption.addItem("Male");
		genderOption.addItem("Female");
		idText.setImmediate(true);
		nameText.setImmediate(true);
		ageText.setImmediate(true);
		genderOption.setImmediate(true);
		maritalCheck.setImmediate(true);

		setSpacing(true);
		setMargin(true, true, true, true);
		addComponent(idText);
		addComponent(nameText);
		addComponent(ageText);
		addComponent(genderOption);
		addComponent(label);
		addComponent(maritalCheck);
		
//		nameText.addListener(new TextChangeListener() {
//				@Override
//				public void textChange(TextChangeEvent event) {
//					//applyToName();
//					System.out.println("Text Listener");
//					System.out.println(event.getText().toString());
//					//System.out.println(person.getName());
//				}
//			});
	}
	
//  apply functions will copy from the PersonEditor to the Person bean.
	public void applyToId() { 
		person.setId(Long.parseLong(idText.getValue().toString()));
	}

	public void applyToName() {
		person.setName(nameText.getValue().toString());
	}

	public void applyToAge() { 
		person.setAge(Integer.parseInt(ageText.getValue().toString()));
	}

	public void applyToGender() {
		person.setGender(genderOption.getValue().toString());
	}

	public void applyToIsMarried() {
		person.setIsMarried(Boolean.parseBoolean(maritalCheck.getValue().toString()));
	}

//	Update functions will copy Person's bean property to Person Editor component.
	public void updateToId() {
		idText.setPropertyDataSource(personBean.getItemProperty("id"));
	}

	public void updateToName() {
		nameText.setPropertyDataSource(personBean.getItemProperty("name"));
	}

	public void updateToAge() {
		ageText.setPropertyDataSource(personBean.getItemProperty("age"));
	}

	public void updateToGender() {
		genderOption.setPropertyDataSource(personBean.getItemProperty("gender"));
	}

	public void updateToIsMarried() {
		maritalCheck.setPropertyDataSource(personBean.getItemProperty("isMarried"));
	}


	public BeanItem<Person> getPersonBean() { 
		return personBean;
	}

	public void setPersonBean(BeanItem<Person> personBean) { 
		this.personBean = personBean;
	}

	public void propertyChange(PropertyChangeEvent event) { //PropertyChangelistener abstract method; gets called when the bound property is changed and has PropertyChangeEvent argument that has details about an event source and the property that has changed
//		propChangeSupp.firePropertyChange(event);
		if (event.getPropertyName().equals("id")) { 
			applyToId();
//			System.out.println("Id: " +person.getId());
		}
		else if (event.getPropertyName().equals("name")) {
			applyToName();
//			System.out.println("Name: " +person.getName());
		}
		else if (event.getPropertyName().equals("age")) {
			applyToAge();
//			System.out.println("Age: " +person.getAge());
		}
		else if (event.getPropertyName().equals("gender")) {
			applyToGender();
//			System.out.println("Gender: " +person.getGender());
		}
		else if (event.getPropertyName().equals("isMarried")){
			applyToIsMarried();
//			System.out.println("Marital Status: " +person.getIsMarried());
		}
		setPersonBean();
		System.out.println(person);
	}
	
	//	nameText.addListener(new TextChangeListener() { //listener to show any change of text field component in console
	//		@Override
	//		public void textChange(TextChangeEvent event) {
	////			person.setName(event.getText().toString());
	//			System.out.println(event.getText().toString());
	//			//System.out.println(person.getName());
	//		}
	//	});
	//	

	//	nameText.addListener(new ValueChangeListener() { //listener to show change after clicking outside the component
	//
	//		@Override
	//		public void valueChange(ValueChangeEvent event) {
	//
	//			person.setName(event.getProperty().toString());
	//			System.out.println("Person set:"+event.toString());
	//		}
	//	});
}
