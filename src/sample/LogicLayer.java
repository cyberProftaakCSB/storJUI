package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Marc-Antoine on 6/1/2017.
 */
public class LogicLayer {

    private static final String CMD =  "ping 8.8.8.8";
    private static Process process;
    private BufferedReader stdInput;
    private BufferedReader stdError;


    public LogicLayer() {

        try{
            // Run command
            process = Runtime.getRuntime().exec(CMD);
            //
            // Get input streams
            stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        }catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }

    public void Test(){
        try {

            // Read command standard output
            String s;
            System.out.println("Standard output: ");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // Read command errors
            System.out.println("Standard error: ");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
