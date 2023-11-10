package File_ip_op;

import java.util.ArrayList;
import java.io.File;
import java.util.Objects;


import BUsiness_Tool.Data;
import BUsiness_Tool.DataStorage;


public class Daily_work_hrs {

    private static final String folderRelativePath = "DataBase_File/Daily_Work";

    private final DataStorage<Data>DataStorage ;
    private final int numberOfDaysPassed;

    private ArrayList<ArrayList<String>> logsOfNDaysPassed;

    public Daily_work_hrs(DataStorage<Data> DataStorage, int numberOfDaysPassed){
        this.DataStorage = DataStorage;
        this.numberOfDaysPassed = numberOfDaysPassed;

    }

    public void setDailyWorkRawData(){

        File[] files = new File(folderRelativePath).listFiles();
        ArrayList<String> paths = new ArrayList<>();

        assert files != null;
        for(File file: files){
            if(file.isFile()){
                paths.add(file.getPath());
            }
        }

        ArrayList<ArrayList<String>> output = new ArrayList<>();

        for (String path:paths) {
            ArrayList<String> RawData = Reader.Read_File(path);

            output.add(RawData);
        }

        logsOfNDaysPassed = output;
    }

    public void generateDailyWorkRawData(){

        File folder = new File(folderRelativePath);
        if (!folder.exists()) folder.mkdirs();

        File[] files = new File(folderRelativePath).listFiles();
        assert files != null;
        if(numberOfDaysPassed == files.length) return;

        //Requires more logs to be generated
        if(numberOfDaysPassed > files.length){
            int numberOfFilesToBeGenerated = numberOfDaysPassed - files.length;
            int startingIndex = files.length + 1;

            for(int i = startingIndex; i < startingIndex + numberOfFilesToBeGenerated; i ++){
                Reader.writeFile(folderRelativePath + "/Day_" + i + ".txt", DataStorage.size());
            }
        }

    }



    //-------------------------------------------------------------------------------------------------
        /*
        //Requires deletion of logs
        else {
            int numberOfFilesToBeDeleted = files.length - numberOfDaysPassed;
            int startingIndex = numberOfDaysPassed + 1;

            for(int i = startingIndex; i < startingIndex + numberOfFilesToBeDeleted; i ++){
                Reader.deleteFile(folderRelativePath + "/Day_" + i + ".txt");
            }
        }

         */



    public DataStorage<Data> incorporateDailyWorkData(){

        //setSumOfWorkHours // Daily Work data
        //setSumOfMissedHours//Req hours - Daily work > 0
        //setSumOfOvertimeHours // Req hours - daily work < 0
        //setWage

        for (ArrayList<String> dailyWorkRawDatum : logsOfNDaysPassed) {
            for (String line : dailyWorkRawDatum) {
                String[] splitLine = line.split(";");

                String identifier = splitLine[0];
                int hoursWorkedOnDay = Integer.parseInt(splitLine[1]);

                if (searchIfExist(identifier, DataStorage)) {

                    int index = searchIndex(identifier, DataStorage);
                    Data currEmp = DataStorage.get(index);

                    //ADDS the total Worked hours
                    currEmp.setSum_work_hrs(currEmp.getSum_work_hrs() + hoursWorkedOnDay);

                    //If employee worked MORE than the required work hours (Overtime)
                    if(hoursWorkedOnDay > currEmp.getDaily_work_hrs())
                        currEmp.setSum_overtime_h(currEmp.getSum_overtime_h() + (hoursWorkedOnDay - currEmp.getDaily_work_hrs()));
                        //If employee worked LESS than the required work hours (Missed Hours)
                    else if (hoursWorkedOnDay < currEmp.getDaily_work_hrs())
                        currEmp.setSum_missed_hrs(currEmp.getSum_missed_hrs() + (currEmp.getDaily_work_hrs() - hoursWorkedOnDay));

                    currEmp.setWage();

                }
            }
        }

        return DataStorage;
    }

    private static boolean searchIfExist(String searchTarget, DataStorage<Data> searchPool){

        boolean found = false;
        for(Data employee : searchPool.getEmployeesList()){

            if (Objects.equals(searchTarget, employee.getIdentifier())) {
                found = true;
                break;
            }
        }

        return found;
    }

    private static int searchIndex(String searchTarget, DataStorage<Data> searchPool){

        int index = 0;

        for(int i  = 0; i < searchPool.size(); i ++){
            if(Objects.equals(searchTarget, searchPool.get(i).getIdentifier())) {
                index = i;
                break;
            }
        }

        return index;
    }


}







