package sample.calendar;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.extensions.EventEntry;
import com.google.gdata.data.extensions.EventFeed;
import com.google.gdata.data.extensions.When;
import com.google.gdata.util.ServiceException;

public class GetCalendar {

	public static void main(String[] args)
	{
		
		URL feedUrl = null;
		try {
			feedUrl = new URL(" http://www.google.com/calendar/feeds/WinB%40binghamtonsa.org/public/full");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				CalendarService myService = new CalendarService("WIB Calendar");

				// Send the request and receive the response:
				EventFeed myFeed = null;
				try {
					myFeed = myService.getFeed(feedUrl, EventFeed.class);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// Print the title of the returned feed:
				System.out.println(myFeed.getTitle().getPlainText());
				List<EventEntry> list = myFeed.getEntries();
				for(EventEntry ee: list)
				{
					System.out.println(ee.getTitle().getPlainText());
					System.out.println(ee.getPlainTextContent());
					for(When w: ee.getTimes())
					{
						System.out.println(w.getStartTime().toUiString());
						System.out.println(w.getEndTime().toUiString());
					}
					
				}
	}
}
