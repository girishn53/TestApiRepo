package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;

public class TestDataBuild {

	public AddPlace addPlace(String name, String language, String address) {
		AddPlace p = new AddPlace();

		p.setAccuracy(10);
		p.setAddress(address);
		p.setWebsite(".com");
		p.setPhone_number("988755673");
		p.setLanguage(language);
		p.setName(name);

		pojo.Location l = new pojo.Location();

		l.setLat(2933.94);
		l.setLng(844.45);

		p.setLocation(l);

		List<String> mylist = new ArrayList<String>();

		mylist.add("shoe park");
		mylist.add("shop");

		p.setTypes(mylist);

		return p;

	}

	public String deletePlace(String placeId) {

		
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}

}
