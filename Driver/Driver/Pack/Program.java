package Driver.Pack;

import java.util.ArrayList;
import Board.pack.Junction;
import Board.pack.Map;
import Board.pack.Road;
import Ori.Project.DrivingGame;

/**
 * @author Ori Gigi
 */
public class Program {
	public static void main(String[] args) {
		
		System.out.println("\n=========Creating the map=========");
		
		//creating board for the vehicles
		ArrayList<Junction> junctions=new ArrayList<Junction>();
		junctions.add(new Junction(0, 0));
		junctions.add(new Junction(0, 3));
		junctions.add(new Junction(4, 3));
		junctions.add(new Junction(4, 0));
		ArrayList<Road>roads=new ArrayList<Road>();
		roads.add(new Road(junctions.get(0), junctions.get(1)));
		roads.add(new Road(junctions.get(1), junctions.get(2)));
		roads.add(new Road(junctions.get(2), junctions.get(3)));
		roads.add(new Road(junctions.get(3), junctions.get(0)));
		roads.add(new Road(junctions.get(0), junctions.get(2)));
		Map map=new Map(junctions, roads);
		System.out.println(map.calcShortestPath(map.getJunctions().get(0), map.getJunctions().get(3)));
			
		
		System.out.println("\n===========Starting the game============\n");
		//creates the vehicles and sets a limit to the number of roads to pass 
		DrivingGame game=new DrivingGame(10, 5);
		game.play();
	}



}


