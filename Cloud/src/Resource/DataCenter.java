package Resource;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import connect.java.Connection;

public class DataCenter {
	private int id;
	String name;
	String description;
	double latitude;
	double longitude;
	String URL;
	JSONObject datacenter;
	ArrayList<Floor> floors;

	public DataCenter(int id) {
		this.id = id;
		this.URL = "datacenters/" + id;
		Connection c = new Connection();
		datacenter = c.getInformationResource(URL);

		name = (String) datacenter.get("name");
		description = (String) datacenter.get("description");

		this.setName(name);
		// TODO Auto-generated constructor stub
		// System.out.println("Dc" + datacenter);
		// getfloors
		//
	}

	public JSONObject getJSON() {
		return datacenter;
	}

	public int getID() {
		return id;
	}

	public void setID(int x) {
		id = x;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String d) {
		description = d;
	}

	public void setLatitude(double x) {
		latitude = x;
	}

	public void setLongitude(double y) {
		longitude = y;
	}

	public void addFloor(Floor f) {
		floors.add(f);
	}
}
