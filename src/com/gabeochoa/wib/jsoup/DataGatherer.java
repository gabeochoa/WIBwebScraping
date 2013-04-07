package com.gabeochoa.wib.jsoup;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class DataGatherer {

	public String rootURL = null;
	public Document wibSite = null;
	ArrayList<Person> members = null;
	
	ArrayList<String> facebookTitles = null;
	ArrayList<String> facebookContent = null;
	
	public DataGatherer()
	{
		super();
	}
	
	public DataGatherer(String ru)
	{
		super();
		rootURL = ru;
		connectTo(ru);
	}
	
	public boolean connectTo(String ru)
	{
		try {
			wibSite = Jsoup.connect(ru).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wibSite == null;
	}
	public void getAbout()
	{
		if(connectTo("http://www.binghamtonwib.com/about-us/"))
		{
			Elements titles = wibSite.select("h3");
			//NotFinished
		}
	}
	public ArrayList<Person> getPeople()
	{
		members = GetPeople.main(null);
		return members;
	}
	
	public ArrayList<String> getFacebookFeed()
	{
		//Still being worked on
		return null;
	}
}
