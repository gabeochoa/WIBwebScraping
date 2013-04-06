package com.gabeochoa.wib.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class GetFacebookFeed {

	//http://www.facebook.com/feeds/page.php?format=atom10&id=249701551756902
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		
		Document wibSite = null;
		String rssFeedLink = "http://www.facebook.com/feeds/page.php?format=atom10&id=249701551756902";
		Document xml = null;
		try {
			xml = Jsoup.connect(rssFeedLink).ignoreContentType(true).get();
			wibSite = Jsoup.parse(xml.toString(), "", Parser.xmlParser());
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		Elements entry = wibSite.select("entry");
		
		Elements titles = wibSite.select("title");
		
		Elements contents = wibSite.select("content[type^=html");
		
		String w;
		String words[];
		
		for(Element e: contents)
		{
			words = e.text().split("\\s+");
			for(int i=0; i<words.length; i++)
			{
				w = words[i];
				if(w.equals("<br") || w.endsWith("<br"))
				{
					w = w.substring(0,w.length()-3);
					words[i] = w+"\n";
				}
				else if(w.equals("/>"))
				{
					words[i] = "";
				}	
				else if(w.contains("&#039;"))
				{
					char[] a = w.toCharArray();
					for(int j =0; j<a.length; j++)
					{
						if( i+2 < a.length &&  a[i] == '&' && a[i+1] == '#')
						{
							a[i] = '\'';
							a[i+1] = 0;
							a[i+2] = 0;
							a[i+3] = 0;
							a[i+4] = 0;
							a[i+5] = 0;
							break;
						}
					}
					
					w = "";
					
					for(char c: a)
					{
						if(c != 0)
							w += c;
					}
					words[i] = w;
				}	
			}
			for(String s: words)
			{
				System.out.print(s+" ");
			}
		}
	
	
	
	}	
	
	
}
