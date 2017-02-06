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
	
	private static int MAXX = 5;
	private static int MINX = 0;
	
	private static int MAXY = 5;
	private static int MINY = 0;
	
	/**
	 * run any input commands
	 * @param command
	 */
	public void run(String command){
		if(command == null || command.trim().length() == 0){
			writeLog(ERROR);
			return;
		}
		// avoid common input errors
		command = command.toUpperCase().trim();
		
		// PLACE command
		if(command.contains(" ")){
			String tempCommand[] = command.split(" ");
			if(tempCommand.length != 2){
				writeLog(ERROR);
				return;
			}
			
			try{
				// Exception catch when Integer/Directions/Actions converting error
				if(Actions.valueOf(tempCommand[0]) == Actions.PLACE){
					String furtherCmd[] = tempCommand[1].split(SPLIT);
					if(furtherCmd.length != 3){
						writeLog(ERROR);
						return;
					}else{
						actionPlace(Integer.parseInt(furtherCmd[0]), Integer.parseInt(furtherCmd[1]), Directions.valueOf(furtherCmd[2]));
					}
				}else{
					// Automatically initialize
					initRobot(MAXX, MINX, MAXY, MINY, Directions.NORTH, 0, 0);
					writeLog(ERROR);
					return;
				}
			}catch(Exception ex){
				writeLog(ERROR);
				ex.printStackTrace();
				return;
			}
		}
		// Other single action commands
		else{
			
			try{
				// Exception catch when actions converting error
				Actions action = Actions.valueOf(command);
				switch(action){
				case LEFT:
					actionLeft();
					break;
				case RIGHT:
					actionRight();
					break;
				case MOVE:
					actionMove();
					break;
				case REPORT:
					actionReport();
					break;
				default:
					writeLog(ERROR);
					break;
				}
			}catch(Exception ex){
				writeLog(ERROR);
				ex.printStackTrace();
				return;
			}
		}
		
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
	 * Place robot
	 */
	private void actionPlace(int x, int y, Directions d){
		// protect place command 
		x = x>MAXX ? MAXX:x;
		y = y>MAXY ? MAXY:y;
		d = d==null? Directions.NORTH:d; 
		
		initRobot(MAXX, MINX, MAXY, MINY, d, x, y);
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
	 * @return report [testable]
	 */
	private void actionReport(){
		StringBuilder reportstr = new StringBuilder();
		reportstr.append(String.valueOf(currentX)).append(SPLIT)
			  .append(String.valueOf(currentY)).append(SPLIT)
			  .append(String.valueOf(currentD));
		report = reportstr.toString();
		writeLog(report);
	}
	
	public String getReport(){
		return report;
	}
	
	/**
	 * Output related message when necessary
	 */
	private void writeLog(String s){
		System.out.println(s);
	}
}
