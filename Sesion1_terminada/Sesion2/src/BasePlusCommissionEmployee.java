// Fig. 9.6: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class represents an employee that receives
// a base salary in addition to commission.

public class BasePlusCommissionEmployee
{
   private CommissionEmployee e;
   private double baseSalary; // base salary per week
   
   // six-argument constructor
   public BasePlusCommissionEmployee( String first, String last, 
      String ssn, double sales, double rate, double salary )
   {
	   e = new CommissionEmployee(first, last, ssn, sales, rate);
	   
      // implicit call to Object constructor occurs here
      setFirstName(first);
      setLastName(last);
      setSocialSecurityNumber(ssn);
      setGrossSales( sales ); // validate and store gross sales
      setCommissionRate( rate ); // validate and store commission rate
      setBaseSalary( salary ); // validate and store base salary
   } // end six-argument BasePlusCommissionEmployee constructor

   // set first name
   public void setFirstName( String first )
   {
      e.setFirstName(first); // should validate
   } // end method setFirstName

   // return first name
   public String getFirstName()
   {
      return e.getFirstName();
   } // end method getFirstName

   // set last name
   public void setLastName( String last )
   {
      e.setLastName(last); // should validate
   } // end method setLastName

   // return last name
   public String getLastName()
   {
      return e.getLastName();
   } // end method getLastName

   // set social security number
   public void setSocialSecurityNumber( String ssn )
   {
      e.setSocialSecurityNumber(ssn);; // should validate
   } // end method setSocialSecurityNumber

   // return social security number
   public String getSocialSecurityNumber()
   {
      return e.getSocialSecurityNumber();
   } // end method getSocialSecurityNumber

   // set gross sales amount
   public void setGrossSales( double sales )
   {
      e.setGrossSales(( sales < 0.0 ) ? 0.0 : sales);
   } // end method setGrossSales

   // return gross sales amount
   public double getGrossSales()
   {
      return e.getGrossSales();
   } // end method getGrossSales

   // set commission rate
   public void setCommissionRate( double rate )
   {
      e.setCommissionRate(( rate > 0.0 && rate < 1.0 ) ? rate : 0.0);
   } // end method setCommissionRate

   // return commission rate
   public double getCommissionRate()
   {
      return e.getCommissionRate() ;
   } // end method getCommissionRate

   // set base salary
   public void setBaseSalary( double salary )
   {
      baseSalary = ( salary < 0.0 ) ? 0.0 : salary;
   } // end method setBaseSalary

   // return base salary
   public double getBaseSalary()
   {
      return baseSalary;
   } // end method getBaseSalary

   // calculate earnings
   public double earnings()
   {
      return baseSalary + ( e.getCommissionRate() * e.getGrossSales() );
   } // end method earnings

   // return String representation of BasePlusCommissionEmployee
   @Override // indicates that this method overrides a superclass method
   public String toString()
   {
      return String.format( 
         "%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f\n%s: %.2f", 
         "base-salaried commission employee", e.getFirstName(), e.getLastName(), 
         "social security number", e.getSocialSecurityNumber(), 
         "gross sales", e.getGrossSales(), "commission rate", e.getCommissionRate(), 
         "base salary", baseSalary );
   } // end method toString
} // end class BasePlusCommissionEmployee


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
