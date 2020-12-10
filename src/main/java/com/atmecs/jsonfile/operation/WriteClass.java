package com.atmecs.jsonfile.operation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteClass {
	JSONObject employee;
		JSONObject data;

		public JSONObject getData(int id, String name, String department, String designation, String salary) {
			employee = new JSONObject();
			employee.put("Id", id);
			employee.put("Name", name);
			employee.put("Department", department);
			employee.put("Desigantion", designation);
			employee.put("Salary", salary);

			return employee;
		}

		public JSONObject writeData() throws IOException {

			Scanner scan = new Scanner(System.in);
			JSONArray record = new JSONArray();
			System.out.println("Enter the Number of records you want to Add: ");
			int recordCount = scan.nextInt();
			for (int i = 1; i <= recordCount; i++) {
				System.out.println("Enter record " + i);
				System.out.println("=========================================");
				System.out.println("Enter Id: ");
				int id = scan.nextInt();
				System.out.println("Enter the Name: ");
				String name = scan.next();
				System.out.println("Enter the Department: ");
				String department = scan.next();
				System.out.println("Enter the Designation: ");
				String designation = scan.next();
				System.out.println("Enter the Salary: ");
				String salary = scan.next();

				record.add(getData(id, name, department, designation, salary));
				data = new JSONObject();
				data.put("Employees", record);
				// System.out.println(data);
				System.out.println("Record Created..!!");
				System.out.println("========================================================");
				
				FileWriter file = new FileWriter(System.getProperty("user.dir") + "/jsonFileWriter.json");

				file.write(data.toJSONString());
				file.close();

			}
			return data;
		}

}
