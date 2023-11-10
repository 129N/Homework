package BUsiness_Tool;

import java.util.ArrayList;


public class DataStorage <T extends Data>{
    //ArrayList<Data> Employees = new ArrayList<>();

    private ArrayList<T> Employees = new ArrayList<>();
    // Employees
    //protected ArrayList<T> EmployeeList = new ArrayList<>();

    public DataStorage() {
    }


    public T get(int index){
        return Employees.get(index);
    }

    public ArrayList<T> getEmployeesList(){ return Employees;}

    public int size() {
        return Employees.size();
    }

    public void add(T newEmployee) {
        Employees.add(newEmployee);
    }


    public void sortByName() {
        Employees.sort(
                (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName())
        );
    }

    public void sortByHoursMissed() {
        Employees.sort(
                (employee1, employee2) -> employee2.getSum_missed_hrs() - employee1.getSum_missed_hrs()
        );
    }





    // array index instantiation

}
