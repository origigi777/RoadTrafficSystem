# RoadTrafficSystem
a Java  project I made  - this project contains the most important elements in OOP. I hope the project will help B.sc students to understand the idea of OOP or will give inspiration for other java projects.


the idea of the project is to create a traffic system simulator step by step.
the goal of the vehicles is to cross the roads on the map and arrive at their destination. any vehicle is different from each other, like in real life. 

program  arrangement:

driver part:
1. Program - contains the main method and the selected parameters (number of vehicles and map size).

Board Part:
1. Class Point - creates (x,y) graph points up to 80x80 
2. Class Junction - takes 2 random points and merges them into junctions.
there are 2 kinds of junctions: 'entering' junction or 'exiting' junction
 3. Class Road - takes 2  junctions (entering and exiting) and merges them into roads for the vehicles.
4. Class Map - takes a few roads as the user wants to and merges them into a big map array. - on this map, the whole program will appear.

Traffic-Lights Part:
1. Class Traffic light (abstract class) - creates the traffic lights' behavior for all kinds of traffic lights in the program - the goal of the traffic lights is to stop the vehicles for a little while like real traffic lights.
2. Class Random traffic light - stops random vehicles for a while.
3. Class Permanent traffic - stops the vehicles for a while based on the vehicles' ID size (smallest will stop first).

src part:
1. Class driving game - contains the rules of the whole game. and responsible to stop the threads who still running after the vehicles arrived at the correct destinations.
2. Class Vehicle - holds the vehicle's behavior - any car has:
ID, speed, selected road, running status (green light).
3. Class Timer - presents the program's running time. in seconds and minutes. 
