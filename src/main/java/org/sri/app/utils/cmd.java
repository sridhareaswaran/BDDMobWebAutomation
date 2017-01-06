package org.sri.app.utils;

import java.io.IOException;
import java.util.Scanner;

import static org.sri.app.utils.logManager.*;

/**
 * Created by sridhar.easwaran on 1/5/2017.
 */
public class cmd {

    public static String run(String command) {
        String output = "";
        try {
            log.debug("Executing command : " + command);
            Scanner scanner = new Scanner(Runtime.getRuntime().exec(command).getInputStream()).useDelimiter("\\A");
            if (scanner.hasNext()) output = scanner.next();

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        log.debug("Output of command => " + command + " is => " + output);
        return output;
    }
}
