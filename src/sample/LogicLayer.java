package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Marc-Antoine on 6/1/2017.
 */
public class LogicLayer {
    private static Process process;
    private BufferedReader stdInput;
    private BufferedReader stdError;


    public LogicLayer() {

    }

    public Boolean checkStorJInstalled() {
        String output = ExecuteCommand("which storj");
        if (output.contains("storj")) { //not save. if the user has storj in its name then it wil always say its installed.
            return true;
        }
        return false;
    }

    public Boolean checkConnectionStorJ(){
        String output = ExecuteCommand("ping 8.8.8.8 -c 2"); // dit is echt balen hier chekken hier alleen de connectie van de pc zelf. (naar google)
        if (output.contains("2 received,")) {
            return true;
        }
        return false;
    }


    public String ExecuteCommand(String CMD){
        String finalstring = "";
        try {
            // Run command
            process = Runtime.getRuntime().exec(CMD);
            //
            // Get input streams
            stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            // Read command standard output
            String s;
            System.out.println("Standard output: ");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                finalstring += s;
            }

            // Read command errors
            System.out.println("Standard error: ");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
                finalstring += s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return finalstring;
    }
}
