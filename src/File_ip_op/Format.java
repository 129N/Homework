package File_ip_op;

import java.util.ArrayList;
import java.util.Objects;

import BUsiness_Tool.Data;
import BUsiness_Tool.Manager;
import BUsiness_Tool.Worker;
import BUsiness_Tool.DataStorage;

public class Format {

    public static DataStorage<Data> Formatting (ArrayList<String> input){
        DataStorage<Data> output = new DataStorage<>();

        for(int i =0; i < input.size(); i++){
            String[] line = input.get(i).trim().split(";");
            Data newemployee;
            if (Objects.equals(line[2], "Worker")){
                Worker worker = new Worker(

                        line[1],
                        line[2],
                        Integer.parseInt(line[3]),
                        Integer.parseInt(line[5]),
                        Integer.parseInt(line[4]),
                        Integer.parseInt(line[6]),
                        line[0]
                );
                output.add(worker);
            } else if (Objects.equals(line[2], "Manager")) {
                Manager manager = new Manager(
                        line[1],
                        line[2],
                        Integer.parseInt(line[3]),
                        Integer.parseInt(line[5]),
                        Integer.parseInt(line[4]),
                        Integer.parseInt(line[6]),
                        line[0]
                );
                output.add(manager);

            }
        }
        return output;
    }

    public static String[] Daily_Data_Format (String input){
        String[] line = input.trim().split(";" + " ");
        return line;

    }



}
