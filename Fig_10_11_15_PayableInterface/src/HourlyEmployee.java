
public class HourlyEmployee extends Employee{
	private double wage; 
    private double hours; 

    // Constructor
    public HourlyEmployee(String first, String last, String ssn, double wage, double hours) {
        super(first, last, ssn);  
        this.wage = wage;
        this.hours = hours;
    }

    
    @Override
    public double getPaymentAmount() {
    	double regularPay;
    	double overtimePay;
        if (hours <= 40) {
            return wage * hours;  
        } else {
            regularPay = wage * 40;
            overtimePay = (hours - 40) * wage * 1.5;
            return regularPay + overtimePay;  
        }
    }

    
    @Override
    public String toString() {
        return super.toString() + String.format("\nHourly employee with wage: %.2f and hours worked: %.2f", wage, hours);
    }
}
