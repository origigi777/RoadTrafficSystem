package Board.pack;
import java.util.ArrayList;

import Traffics.Pack.TrafficLights;

/**
 * this class takes two points and create 2 kinds of junctions: start/end
 */
public class Junction extends Point {
	private ArrayList<Road> enteringRoads;
	private ArrayList<Road> exitingRoads;
	private TrafficLights light;
	
	
	 

	public Junction() {
		super();
		this.enteringRoads = new ArrayList<Road>();
		this.exitingRoads = new ArrayList<Road>();
		light = null;
	}

	//create the junctions 
	public Junction(double x, double y) {
		super(x, y);
		this.enteringRoads = new ArrayList<Road>();
		this.exitingRoads = new ArrayList<Road>();
		this.id = counter;
	}

	public void setId(int id) {
		this.id = id;
	}

	//holds the entrance part of the junctions - vehicles can't exit from those junctions
	public ArrayList<Road> getEnteringRoads() {
		return enteringRoads;
	}

	public void setEnteringRoads(ArrayList<Road> enteringRoads) {
		this.enteringRoads = enteringRoads;
	}

	//holds the end part of the junctions - vehicles can't enter from those junctions
	public ArrayList<Road> getExitingRoads() {
		return exitingRoads;
	}

	public void setExitingRoads(ArrayList<Road> exitingRoads) {
		this.exitingRoads = exitingRoads;
	}

	public void addEnteringRoad(Road road) {
		this.enteringRoads.add(road);
	}

	public void addExitingRoad(Road road) {
		this.exitingRoads.add(road);
	}

	public TrafficLights getLight() {

		return light;
	}

	public void setLight(TrafficLights light) {
		this.light = light;
	}

	//helps with the recognition of the junctions kind
	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Junction " + id;
	}


}
