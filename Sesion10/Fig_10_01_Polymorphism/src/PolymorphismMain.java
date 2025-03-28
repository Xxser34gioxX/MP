// Fig. 10.1: PolymorphismTest.java
// Assigning superclass and subclass references to superclass and
// subclass variables.

public class PolymorphismMain  
{
   public static void main( String[] args ) 
   {
	   
      // assign superclass reference to superclass variable
      CommissionEmployee commissionEmployee = new CommissionEmployee( 
         "Sue", "Jones", "222-22-2222", 10000, .06 );                    

      // assign subclass reference to subclass variable
      BasePlusCommissionEmployee basePlusCommissionEmployee = 
         new BasePlusCommissionEmployee( 
         "Bob", "Lewis", "333-33-3333", 5000, .04, 300 );         

      // invoke toString on superclass object using superclass variable
      System.out.printf( "%s %s:\n\n%s\n\n", 
         "Call CommissionEmployee's toString with superclass reference ",
         "to superclass object", commissionEmployee.toString() );

      // invoke toString on subclass object using subclass variable      
      System.out.printf( "%s %s:\n\n%s\n\n", 
         "Call BasePlusCommissionEmployee's toString with subclass",
         "reference to subclass object", 
         basePlusCommissionEmployee.toString() );

      // POLIMORFISM: invoke toString on subclass object using superclass variable
      CommissionEmployee commissionEmployee2 = 
         basePlusCommissionEmployee; 
      System.out.printf( "%s %s:\n\n%s\n", 
         "Call BasePlusCommissionEmployee's toString with superclass",
         "reference to subclass object", commissionEmployee2.toString() );
      
      CommissionEmployee[] empleados= new CommissionEmployee[] {basePlusCommissionEmployee,commissionEmployee,commissionEmployee2};
	   
	   System.out.println("El empleado que más gana es:" + earnsTheMost(empleados));
	   System.out.print("La lista de empleados ordenada es: " + sortAscending(empleados) );
	   
	   
   } // end main

	public static CommissionEmployee earnsTheMost (CommissionEmployee[] empleados) {
	    if(empleados == null || empleados.length == 0) {
	    	return null;
	    }
	    CommissionEmployee topEarner = empleados[0];
	    for (CommissionEmployee i : empleados) {
	        if (i.earnings() > topEarner.earnings()) {
	            topEarner = i;
	        }
	    }
	    return topEarner;
	}
		//Corregir
	public static CommissionEmployee[] sortAscending(CommissionEmployee[] empleados) {
		 if(empleados == null || empleados.length == 0) {
		    	return null;
		    }
		for (int i = 0; i < empleados.length - 1; i++) {
	        for (int j = i + 1; j < empleados.length; j++) {
	            if (empleados[i].earnings() > empleados[j].earnings()) {
	            	CommissionEmployee aux= empleados[j];
	            	empleados[i] = empleados[j];
	            	empleados[j] = aux;
	            }
	        }
	    }
		
		return empleados;
	}
} // end class PolymorphismTest

/**************************************************************************
 * (C) Copyright 1992-2010 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
