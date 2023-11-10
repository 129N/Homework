package File_ip_op;


import BUsiness_Tool.Data;
import BUsiness_Tool.DataStorage;
import BUsiness_Tool.Worker;
import BUsiness_Tool.Manager;

public class Catalog_Print {
    private final DataStorage<Data> Employees;
    public Catalog_Print(DataStorage<Data> Employees){
        this.Employees = Employees;
    }


    // TASK 2
    // Read daily work hours from an other data file. Please provide option to read more daily work hour files.
    //Structure of daily work datafile
    public void printNameAndWage(){

        System.out.println("-----------------------------------------------------------");
        System.out.println("Employees of the Catalog list that is showing the Name and Wage and Position at once:");

        int counter = 1;
        for (Data employee: Employees.getEmployeesList()) {
            String position = null;
            if(employee instanceof Worker) position = "Worker";
            if(employee instanceof Manager) position = "Manager";
            System.out.printf("EMP %d(%s):%n   Name: %s%n   Wage: %s%n", counter, position, employee.getName(), (int)employee.getWage());
            counter++;
        }
    }
    //TASK4
    //Print list of employees in order of missed hours (most in front)
    public void NameAndMissedHrs(DataStorage<Data>DataStorage,int numOfwrk_Days){
        System.out.println("--------------------------------------------------------------");
        System.out.println("Task3 and 4");
        System.out.println("Employees of the Catalog list that sorted based on missed hours in descending order:");
        int counter = 1;

        Daily_work_hrs dailyWorkHrs = new Daily_work_hrs(DataStorage, numOfwrk_Days);
        dailyWorkHrs.setDailyWorkRawData();


        for (Data employee: dailyWorkHrs.incorporateDailyWorkData().getEmployeesList()) {
            System.out.printf("EMP %d:%n   Name: %s%n   Missed Hours: %s%n", counter, employee.getName(), employee.getSum_missed_hrs());
            counter++;
        }

        System.out.println("--------------------------------------------------------------");
    }

    //TASK5
    //

    public void Totalwage(){

        System.out.println("--------------------------------------------------------------");
        System.out.println("Employees of the Catalog list that included the normal wage, Overtimewage and Loss:");
        int overtimeWage =0;
        int normalWage =0;
        int loss = 0;


        for(Data employess: Employees.getEmployeesList()){
            if (employess instanceof Worker worker) {
                normalWage += (worker.getSum_work_hrs() - worker.getSum_overtime_h()) * worker.getHourly_wage();
                overtimeWage += (int)(worker.getSum_overtime_h() * worker.getHourly_wage() * (1 + worker.getOvertimepercent()));
                loss += worker.getSum_missed_hrs() * worker.getHourly_wage();
            }
            else if (employess instanceof Manager manager){
                normalWage += (int)(double)Math.round((((double)(manager.getSum_work_hrs() - manager.getSum_overtime_h())/(5 * manager.getDaily_work_hrs())) * manager.getMonth_wage()) * 100) / 100;
                overtimeWage += (int) (double)(manager.getOvertimepercent() * manager.getSum_overtime_h());
                loss += (int) ((double)manager.getSum_missed_hrs() /(5 * manager.getDaily_work_hrs()) * manager.getMonth_wage());
            }
        }
        System.out.println("Normal Wage:");
        System.out.println(normalWage);

        System.out.println("OverTime Wage:");
        System.out.println(overtimeWage);

        System.out.println("Loss:");
        System.out.println(loss);
    }





}
