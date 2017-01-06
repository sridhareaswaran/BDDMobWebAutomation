package org.sri.app.os;

import org.eclipse.jetty.util.ConcurrentHashSet;
import org.sri.app.os.android.ADB;
import org.sri.app.os.android.AndroidDevice;
import org.sri.app.os.iOS.iOSDevice;

import java.util.ArrayList;

import static org.sri.app.utils.logManager.log;

/**
 * Created by sridhar.easwaran on 1/5/2017.
 */
public class ConnectedDevices {


    private static ConcurrentHashSet<AndroidDevice> androidDevices = new ConcurrentHashSet<>();
    private static ConcurrentHashSet<iOSDevice> iOSDevices = new ConcurrentHashSet<>();

    public static ConcurrentHashSet<AndroidDevice> getConnectedAndroidDevices() {
        ArrayList<String> listOfAndroidDevices;
        AndroidDevice device;

        listOfAndroidDevices = ADB.getConnectedDevices();

        for (String udid : listOfAndroidDevices) {
            ADB adb = new ADB(udid);
            String version = adb.getAndroidVersionAsString();
            String name = adb.getDeviceName();
            String brandName = adb.getBrandName();
            boolean isAvailable = true;
            boolean isSimulator = true;
            device = new AndroidDevice(name, brandName, version, udid, isAvailable, isSimulator);
            androidDevices.add(device);
        }
        log.debug(androidDevices.toString());

        return androidDevices;
    }


    public static ConcurrentHashSet<iOSDevice> getConnectediOSDevicesOrSimulators() {
        return iOSDevices;
    }
}
