package helperFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class base {
    static {
        Properties prop;
        try {
            FileInputStream file= new FileInputStream(System.getProperty("user.dir"+"src/test/java/propertyFile/resources.properties"));
            prop=new Properties();
            prop.load(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
