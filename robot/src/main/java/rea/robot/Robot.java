package rea.robot;

/**
 - The application is a simulation of a toy robot moving on a square table top, 
   of dimensions 5 units x 5 units.
 - There are no other obstructions on the table surface.
 - The robot is free to roam around the surface of the table, but must be
   prevented from falling to destruction. Any movement that would result in the
   robot falling from the table must be prevented, however further valid
   movement commands must still be allowed.
 * @author Tony
 * @version 0.1
 */
public class Robot {
	
	private int maxX;
	private int minX;
	
	private int maxY;
	private int minY;
	
	private enum Directions {EAST, WEST, SOUTH, NORTH};
	private enum Actions {LEFT, RIGHT, MOVE, REPORT, PLACE};
	
	private int currentX;
	private int currentY;
	private Directions currentD;
	
	private String report;
	
	private static final String SPLIT = ",";
	private static final String ERROR = "Error input, ignored and continue...";
	
	/**
	 * run any input commands
	 * @param commands
	 */
	private void run(String command){
		
	}
	
	/**
	 * Initialize this robot
	 * @param maxX
	 * @param minX
	 * @param maxY
	 * @param minY
	 * @param d
	 * @param currentX
	 * @param currentY
	 */
	private void initRobot(int maxX, int minX, int maxY, int minY, Directions d, int currentX, int currentY){
		this.maxX = maxX;
		this.maxY = maxY;
		
		this.minX = minX;
		this.minY = minY;
		
		this.currentD = d;
		
		this.currentX = currentX;
		this.currentY = currentY;
	}
	
	/**
	 * Turn left
	 */
	private void actionLeft(){
		switch(currentD){
		case NORTH:
			currentD = Directions.WEST;
			break;
		case SOUTH:
			currentD = Directions.EAST;
			break;
		case EAST:
			currentD = Directions.NORTH;
			break;
		case WEST:
			currentD = Directions.SOUTH;
			break;
		default:
			writeLog(ERROR);
			break;
		}
	}
	
	/**
	 * Turn right
	 */
	private void actionRight(){
		switch(currentD){
		case NORTH:
			currentD = Directions.EAST;
			break;
		case SOUTH:
			currentD = Directions.WEST;
			break;
		case EAST:
			currentD = Directions.SOUTH;
			break;
		case WEST:
			currentD = Directions.NORTH;
			break;
		default:
			writeLog(ERROR);
			break;
		}
	}
	
	/**
	 * Move ahead one step
	 */
	private void actionMove(){
		switch(currentD){
		case NORTH:
			if(currentY >= maxY){
				writeLog(ERROR);
				return;
			}
			currentY = currentY+1;
			break;
		case SOUTH:
			if(currentY <= minY){
				writeLog(ERROR);
				return;
			}
			currentY = currentY-1;
			break;
		case EAST:
			if(currentX >= maxX){
				writeLog(ERROR);
				return;
			}
			currentX = currentX+1;
			break;
		case WEST:
			if(currentX <= minX){
				writeLog(ERROR);
				return;
			}
			currentX = currentX-1;
			break;
		default:
			writeLog(ERROR);
			break;
		}
	}
	
	/**
	 * Report current location
	 * @return 
	 */
	private String actionReport(){
		StringBuilder report = new StringBuilder();
		report.append(String.valueOf(currentX)).append(SPLIT)
			  .append(String.valueOf(currentY)).append(SPLIT)
			  .append(String.valueOf(currentD));
		
		return report.toString();
	}
	
	/**
	 * Output related message when necessary
	 */
	private void writeLog(String s){
		System.out.print(s);
	}
}
