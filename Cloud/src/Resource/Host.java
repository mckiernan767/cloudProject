package Resource;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import connect.java.Connection;

public class Host {
	private int id;
	public int rackId;
	public int moduleGroupId;
	String name;
	String description;
	String hostType;
	String URL;
	double IP;

	JSONObject host;
	JSONObject activity;

	public Host(int id) {
		this.id = id;
		rackId = id;
		this.URL = "datacenters/" + rackId + "/floors/" + rackId + "/racks/"
				+ rackId + "/hosts/" + id;
		Connection c = new Connection();
		host = c.getInformationResource(URL);

		name = (String) host.get("name");
		description = (String) host.get("description");
	}

	public JSONObject getJSON() {
		return host;
	}

	public JSONObject getActivity(long startTime, long endTime) {
		// this.id = id;
		rackId = id;
		this.URL = "datacenters/" + 1 + "/floors/" + 1 + "/racks/" + 1
				+ "/hosts/" + 1 + "/activity?starttime=" + startTime
				+ "&endtime=" + endTime;
		Connection c = new Connection();
		activity = c.getInformationResource(URL);

		return activity;
	}

	public void getArray(int id, long startTime, long endTime) {
		activity = getActivity(startTime, endTime);
		JSONObject structure = (JSONObject) activity.get("activity");
		JSONObject jo = (JSONObject) structure.get("apps");
		System.out.println("j" + jo);
		System.out.println("description: " + structure.get("powerMode"));
		System.out.println("description: " + jo.get("name"));

		JSONArray arr = (JSONArray) jo.get("app");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println("first" + arr.get(i));
		}

		Iterator i = arr.iterator();
		// take each value from the json array separately
		JSONObject innerObj = null;
		while (i.hasNext()) {
			innerObj = (JSONObject) i.next();
			System.out.println("application " + innerObj.get("name")
					+ " with cpu " + innerObj.get("cpu"));
		}
	}

	// Host host1 = new Host();
	// host1.setID((int)innerObj.get("appId"));

	public int getID() {
		return id;
	}

	public void setID(int x) {
		id = x;
	}

	public int getRackID() {
		return rackId;
	}

	public void setRackID(int x) {
		rackId = x;
	}

	public int getModuleGroupID() {
		return moduleGroupId;
	}

	public void setModuleGroupID(int x) {
		moduleGroupId = x;
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

	public String getHostType() {
		return hostType;
	}

	public void setHostType(String d) {
		hostType = d;
	}

	public double getIP() {
		return IP;
	}

	public void setIP(int x) {
		IP = x;
	}
}
