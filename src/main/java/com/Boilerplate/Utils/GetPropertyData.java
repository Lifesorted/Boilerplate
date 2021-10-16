package com.Boilerplate.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GetPropertyData {
	
	static Properties properties=new Properties();
	static FileInputStream fileInputStream;
	static File srcFile=new File(System.getProperty("user.dir")+"/TestData/data.properties");
	
	public static Map<String, String> getPropertyData(){
		Map<String, String> propertydata=new HashMap<String, String>();
		try {
			fileInputStream=new FileInputStream(srcFile);
			properties.load(fileInputStream);
			propertydata.put("Base_Url", properties.getProperty("Base_Url"));
			propertydata.put("User_name", properties.getProperty("User_name"));
			propertydata.put("Password", properties.getProperty("Password"));
			propertydata.put("browser", properties.getProperty("browser"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propertydata;
	}
}
