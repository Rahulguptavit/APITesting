package GoogleAPIResources;
import java.util.ArrayList;
import java.util.List;

import PoJo.Location;
import PoJo.Place;

public class Resources {

	 public Place AddPlaceData(String name, String address, String language) {
		 Place p= new Place();
		 Location l= new Location();
		 l.setLat(-38.383494);
		 l.setLng(33.427362);
		 p.setLocation(l);
		 p.setAccuracy(50);
		 p.setName(name);
		 p.setPhone_number("(+91) 983 893 3937");
		 p.setAddress(address);
		 List<String> type=new ArrayList<String>();
		 type.add("shoe park");
		 type.add("shop");
		 p.setTypes(type);
		 p.setWebsite("http://google.com");
		 p.setLanguage(language);
		 return p;
	 }
	 
	 public String deletedata(String place_id) {
		 return "{\r\n"
		 		+ "    \"place_id\":\""+place_id+"\"\r\n"
		 		+ "}\r\n"
		 		+ "";
	 }
}
