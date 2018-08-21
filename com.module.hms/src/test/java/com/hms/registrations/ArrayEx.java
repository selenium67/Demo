package com.hms.registrations;

import org.testng.annotations.Test;

public class ArrayEx {
	
	
	@Test
	public void arrayDemo() {
		
		int num[] = new int[3];
		
		num[0] = 45;
		num[1] = 67;
		num[2] = 90;
		
		System.out.println(num[0]);
		
		int data[][] = new int[3][2]; // rows and cols
		
		data[0][0] = 89;
		data[0][1] = 67;
		data[1][0] = 46;
		data[1][1] = 79;
		
		
	}

}
