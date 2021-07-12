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
		
		Label label1 = new Label("Hello Vaadin user 1");
		Label label2 = new Label("Hello Vaadin user 2");
		hL.addComponent(label1);
		hL.addComponent(label2);
		mainWindow.addComponent(hL);
		setMainWindow(mainWindow);
	}

}

