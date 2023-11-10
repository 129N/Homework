package BUsiness_Tool;

public abstract class Data {

    /*• identifier
• employee name
• position (manager/worker)
• required daily work hours
• sum of work hours
• number of missed hours (greater or equal than 0)
• sum of overtime hours (greater or equal than 0)*/



    private String name;
    private String Position;
    private int daily_work_hrs;
    private int sum_work_hrs;
    private int sum_missed_hrs;
    private int sum_overtime_h;
    private int basictimewage;
    private String identifier;
    public double wage;



    public String getIdentifier() {
        return identifier;
    }



    public void setSum_work_hrs(int sum_work_hrs) {
        this.sum_work_hrs = sum_work_hrs;
    }

    public void setSum_missed_hrs(int sum_missed_hrs) {
        this.sum_missed_hrs = sum_missed_hrs;
    }

    public void setSum_overtime_h(int sum_overtime_h) {
        this.sum_overtime_h = sum_overtime_h;
    }

    public double getWage() {
        return wage;
    }
    public abstract void setWage();

    public String getName() {
        return name;
    }

    public int getBasictimewage() {
        return basictimewage;
    }

    public String getPosition() {
        return Position;
    }


    public int getDaily_work_hrs() {
        return daily_work_hrs;
    }


    public int getSum_work_hrs() {
        return sum_work_hrs;
    }



    public int getSum_missed_hrs() {
        return sum_missed_hrs;
    }



    public int getSum_overtime_h() {
        return sum_overtime_h;
    }

    public Data(String name, String position, int daily_work_hrs,  int basictimewage, String identifier) {
        this.name = name;
        this.Position = position;
        this.daily_work_hrs = daily_work_hrs;
        //this.sum_work_hrs = sum_work_hrs;
        //this.missed_hrs = missed_hrs;
        //this.sum_overtime_h = sum_overtime_h;
        this.basictimewage = basictimewage;
        this.identifier = identifier;



    }



}
