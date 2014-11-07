package main;

import org.json.simple.JSONObject;

import Resource.DataCenter;
import Resource.Floor;
import Resource.Host;
import Resource.Rack;

public class Main {

	public static void main(String[] args) {

		DataCenter dc = new DataCenter(1);
		Floor fl = new Floor(1);
		Rack rk = new Rack(1);
		Host ht = new Host(1);
		JSONObject x = dc.getJSON();
		JSONObject y = fl.getJSON();
		JSONObject z = rk.getJSON();
		JSONObject h = ht.getJSON();
		JSONObject act = ht.getActivity(1414597400, 1414597480);
		ht.getArray(1, 1414597400, 1414597480);
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(h);
		System.out.println("activity " + act);
		System.out.println("name" + dc.getName());
		System.out.println("id" + dc.getID());
		System.out.println("description" + dc.getDescription());
	}
}