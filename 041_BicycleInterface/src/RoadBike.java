
public class RoadBike extends Bicycle implements Driveable{
	private int tireWidth; // In millimeters (mm)

	  public RoadBike(int startCadence, int startSpeed, int startGear, int newTireWidth){
	    super();
	    this.setTireWidth(newTireWidth);
	  }

	  public int getTireWidth(){
	    return this.tireWidth;
	  }

	  public void setTireWidth(int newTireWidth){
	    this.tireWidth = newTireWidth;
	  }

	  public void printStates(){
		System.out.println(" -- RoadBike -- ");  
	    super.printStates();
	    System.out.println("The RoadBike has " + getTireWidth()
	            + " MM tires.");
	  }
}
