package File_ip_op;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//The place to write the file
public class Reader {

    public static ArrayList<String> Read_File(String Path) {
        ArrayList<String> Raw_Data = new ArrayList<>();

        try {
            File file = new File(Path);
            Scanner filereader = new Scanner(file);

            if (filereader.hasNextLine()) filereader.nextLine();

            while (filereader.hasNextLine()) {
                String line = filereader.nextLine();
                Raw_Data.add(line); // スキャンしてarrayにいれる。　Row_Dataをretrun
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Raw_Data;
    }

    public static boolean doesFileExist(String Path) {
        File file = new File(Path);
        return file.exists() && file.isFile();
    }


    //--------------------------------------------------------------------------------
    // Write the Catalog text file
    public static void writeFile(String Path, int numOfEmployees) {

        try {
            FileWriter fileWriter = new FileWriter(Path);
            Random random = new Random();

            fileWriter.write("Identifier;HoursWorked On the day");

            for (int i = 1; i <= numOfEmployees; i++) {
                String empID = "EMP" + String.format("%03d", i);
                int randomHrs = 7 + random.nextInt(3);

                String line = "\n" + empID + ";" + randomHrs;

                fileWriter.write(line);
            }
            fileWriter.close();
            System.out.println("Daily Work Data File");

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

    }
}


    //-------------------------------------------------------------------------------------------------




