package rea.robot;

import java.util.Scanner;

/**
 * Robot main entrance
 * @author Tony
 * @version 0.1
 */
public class App 
{
	@SuppressWarnings("resource")
	public static void main(String args[]){
        Robot robot = new Robot();
        Scanner scan = new Scanner(System.in);
        String command = null;
        while((command = scan.nextLine()) != null){
            robot.run(command.toUpperCase().trim());
        }
    }
}
