package BUsiness_Tool;

public class Worker extends Data {
    /* (basic work hours * hourly wage) + (overtime hours * hourly wage * (1 + overtime wage))

    identifier; name; position; required workhours; basic or hourly wage (based on position); overtime
wage


 */

    private int hourly_wage;
    private double Overtimepercent;

    public double getOvertimepercent() {

        return Overtimepercent;
    }

    public int getHourly_wage() {
        return hourly_wage;
    }

    public Worker(String name, String position, int daily_work_hrs, int basictimewage, int hourly_wage, double overtimepercent, String identifier) {
        super(name, position, daily_work_hrs, basictimewage, identifier);
        this.hourly_wage = hourly_wage;
        Overtimepercent = overtimepercent;
        setWage();
    }

    @Override public void setWage() {
        wage = ( (getDaily_work_hrs() * hourly_wage ) + (getSum_overtime_h() * hourly_wage * ( 1 * Overtimepercent ) )  );
    }
    //(daily_work_hrs * hourly_wage) + (sum_overtime_h * hourly_wage * (1 * overtime_wage))

    }


