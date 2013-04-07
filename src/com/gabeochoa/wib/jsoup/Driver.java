package com.gabeochoa.wib.jsoup;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args)
	{
		DataGatherer da = new DataGatherer();
		Scanner s = new Scanner(System.in);
		//ArrayList<String> aboutContent = da.getAbout();
		
		ArrayList<Person> members = da.getPeople();
		for(Person p: members)
		{
			System.out.println(p.getName());
			System.out.println(p.getPosition());
			System.out.println(p.getPictureUrl());
			System.out.println("\n");
		}
		
		//System.out.println("Hit Enter!");
		s.nextLine();
		
		GetFacebookFeed.main(null);
		
	}
	
	
	
}
