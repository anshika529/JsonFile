package com.atmecs.jsonfile.operation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UpdateJson {
	JSONObject object,index;
	@SuppressWarnings("unchecked")
	public void modify() throws FileNotFoundException, IOException, ParseException
	{
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the index of the Record");
		int indexNo=scan.nextInt();
		System.out.println("Enter the field to modify:");
		String field=scan.next();
		System.out.println("Enter the value to be modified: ");
		String value=scan.next();
		JSONParser parser=new JSONParser();
		String file=System.getProperty("user.dir")+"/jsonFileWriter.json";
		 JSONObject object=(JSONObject)parser.parse(new FileReader(file));
		JSONArray array=(JSONArray)object.get("Employees");
		 
		 index=(JSONObject) array.get(indexNo);
		
		 if(index.containsKey(field))
		 {
			 index.put(field, value);
		
			 System.out.println(index);
			 
FileWriter fw=new FileWriter(file);
fw.write(object.toJSONString());
fw.close();
		 }

		 
		
		 
	}
	
}
