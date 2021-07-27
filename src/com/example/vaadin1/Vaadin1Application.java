package com.example.vaadin1;
import java.util.ArrayList;

import com.vaadin.Application;
import com.vaadin.ui.*;
/**
 * Main application class.
 */
public class Vaadin1Application extends Application {

	@Override
	public void init() {
		
		Window mainWindow = new Window("Vaadin Person Form");
//		BigPerson bigPerson = new BigPerson();
//		BigPersonEditor bigPersonEditor = new BigPersonEditor(bigPerson);
		Person person = new Person();
		PersonEditor personEditor = new PersonEditor(person);
		PersonEditor personEditor1 = new PersonEditor(person);
		personEditor.setPerson(person);
//		personEditor.initUI();
//		mainWindow.addComponent(bigPersonEditor);
		mainWindow.addComponent(personEditor);
		mainWindow.addComponent(personEditor1);
		setMainWindow(mainWindow);
	}

}
