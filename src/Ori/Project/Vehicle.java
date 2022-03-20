package Ori.Project;

import java.util.Arrays;

import Board.pack.Map;
import Board.pack.Road;
import Traffics.Pack.TrafficLights;

/**
 * holds The  Vehicles behavior
 */
public class Vehicle extends Thread {
	private Map map;
	private int VehiclesID = 0;
	private static int numallcars = 0;
	private String CarsName;
	private Road[] Path;
	private double sum = 0;
	private int speed;
	private int time = 0;
	private int correntroad = 0;
	private DrivingGame drivingeGame;
	private boolean shoudIstillRun = true;
	public TrafficLights trafficlight;

	
	
	public void run() {
		while (shoudIstillRun) {
			time++;
			this.Move();
			try {
				sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	//gets the game rules and the graph road
	public Vehicle(Map map, DrivingGame drivingeGame) {

		this.map = map;
		numallcars++;
		this.VehiclesID = numallcars;
		this.Path = map.Path();
		this.speed = (int) ((Math.random() * (120 - 30)) + 30);
		System.out.println("Creating " + this);
		this.drivingeGame = drivingeGame;

	}


//Helps to stop the Vehicles
	public double calcTimeDrive() {
		return this.time;
	}

	public void setNameCar(String nameCar) {

		this.CarsName = nameCar;

	}

	public String getNameCar() {
		return CarsName;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getSum() {
		return sum;
	}
	public TrafficLights trafficLights() {

		return this.trafficlight;
	}
	
	/**
	 * checks if there is a blocking traffic light on the vehicles
	 *  and stops them until the traffic light release the specific vehicle
	 */
	public void Move() {

		if (this.calcTimeDrive() >= this.Path[correntroad].getLength()) {
			if (this.Path[correntroad].isexitingjunctiongreen()==-1) {
				System.out.println("Vehicle " +this.VehiclesID+ " is wating for green light at Junction "+(this.correntroad+1));
				return;
			}



			if (this.correntroad == this.Path.length - 1 || this.Path[correntroad + 1] == null) {

				System.out.println("the Vehicle " + this.VehiclesID + " arrived to it's destination: "
						+ this.Path[correntroad].getEnd1().toString());
				this.drivingeGame.carCounter();
				shoudIstillRun = false;


			} else {
				this.correntroad++;
				System.out.println("the vehicle " + VehiclesID + " is moving in:" + this.Path[correntroad].toString());
			}

		} else {
			System.out.println("the vehicle " + VehiclesID + " is moving in:" + this.Path[correntroad].toString());
		}
	}

	/**
	 * holds the moving on board massages 
	 */

	@Override
	public String toString() {
		return "Vehicle " + VehiclesID + ", speed=" + speed + ", path: " + Arrays.toString(Path);
	}

	/**
	 * puts the road in [] 
	 */
	public String getPathString() {
		String pelet = "[";
		for (int k = 0; k < this.Path.length; k++) {
			pelet = pelet + this.Path[k].toString();
		}

		return pelet + "]";

	}

	public Map getMap() {
		return map;
	}

	public int getspeed() {
		return this.speed;
	}

	public void setMap(Map map) {
		this.map = map;
	}
}
