package Resource;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import connect.java.Connection;

public class Rack {

	private int id;
	ArrayList<Host> hosts;
	int floorID;
	String name;
	String description;
	double xAxis;
	double yAxis;
	JSONObject rack;
	String URL;
	
	public Rack(int id) {
		this.id = id;
		floorID = id;
		this.URL = "datacenters/" + floorID + "/floors/" + floorID + "/racks/" + id;
		Connection c = new Connection();
		rack = c.getInformationResource(URL);

		name = (String)rack.get("name");
		description = (String) rack.get("description");
	}

	public JSONObject getJSON() {
		return rack;
	}
	

	public int getID() {
		return id;
	}

	public void setId(int x) {
		id = x;
	}

	public int getFloorID() {
		return floorID;
	}

	public void setFloorId(int f) {
		floorID = f;
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
	
	public void addHost(Host h){
		hosts.add(h);
	}

}
