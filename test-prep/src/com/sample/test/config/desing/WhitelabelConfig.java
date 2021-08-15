package com.sample.test.config.desing;

import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class WhitelabelConfig {

	SocietyConfig societyConfig;

	public static void main(String[] args) {
//		WhitelabelConfig config = new WhitelabelConfig();
//		for(WhitelabelItems items : WhitelabelItems.values()){
//			items.updateWhitelabelConfig(config, 3);
//		}
		
//		Calendar.getInstance()
		DocumentBuilderFactory factory=		DocumentBuilderFactory.newInstance();
		factory.getSchema();
		
		
		
	}
}


enum InputTypes {
	TEXTAREA, CHECKBOX, INPUTFIELD;
}


enum WhitelabelItems {

	WEBSITE_NAME(InputTypes.TEXTAREA) {
		@Override
		public void updateWhitelabelConfig(WhitelabelConfig config, int id) {
			System.out.print("websitename");
			System.out.println(config);
		}
	},
	SOCIETY_CONFIG(InputTypes.TEXTAREA) {
		@Override
		public void updateWhitelabelConfig(WhitelabelConfig config, int id) {
			System.out.print("societyConfig");
			System.out.println(config);
		}
	};
	Boolean isTextArea;
	boolean isTextInput;
	boolean isCheckBox;


	WhitelabelItems(InputTypes inputTypes) {
		isTextArea = InputTypes.TEXTAREA.equals(inputTypes);
		isTextInput = InputTypes.INPUTFIELD.equals(inputTypes);;
		isCheckBox = InputTypes.CHECKBOX.equals(inputTypes);;
	}


	public void updateWhitelabelConfig(WhitelabelConfig config, int id) {

	}


}
