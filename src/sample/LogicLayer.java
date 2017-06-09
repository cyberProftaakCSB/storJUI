package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Marc-Antoine on 6/1/2017.
 */
public class LogicLayer {
    private Main ui;
    private static Process process;
    private BufferedReader stdInput;
    private BufferedReader stdError;

    private ThreadPoolExecutor executor;


    public LogicLayer(Main ui) {
        this.ui = ui;
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
    }

    public void checkStorJInstalled() {
       executor.submit(new Runnable(){
           @Override
           public void run() {
               //String output = ExecuteCommand("which storj");
               String output = ExecuteCommand("which ");
               if (output.contains("storj")) { //not save. if the user has storj in its name then it wil always say its installed.
                   //display is installed message
                   ui.showMessage("stroj is installed");
               }else{
                   //display is NOT installed message
                   System.out.println(output);
                   ui.showMessage("storj is not installed");
               }
           }
       });
    }

    public void checkConnectionStorJ(){
        executor.submit(new Runnable(){
            @Override
            public void run() {
                String output = ExecuteCommand("ping 8.8.8.8 -c 2"); // dit is echt balen hier chekken hier alleen de connectie van de pc zelf. (naar google)
                if (output.contains("2 received,")) {
                    //display is connected thing
                    ui.showMessage("connected to tha internetz");
                }else{
                    //display is not connected
                    ui.showMessage("no internetz");
                }
            }
        });
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
