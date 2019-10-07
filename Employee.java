//My Imports
import org.joda.time.LocalDate;
import org.joda.time.Years;

// Abstract base class Employee.
//My Details
//ID:17473436
//Name:Ross Creaven


public abstract class Employee {

	//Variables associated with Employees
    private String firstName;
    private String lastName;
    private LocalDate Join_Date;
    //Keeps track of the amount of employees joined
    private static int Employee_Count=0; 
    //Holds the employees ID
    private final int Employee_ID=Employee_Count+1;
    //Holds the amount to be paid to the employee
    private double Payable;

    
    // constructor
    public Employee(String first, String last, String date) {
        firstName = first;
        lastName = last;
        Join_Date= LocalDate.parse(date);
        Employee_Count++;
    }

    // get first name
    public String getFirstName() {
        return firstName;
    }

    // get last name
    public String getLastName() {
        return lastName;
    }
    //get join date
    public LocalDate get_Join_Date() {
    	return Join_Date;
    }
    //get persons id
    public int get_id() {
    	return Employee_ID;
    }
    //get their amount payable
    public double get_Payable() {
    	return Payable;
    }
    //Converts object to a string in format "Firstname Lastname"
    public String toString() {
        return firstName + ' ' + lastName;
    }
    //Sets Payable amount
    public void set_Payable(double i){
    	Payable=i;
    }

    //Method to check if Payable is above 400 (40hours at 10 an hour) and throws exception if it is below it also calls the bonus check
    public double earnings() throws Minimum_Wage_Exception{
    	//checks min wage
    	if((Payable-400)<0) {
    		String message=String.format("Employee %s %s is being paid below minimum wage. Pay=%g while minmum is Pay=400",getFirstName(),getLastName(),get_Payable());
    		throw new Minimum_Wage_Exception(message);
    	}
    	//checks for over 5 years
    	bonus_check();
    	return Payable;
    }
    
    
   
    //Method to check if worker has been here over 5 years and can apply the bonus
    public void bonus_check() {
    	//Checks in the year is over 4 i.e 5 or more and adds the bonus if it is
    	LocalDate date=new LocalDate();
    	Years Diff=Years.yearsBetween(Join_Date,date);
    	int Int_Diff=Diff.getYears();
    	if (Int_Diff>4){
    		Payable=Payable+50.00;
    	}
    	
    	
    }
}
