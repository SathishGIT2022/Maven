package org.duck;

import java.io.IOException;

import org.fish.BaseClass;

public class SampleDuck extends BaseClass {
	public static void main(String[] args) throws IOException {
//		browserLaunch();
//		windowMax();
//		launchUrl("https://www.facebook.com/");
//		pageTitle();
		
		//Row
		createExcel(0,0,"Names");
		createRow(1,0,"John");
		createRow(2,0,"Selva");
		createRow(3,0,"Bharath");
		createRow(4,0,"Prem");
		createRow(5,0,"Siva");
		createRow(6,0,"Clement");
		createRow(7,0,"Joel");
		createRow(8,0,"Dinesh");
		createRow(9,0,"Praveen");
		createRow(10,0,"Koli");
		createRow(11,0,"Dhoni");
		
		//Cell
		createCell(0, 1, "Course");
		createCell(1, 1, "AWS");
		createCell(2, 1, "Java");
		createCell(3, 1, "SQL");
		createCell(4, 1, "Phython");
		createCell(5, 1, "PHP");
		createCell(6, 1, "Selenium");
		createCell(7, 1, "Framework");
		createCell(8, 1, "DotNet");
		createCell(9, 1, "JavaScript");
		createCell(10, 1, "CoreJava");
		createCell(11, 1, "Cloud");
		
		
		
		
		
		
		
		
		
		
	}

}
