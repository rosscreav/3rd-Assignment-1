// Driver for Employee hierarchy

// Java core packages
import java.text.DecimalFormat;
// Java extension packages
import javax.swing.JOptionPane;
//ArrayList
import java.util.ArrayList;
//My Details
//ID:17473436
//Name:Ross Creaven

public class Test {
	

    // test Employee hierarchy
    public static void main(String args[]) throws Minimum_Wage_Exception {
        Employee employee; // superclass reference
        String output = "";
 

        //Creating all Employees
        Boss boss = new Boss("John", "Smith","2014-04-02", 800.0);
        CommissionWorker commissionWorker = new CommissionWorker("Sue", "Jones","2010-06-27", 400.0, 3.0, 150);
        PieceWorker pieceWorker = new PieceWorker("Bob", "Lewis","2009-01-06", 2.5, 150);
        HourlyWorker hourlyWorker = new HourlyWorker("Karen", "Price","2016-03-16", 9.70, 40);
        DecimalFormat precision2 = new DecimalFormat("0.00");
       
        //Array of all Employees
    	Employee[] Employee_Array=new Employee[4];
    	//Creating arraylist to hold below minmum wage workers
    	ArrayList<Employee> Exception_Encountered=new ArrayList<Employee>();
    	
        //Array Assignment
        Employee_Array[0]= boss;
        Employee_Array[1]= commissionWorker;
        Employee_Array[2]= pieceWorker;
        Employee_Array[3]= hourlyWorker;

        //Array Loop to calculate earnings
        for(Employee i:Employee_Array) {
        	try {
        		//Try calculate wage and check for min wage
        		i.earnings();}
        	catch(Exception Minimum_Wage_Exception) {
        		//if encounters min wage then throw exception and set pay to min and try apply bonus
        		Exception_Encountered.add(i);
        		Minimum_Wage_Exception.printStackTrace();
        		i.set_Payable(400);
        		i.bonus_check();
        	}
        }

        // Employee reference to a Boss
        employee = boss;
        output += employee.toString() + " earned $"
                + precision2.format(employee.get_Payable()) + "\n"
                + boss.toString() + " earned $"
                + precision2.format(boss.get_Payable()) + "\n";

        // Employee reference to a CommissionWorker
        employee = commissionWorker;
        output += employee.toString() + " earned $"
                + precision2.format(employee.get_Payable()) + "\n"
                + commissionWorker.toString() + " earned $"
                + precision2.format(
                commissionWorker.get_Payable()) + "\n";

        // Employee reference to a PieceWorker
        employee = pieceWorker;
        output += employee.toString() + " earned $"
                + precision2.format(employee.get_Payable()) + "\n"
                + pieceWorker.toString() + " earned $"
                + precision2.format(pieceWorker.get_Payable()) + "\n";

        // Employee reference to an HourlyWorker
        employee = hourlyWorker;
        output += employee.toString() + " earned $"
                + precision2.format(employee.get_Payable()) + "\n"
                + hourlyWorker.toString() + " earned $"
                + precision2.format(hourlyWorker.get_Payable()) + "\n";
        
        //Joption pane for demenstaring polymorphism
        JOptionPane.showMessageDialog(null, output,"Demonstrating Polymorphism",JOptionPane.INFORMATION_MESSAGE);
        
        //My JOptionPane Output for employee being underpaid
        output="";
        for(Employee i:Exception_Encountered) {
        	if(i.equals(null)==false) {
        		output+=i.toString()+" was earning below minimum wage they have had their Payable ajusted to "
        			   +i.get_Payable()+"\n";
        	}
        }
        JOptionPane.showMessageDialog(null, output,"Exceptions Encountered",JOptionPane.INFORMATION_MESSAGE);
        

        System.exit(0);
    }
} // end class Test
