package rea.robot;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for robot.
 * @author Tony
 * @version 0.1
 */
public class AppTest  extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * testRobot_Normal_Move
     */
    public void testRobot_Normal_Move()
    {
        Robot robot = new Robot();
        robot.run("PLACE 0,0,NORTH");
        robot.run("MOVE");
        robot.run("REPORT");
        assertEquals(robot.getReport(), "0,1,NORTH");
    }
    /**
     * testRobot_Normal_Move
     */
    public void testRobot_Normal_Left()
    {
        Robot robot = new Robot();
        robot.run("PLACE 0,0,NORTH");
        robot.run("LEFT");
        robot.run("REPORT");
        assertEquals(robot.getReport(), "0,0,WEST");
    }
    /**
     * testRobot_Normal_Move
     */
    public void testRobot_Normal_Mix()
    {
        Robot robot = new Robot();
        robot.run("PLACE 1,2,EAST");
        robot.run("MOVE");
        robot.run("MOVE");
        robot.run("left");
        robot.run("MOVE");
        robot.run("REPORT");
        assertEquals(robot.getReport(), "3,3,NORTH");
    }
    
    /**
     * testRobot_Normal_Move
     */
    public void testRobot_ABNormal_Move()
    {
        Robot robot = new Robot();
        robot.run("PLACE 1,1,NORTH");
        robot.run("MOVE");
        robot.run("MOVE");
        robot.run("MOVE");
        robot.run("MOVE");
        robot.run("MOVE");
        robot.run("REPORT");
        assertEquals(robot.getReport(), "1,5,NORTH");
    }
    /**
     * testRobot_ABNormal_Place
     */
    public void testRobot_ABNormal_Place()
    {
        Robot robot = new Robot();
        robot.run("PLACE 10,1,NORTH");
        robot.run("MOVE");
        robot.run("MOVE");
        robot.run("MOVE");
        robot.run("REPORT");
        assertEquals(robot.getReport(), "5,4,NORTH");
    }
    
    /**
     * testRobot_ABNormal_Place
     */
    public void testRobot_ABNormal_Input()
    {
        Robot robot = new Robot();
        robot.run("PLACED 10,1,NORTH");
        robot.run("MOVE");
        robot.run("MOVE");
        robot.run("MOVE");
        robot.run("REPORT");
        assertEquals(robot.getReport(), "0,3,NORTH");
    }
    
    /**
     * testRobot_ABNormal_Place
     */
    public void testRobot_ABNormal_Input2()
    {
        Robot robot = new Robot();
        robot.run("PLACE 1,1,SOUTH");
        robot.run("MOVED");
        robot.run("MOV E");
        robot.run(" MOVE");
        robot.run("REPORT");
        assertEquals(robot.getReport(), "1,0,SOUTH");
    }
}
