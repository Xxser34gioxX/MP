// Fig. 9.7: BasePlusCommissionEmployeeTest.java
// BasePlusCommissionEmployee test program.

public class BasePlusCommissionEmployeeMain 
{
   public static void main( String[] args ) 
   {
      // instantiate BasePlusCommissionEmployee object
      BasePlusCommissionEmployee employee = 
         new BasePlusCommissionEmployee( 
         "Bob", "Lewis", "333-33-3333", 5000, .04, 300 );
      
      // get base-salaried commission employee data
      System.out.println( 
         "Employee information obtained by get methods: \n" );
      System.out.printf( "%s %s\n", "First name is",
         employee.getFirstName() );
      System.out.printf( "%s %s\n", "Last name is", 
         employee.getLastName() );
      System.out.printf( "%s %s\n", "Social security number is", 
         employee.getSocialSecurityNumber() );
      System.out.printf( "%s %.2f\n", "Gross sales is", 
         employee.getGrossSales() );
      System.out.printf( "%s %.2f\n", "Commission rate is",
         employee.getCommissionRate() );
      System.out.printf( "%s %.2f\n", "Base salary is",
         employee.getBaseSalary() );

      employee.setBaseSalary( 1000 ); // set base salary
      
      System.out.printf( "\n%s:\n\n%s\n", 
         "Updated employee information obtained by toString", 
         employee.toString() );
      
      BasePlusCommissionEmployee[] empleados = new BasePlusCommissionEmployee[4];
		empleados[0] = new BasePlusCommissionEmployee("Sue", "Jonas", "128-23-2312", 20000.00, .06, 100 );
		empleados[1] = new BasePlusCommissionEmployee("Joni", "Smith", "654-87-3321", 23000, .08, 200);
		empleados[2] = new BasePlusCommissionEmployee("Alice", "Brown", "514-09-0852", 15000, .05, 300);
		empleados[3] = new BasePlusCommissionEmployee("Bob", "David", "843-49-1235", 4000, .10, 400);
   } // end main
   
   public static BasePlusCommissionEmployee maxEarningsEmployee(BasePlusCommissionEmployee[] maxEarningsEmployee) {

		BasePlusCommissionEmployee sueldoMasAlto = maxEarningsEmployee[0];
		for (int i = 1; i < maxEarningsEmployee.length; i++) {
			if (maxEarningsEmployee[i].earnings() > sueldoMasAlto.earnings()) {
				sueldoMasAlto = maxEarningsEmployee[i];
			}
		}

		return sueldoMasAlto;

	}
   
   public static void sortEmployees(BasePlusCommissionEmployee[] v) {

		BasePlusCommissionEmployee aux;

		for (int i = 1; i < length - 1; i++) {
			for (int j = 0; j < (length - i); j++) {
				if (v[j].earnings() > v[j + 1].earnings()) {
					aux = v[j];
					v[j] = v[j + 1];
					v[j + 1] = aux;
				} 
			}
		}

	}

} // end class BasePlusCommissionEmployeeTest


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
