package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties prop;

    public static void readProperties(String filePath){

      try {
          FileInputStream fis=new FileInputStream(filePath);
          prop=new Properties();
          prop.load(fis);
          fis.close();
      } catch (IOException exception){
          exception.printStackTrace();
      }
    }

    public static String getPropValue(String key){

        return prop.getProperty(key);
    }
}
