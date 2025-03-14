/**
 * Class Bicycle with visibility public and private
 * 
 */

class Bicycle {

       private int cadence = 0;
       private int speed = 0;
       private int gear = 1;
       
    // Constructors
       public Bicycle() {
       }
       
       public Bicycle(int startCadence, int startSpeed, int startGear) {
           cadence = startCadence;
           speed = startSpeed;
           gear = startGear;
       }
       
    public Bicycle(Bicycle original) {
		setCadence(original.getCadence());// TODO Auto-generated constructor stub
		setSpeed(original.getSpeed());
		setGear(original.getGear());
	}

	// Observers
       public int getCadence() {
    	   return cadence;
   	   }
   		
       public int getSpeed() {
    	   return speed;
       }
       
   	   public int getGear() {
   		   return gear;
   	   }
    
    // Modifiers
       public void setCadence(int newValue) {
           if(0 < newValue) cadence = newValue;
       }
       
       public void setSpeed(int newValue) {
    	   if(0 <= newValue) speed = newValue;
       }
       
       public void setGear(int newValue) {
           if(1 <= newValue) gear = newValue;
       }
   	
       public void applyBrake(int decrement) {
           setSpeed(getSpeed() - decrement);
       }
   	
       public void speedUp(int increment) {
    	   setSpeed(getSpeed() - increment);
       }
       

       
    @Override
	public String toString() {
		return "Bicycle [cadence=" + cadence + ", speed=" + speed + ", gear=" + gear + "]";
	}

	// Other observer
       public void printStates() {
    	    System.out.println(" -- Bicycle -- ");
            System.out.println("cadence:"+cadence+" speed:"+speed+" gear:"+gear);
       }
}

