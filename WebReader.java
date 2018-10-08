package english.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WebReader {

	public static void randomWiki() {
		URL random = null;
		BufferedReader in = null;
		
		try {
			random = new URL("https://en.wikipedia.org/wiki/Special:Random");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		try {
			in = new BufferedReader(new InputStreamReader(random.openStream()));
			
			String inputLine;
			String[] regex = {"<p>", "</p>"};
			while((inputLine = in.readLine()) != null) {
				if(inputLine.contains("<p>") && !(inputLine.contains("<a") || inputLine.contains("<br")
						|| inputLine.contains("<b>") || inputLine.contains("<small>") || inputLine.contains("<i>")
						|| inputLine.contains("<big>") || inputLine.contains("<div") || inputLine.contains("<span")
						)) {
					inputLine = new WebReader().removeAll(regex, inputLine);
					System.out.println(inputLine);
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	String removeAll(String[] regex, String str) {
		for(String i : regex)
			str = str.replaceAll(i, "");
		
		return str;
	}
}
