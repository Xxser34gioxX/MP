
public class MountainBike extends Bicycle implements Driveable{
	  private String suspension;

	  public MountainBike(int startCadence, int startSpeed, int startGear, String suspensionType){
	    super();
	    this.setSuspension(suspensionType);
	  }

	  public String getSuspension(){
	    return this.suspension;
	  }

	  public void setSuspension(String suspensionType){
	    this.suspension = suspensionType;
	  }

	  public void printStates(){
		System.out.println(" -- MountainBike -- ");  
	    super.printStates();
	    System.out.println("The MountainBike has a " + getSuspension()
	            + " suspension.");
	  }
}
