import java.util.ArrayList;
import java.util.Scanner;

import BUsiness_Tool.Data;
import BUsiness_Tool.Manager;
import BUsiness_Tool.Worker;

import File_ip_op.Catalog_Print;
import File_ip_op.Count_Emp;

import BUsiness_Tool.DataStorage;


public class Main {
    public static void main(String[] args) {

        /*
        ArrayList<Data> Employees = new ArrayList<>();
        Employees.add(new Worker("Dehya", "Worker",6,240,10,0,"EMP001"));

        for(int i = 0; i < Employees.size(); i++) {
            Worker worker = (Worker)Employees.get(i); // TYpe cast. Can use Employees function
            System.out.println(worker.getName());
            System.out.println(worker.getPosition());
            System.out.println(worker.getDaily_work_hrs());
            System.out.println(worker.getBasictimewage());
            System.out.println(worker.getHourly_wage());
            System.out.println(worker.getOvertimepercent());
        }
         */

        Scanner scanner = new Scanner(System.in);
        int numOfEmployees = 20;

        while (true) {
            System.out.print("Please Input the Number Of Employees\n");

            if (scanner.hasNextInt()) {
                numOfEmployees = scanner.nextInt();
                break;
            } else {
                System.out.println("The input is invalid. Please enter a valid integer.\n");
                scanner.next();
            }
        }

        Count_Emp countEmp = new Count_Emp(numOfEmployees);


        // Read daily work hours from an other data file. Please provide option to read more daily work hour files.
        //Structure of daily work datafile:
        countEmp.setEmployeeData();
        //Populate the Employee Collection with data extracted from the Catalog File.
        DataStorage<Data> catalogEmployeeData = countEmp.getEmployeeData();
        System.out.println("Task2 Result");

        for(int i = 0; i < catalogEmployeeData.size(); i++) {
            System.out.println(catalogEmployeeData.get(i).getName());
            System.out.println(catalogEmployeeData.get(i).getDaily_work_hrs());
        }
        Catalog_Print printer = new Catalog_Print(catalogEmployeeData);

        //TASK 3: Print current wages of employees in alphabetic order of employee name
        printer.printNameAndWage();
        //TASK 4:　 Print list of employees in order of missed hours (most in front)
        printer.NameAndMissedHrs(catalogEmployeeData, 2);
        //TASK 5
        //printer.printFinancialReport();
        printer.Totalwage();

    }
}