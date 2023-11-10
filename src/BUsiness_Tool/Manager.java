package BUsiness_Tool;
public class Manager extends Data{
    /*
    o basic wage [monthly $]
o overtime wage [hourly $]
o Wage: basic + (overtime * overtime wage)
     */

    private int month_wage;
    private double Overtimepercent;






    // Getter and Setters


    public int getMonth_wage() {
        return month_wage;
    }

    public void setMonth_wage(int month_wage) {
        this.month_wage = month_wage;
    }

    public double getOvertimepercent() {
        return Overtimepercent;
    }

    public void setOvertimepercent(double overtimepercent) {
        Overtimepercent = overtimepercent;
    }

    // Constructor
    public Manager(String name, String position, int daily_work_hrs,  int basictimewage, int month_wage, double overtimepercent, String identifier) {
        super(name, position, daily_work_hrs, basictimewage, identifier);
        this.month_wage = month_wage;
        Overtimepercent = overtimepercent;
        setWage();
    }

    @Override public void setWage() {
        wage = ( month_wage + (Overtimepercent * getSum_overtime_h()) );
    }
}



    /*
    public int getWage() {
        return Wage  = month_wage + (overtime_wage * getSum_overtime_h());
    }

     */


