package Resource;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import Resource.DataCenter;
import connect.java.Connection;

public class Floor {
	private int id;
	double xAxis;
	double yAxis;
	int dataCenterId;
	String name;
	String description;
	ArrayList<Rack> racks;
	String URL;
	JSONObject floors = null;

	public Floor(int id) {
		this.id = id;
		dataCenterId = id;
		this.URL = "datacenters/" + dataCenterId + "/floors/" + id;
		Connection c = new Connection();
		floors = c.getInformationResource(URL);

		name = (String)floors.get("name");
		description = (String) floors.get("description");
	}

	public JSONObject getJSON() {
		return floors;
	}
	
	public void add(){
		this.getClass();
	}

	public int getID() {
		return id;
	}

	public void setId(int x) {
		id = x;
	}

	public double getxAxis() {
		return xAxis;
	}

	public double getyAxis() {
		return yAxis;
	}

	public void setxAxis(double x) {
		xAxis = x;
	}

	public void setyAxis(double y) {
		yAxis = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String s) {
		name = s;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String d) {
		description = d;
	}

	public void addRack(Rack r) {
		racks.add(r);
	}
}
