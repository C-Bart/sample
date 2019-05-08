package bc.artest.config;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * Configuration class to set properties in environment from files. Not allowed to extend.
 */
public final class Configuration {

    private Configuration() {}

    private static Properties properties;

    /**
     * Loading and reading properties file from path "/" (main in project structure).
     * @throws IOException
     */
    public static void load() throws IOException {
        Configuration.load("config.properties", "/");
    }

    /**
     * Loading and reading property file from given path.
     * @param fileName - name of ile with properties.
     * @param path - path to property file.
     * @throws IOException
     */
    public static void load(String fileName, String path) throws IOException {
        Configuration config = new Configuration();
        boolean isProperty = false;
        if (properties == null) {
            properties = new Properties();
        } else {
            isProperty = true;
        }
        Enumeration<URL> enumeration = config.getClass().getClassLoader().getResources(path);
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
        InputStream inputStream = new FileInputStream(new File(fileName));
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        // TODO: Remove this, don't need more than one config file anymore
        try {
            if (isProperty) {
                Properties propertiesTemp = new Properties();
                propertiesTemp.load(new BufferedReader(new InputStreamReader(
                        (new FileInputStream(new File(fileName))), StandardCharsets.UTF_8)));
                properties.putAll(propertiesTemp);
            } else {
                properties.load(reader);
            }
        } finally {
            inputStream.close();
            reader.close();
        }
    }

    /**
     * Getting an individual property option
     * @param option - key of property we want to get
     * @return - value of property we want to get
     */
    public static String get(String option) {
        String value = properties.getProperty(option);
        if (value == null) {
            return "";
        }
        return value;
    }

    /**
     * Printing all properties in property file
     */
    public static void print() {
        for (Map.Entry<Object, Object> entry: properties.entrySet()) {
            System.out.println(String.format("%s=%s", entry.getKey(), entry.getValue()));
        }
    }
}