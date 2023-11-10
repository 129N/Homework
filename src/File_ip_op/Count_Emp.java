package File_ip_op;

import java.io.File;
import java.util.ArrayList;

import BUsiness_Tool.Data;
import BUsiness_Tool.DataStorage;

public class Count_Emp {

    private final int numOfEmployees;
    private static final String folderRelativePath = "DataBase_File/Catalog.txt";
    public Count_Emp(int numOfEmployees){
        this.numOfEmployees = numOfEmployees;
    }
        public void setEmployeeData(){

            File folder = new File("DataBase_File");
            if (!folder.exists()) folder.mkdirs();

            //Create a new catalog file if file does not exist.
            /*if(!Reader.doesFileExist(folderRelativePath)) {
                Reader.createFile(folderRelativePath, numOfEmployees);
                return;
            }
             */

            ArrayList<String> Buffer = Reader.Read_File(folderRelativePath);

            //Check if current employee number is equal to the requested amount, is so, no action is needed.
            if(Buffer.size() == numOfEmployees) return;

            //Appends Text File with more Employees, if not Delete necessary lines
            //Reader.writeFile(folderRelativePath, numOfEmployees, Buffer.size(), Buffer.size() < numOfEmployees);

        }

        public DataStorage<Data> getEmployeeData(){


            //Reads the Catalog file and Stores each line into an array list.
            ArrayList<String> RawData = Reader.Read_File(folderRelativePath);
            return Format.Formatting(RawData);


        }


}

