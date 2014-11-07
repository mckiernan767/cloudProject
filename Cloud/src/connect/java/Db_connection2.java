package connect.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.*;

public class Db_connection2 {

	/*public static void main(String[] args) {

		Db_connection2 connection = new Db_connection2();
		//String s = connection.sendData();
		String f = connection.sendData();
		System.out.println(f);
		//String s = "{"appId":"1186","activityId":"396","name":"firefox","cpu":"542.0"}";
		//String s = "{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}";
		
		
		
		
		
		try{
			JSONParser jp=new JSONParser();
			JSONObject j=(JSONObject)jp.parse(f);
			//Object obj = JSONValue.parse(s);
	       //JSONArray array = (JSONArray)obj;
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("name", "eoin");
		System.out.println("json" + jsonObject);
		
			//JSONObject obj = new JSONObject(jsonObject);
	       //JSONArray id = jsonObject.getJSONArray("id");
				// get a String from the JSON object
				//String firstName = (String) jsonObject.get("name");
				//long x = (long) jsonObject.get("cpu");
				
	       //System.out.println(x);
			
	       /*System.out.println("The 2nd element of array");
	         System.out.println(array.get(1));
	         System.out.println();
			 JSONObject obj = new JSONObject();
	         JSONArray array = (JSONArray) obj;
	         System.out.println("The 2nd element of array");
	         System.out.println(array.get(1));
	         System.out.println();

	         JSONObject obj2 = (JSONObject)array.get(1);
	         System.out.println("Field \"1\"");
	         System.out.println(obj2.get("1"));    

	         s = "{}";
	         obj = parser.parse(s);
	         System.out.println(obj);

	         s= "[5,]";
	         obj = parser.parse(s);
	         System.out.println(obj);

	         s= "[5,,2]";
	         obj = parser.parse(s);
	         System.out.println(obj);
	      }catch(Exception pe){
	         System.out.println("position: " + pe);
	         System.out.println(pe);
	      }
	}
*/
	public String sendData() {
		String response = null;
		try {
			// The http access shown below will request the registration data
			// from the master

			String url = String
					.format("http://127.0.0.1:8080/papillonserver/rest/datacenters/");

			// The connections below enables either the default GET = xml or
			// JSON GET
			HttpURLConnection connection = (HttpURLConnection) (new URL(url))
					.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json");

			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out
						.println("not working" + connection.getResponseCode());
				return "not working";
			}
			// start of response now contains the raw data stream sent back from
			// the server
			InputStream inputStream = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			StringBuilder builder = new StringBuilder();

			String inputLine;
			while ((inputLine = reader.readLine()) != null) {
				builder.append(inputLine);
			}
			reader.close();

			response = builder.toString();
			System.out.println("builder" + builder);

			// End of response now contains the raw data stream sent back from
			// the server

		} catch (IOException | NumberFormatException ex) {
			return "exception";
		}
		return response;
	}
}