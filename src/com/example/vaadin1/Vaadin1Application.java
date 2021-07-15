package com.example.vaadin1;

import com.vaadin.Application;
import com.vaadin.ui.*;

/**
 * Main application class.
 */
public class Vaadin1Application extends Application {

	@Override
	public void init() {
		Window mainWindow = new Window("Vaadin1 Application");
		HorizontalLayout hL=new HorizontalLayout();
		PersonEditor personEditor = new PersonEditor();
		//personEditor.initUI();
		hL.addComponent(personEditor);
		mainWindow.addComponent(hL);
		setMainWindow(mainWindow);
	}

}

