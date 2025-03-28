/**
 * Example using the class Bicycle
 * 
 */

class BicycleDemo {
     public static void main(String[] args) {

          // Create two different Bicycle objects
          Bicycle bike1 = new Bicycle(50,10,2);
          Bicycle bike2 = new Bicycle(50,2*bike1.getSpeed(),2);
          Bicycle bike3 = new Bicycle(bike2);

          // Invoke methods on those objects

          bike1.printStates();

          bike2.setCadence(50);
          bike2.speedUp(10);
          bike2.setGear(2);
          bike2.setCadence(40);
          bike2.speedUp(10);
          bike2.setGear(3);
          bike2.printStates();
          
          bike3.printStates();
     }
}

