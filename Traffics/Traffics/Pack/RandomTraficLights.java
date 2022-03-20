package Traffics.Pack;

import java.util.Random;

import Board.pack.Junction;
import Board.pack.Road;
import Ori.Project.DrivingGame;


/**
 * holds the behaver of this specific kind of traffic light
 * stops vehicles in randomly way
 */
public class RandomTraficLights extends TrafficLights {
	public RandomTraficLights(Junction junction, DrivingGame drivingGame) {
		super(junction, drivingGame);
	}
	

	//Indicator for vehicle's block status 
	public void greenLight() {
		int size = getJunction().getEnteringRoads().size();
		Random random = new Random();
		int index = random.nextInt(size);
		Road road = getJunction().getEnteringRoads().get(index);
		setCurrentGreen(road);
		System.out.println(toString());
		switcher();
if(this.IsGreenLight==1) {
	setCurrentGreen(road);	
		}
	}

	
	public String toString() {
		return "Random " + super.toString();
	}
	
	
	public int getisgreenlight() {
		return IsGreenLight;
		
	}
}
