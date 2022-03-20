package Traffics.Pack;

import Board.pack.Junction;
import Ori.Project.DrivingGame;

/**
 * holds the behaver of this specific kind of traffic light
 * stops vehicles in permanent way - by the rage of the vehicles' ID
 */
public class PermanentTraficLights extends TrafficLights implements Runnable{
	public PermanentTraficLights(Junction junction,DrivingGame drivingGame) {
		super(junction, drivingGame );
	}

	//Indicator for vehicle's block status 
	@Override
	public void greenLight() {
		switcher();
		if(this.IsGreenLight==1) {
			int idnum = this.getJunction().getEnteringRoads().indexOf(this.getCurrentGreen());
			if (idnum + 1 >= this.getJunction().getEnteringRoads().size()) {
				setCurrentGreen(this.getJunction().getEnteringRoads().get(0));
			} else {
				setCurrentGreen(this.getJunction().getEnteringRoads().get(idnum + 1));
			}
			System.out.println(toString());
		}
	}


	@Override
	public String toString() {
		return "permanent " + super.toString();
	}
	public int getisgreenlight() {
		return IsGreenLight;

	}

}
