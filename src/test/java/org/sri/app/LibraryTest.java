package org.sri.app;

import org.junit.Test;
import org.sri.app.screen.Library;
import org.sri.app.utils.configReader;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/*
 * @author sridhar.easwaran, @date 12/27/16 10:50 AM
 */
public class LibraryTest {
    @Test public void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
        configReader configReader =new configReader();
        HashMap<String,String> test= configReader.getBaseConfig_data();
        System.out.println(test.get("TestEnvironment"));
        HashMap<String,HashMap<String,String>> test2= configReader.getEnvConfig_data();
        for (Map.Entry<String,HashMap<String,String>> t:test2.entrySet()) {
            System.out.println(t.getKey()+" : "+t.getValue());
        }

        System.out.println(configReader.currentEnv);
        HashMap<String,String> jj= configReader.currentEnv_data;
        for (Map.Entry<String,String> j:jj.entrySet()) {
            System.out.println(j.getKey()+" : "+j.getValue());
        }
    }
}
