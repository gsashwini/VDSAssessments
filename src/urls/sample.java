package urls;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class sample {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			Object obj = parser.parse(new FileReader("ResultOfJson//assessments1.json"));
			System.out.println(obj);
		} catch(Exception ex) {
			
		}
	}

}
