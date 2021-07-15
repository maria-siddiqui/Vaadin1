package com.example.vaadin1;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Form;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PersonEditor extends VerticalLayout {
	
	private PropertyChangeEvent propChangeEvent;
	private PropertyChangeListener propChangeListener;
	private PropertyChangeSupport propChangeSupp;

	Person person = new Person();
	BeanItemContainer<Person> container = new BeanItemContainer<Person>(Person.class);
	private BeanItem<Person> item;

	public PersonEditor(Person person){
		this.person = person;
		propChangeSupp = new PropertyChangeSupport(this);
		}
	
	public void setPerson(Person person) {
			Person oldPerson = this.person;
			this.person = person;
			PropertyChangeEvent event = new PropertyChangeEvent(this, "person", oldPerson, person);
			propChangeSupp.firePropertyChange(event);
			System.out.println(person);
			}
	
	public Person getPerson() {
			return person;
	}
	
	TextField idText = new TextField("Enter Id");
	TextField nameText = new TextField("Enter Name");
	TextField ageText = new TextField("Enter Age");
	OptionGroup genderOption = new OptionGroup("Gender");
	Label label = new Label("Marital Status");
	final CheckBox maritalCheck = new CheckBox("Married");
	
	//apply functions will copy from the PersonEditor to the Person bean.
	public void applyToId() { 
		person.setId(Integer.parseInt(idText.getValue().toString()));
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

	public void applyToMaritalStatus() {
		person.setMaritalStatus(maritalCheck.getValue().toString());
	}
	
//	Update functions will copy Person's bean property to Person Editor component.
	public void updateToId() {
		idText.setPropertyDataSource(item.getItemProperty("id"));
	}

	public void updateToName() {
		nameText.setPropertyDataSource(item.getItemProperty("name"));
	}
	
	public void updateToAge() {
		ageText.setPropertyDataSource(item.getItemProperty("age"));
	}

	public void updateToGender() {
		genderOption.setPropertyDataSource(item.getItemProperty("gender"));
	}
	
	public void updateToMaritalStatus() {
		maritalCheck.setPropertyDataSource(item.getItemProperty("maritalStatus"));
	}

	public PersonEditor() {
		super();
		initUI();
		}
	
	PropertyChangeListener propChangeListn = new PropertyChangeListener() {
		
        @Override
        public void propertyChange(PropertyChangeEvent event) {
        	System.out.println("In listener");
            String property = event.getPropertyName();
            System.out.println(property);
            }
        };
        
	public void initUI(){
		idText.setImmediate(true);
		nameText.setMaxLength(15);
		nameText.setImmediate(true);
		ageText.setImmediate(true);
		genderOption.addItem("Male");
		genderOption.addItem("Female");
		genderOption.setImmediate(true);
		maritalCheck.setImmediate(true);
		
		System.out.println("inits");
		maritalCheck.setValue(true);
		System.out.println(maritalCheck.getValue().toString());	
		
		setSpacing(true);
		setMargin(true, true, true, true);
		addComponent(idText);
		addComponent(nameText);
		addComponent(ageText);
		addComponent(genderOption);
		addComponent(label);
		addComponent(maritalCheck);
			
	}
	
}

