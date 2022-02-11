package utils;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {



    public static void Logger(String append) throws IOException {

        String filename = "login_activity.txt";
        FileWriter fwriter = new FileWriter(filename, true);
        PrintWriter loginFile = new PrintWriter(fwriter);
        loginFile.println(append);
        loginFile.close();

    }
}
