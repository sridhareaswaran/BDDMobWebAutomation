package org.sri.app.os.android;

import org.sri.app.utils.cmd;

import java.util.ArrayList;

/**
 * Created by sridhar.easwaran on 1/5/2017.
 */
public class ADB {

    private String ID;
    private static String ANDROID_HOME;

    public ADB(String deviceID) {
        ID = deviceID;
    }

    public static String getAndroidHome() {
        if (ANDROID_HOME == null) {
            ANDROID_HOME = System.getenv("ANDROID_HOME");
            if (ANDROID_HOME == null)
                throw new RuntimeException("Failed to find ANDROID_HOME, make sure the environment variable is set");
        }
        return ANDROID_HOME;
    }

    public static String command(String command) {
        if (command.startsWith("adb")) command = command.replace("adb ", getAndroidHome() + "/platform-tools/adb ");
        else throw new RuntimeException("This method is designed to run ADB commands only!");
        String output = cmd.run(command);
        if (output == null) return "";
        else return output.trim();
    }

    public static ArrayList getConnectedDevices() {
        ArrayList<String> devices = new ArrayList();
        String output = command("adb devices");
        for (String line : output.split("\n")) {
            line = line.trim();
            if (line.endsWith("device")) devices.add(line.replace("device", "").trim());
        }
        return devices;
    }

    public static void killServer() {
        command("adb kill-server");
    }

    public static void startServer() {
        command("adb start-server");
    }

    public String getAndroidVersionAsString() {
        String output = command("adb -s " + ID + " shell getprop ro.build.version.release");
        if (output.length() == 3) output += ".0";
        return output;
    }

    public String getBrandName() {
        String output = command("adb -s " + ID + " shell getprop ro.product.brand");
        return output;
    }

    public String getDeviceModel() {
        String output = command("adb -s " + ID + " shell getprop ro.product.model");
        return output;
    }

    public String getDeviceName() {
        String output = command("adb -s " + ID + " shell getprop ro.product.display");
        output = output.replace(" ", "_");
        return output;
    }
}
