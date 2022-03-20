package Traffics.Pack;

import Board.pack.Junction;
import Board.pack.Road;
import Ori.Project.DrivingGame;

/**
 * holds the behaver of all the traffic lights
 */
public abstract class TrafficLights extends Thread {
	protected int IsGreenLight=1;
	private int dilay;
	private Road currentGreen;
	private Junction newjunction;
	String zen="";
	private DrivingGame drivingGame;
	public boolean booli =false;
	public TrafficLights(Junction junction, DrivingGame drivingGame) {
		this.drivingGame=drivingGame;
		dilay = (int) ((Math.random() * 2) + 2);
		this.newjunction=junction;
		junction.setLight(this);
		greenLight();	
	}


	public void run() {

		while( !drivingGame.isIfTheGameFinish()) {
			try {
				sleep(dilay*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			if (  !drivingGame.isIfTheGameFinish()) {
				greenLight();
			}
		}

	}

	//helps the traffic lights to stop the vehicles 
	protected void switcher() {
		this.IsGreenLight*=-1;
	}
	
	//the indicator for vehicles' stop  
	public int getisgreenlight() {
		return IsGreenLight;
	}


	//traffic lights' stop time 
	public int getDilay() {
		return dilay;
	}
	
	public void setDilay(int dilay) {
		this.dilay = dilay;
	}
	
	
	@Override
	public String toString() {
		return "TrafficLights "+ newjunction+ ", delay= "+ dilay+": green light is  on " + currentGreen;

	}
	
	
	/**
	 * board set objects
	 */
	public Road getCurrentGreen() {
		return currentGreen;
	}
	public void setCurrentGreen(Road currentGreen) {
		this.currentGreen = currentGreen;
	}
	public Junction getJunction() {
		return newjunction;
	}
	public void setJunction(Junction junction) {
		this.newjunction = junction;
	}
	public abstract  void greenLight();
}
