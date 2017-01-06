package org.sri.app.os;

/**
 * Created by sridhar.easwaran on 1/5/2017.
 */
public interface MobileDevice {

    String getName();

    String getBrandName();

    String getVersion();

    String getUdid();

    boolean isAvailable();

    boolean isSimulator();

    void setName(String name);

    void setBrandName(String name);

    void setVersion(String version);

    void setUdid(String udid);

    void setAvailable(boolean available);

    void setSimulator(boolean simulator);

    String toString();
}
