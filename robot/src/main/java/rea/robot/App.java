package rea.robot;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String args[]){
        Robot robot = new Robot();
        robot.run("PLACE 0,0,NORTH");
        robot.run("MOVE");
        robot.run("REPORT");
    }
}
