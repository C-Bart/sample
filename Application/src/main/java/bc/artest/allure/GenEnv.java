package bc.artest.allure;

import bc.artest.config.Browser;
import bc.artest.config.Configuration;
import bc.artest.maven.Maven;
import java.io.PrintWriter;

public class GenEnv {

    private static String path = "target/allure-results/";

    /**
     * Create properties file for allure with environment information.
     * @param fileName - name for file. For allure must be 'environment'.
     */
    public static void createEnvFile(String fileName) {
        try {
            PrintWriter writer = new PrintWriter( path + fileName + ".properties", "UTF-8");
            writer.println("URL=" + Configuration.get("baseURL"));
            writer.println("Browser=" + Browser.getBrowserName());
            writer.println("Module=" + Maven.getMavenArtifactId());
            writer.close();
        } catch (Exception e) {
            // TODO: add exception handling
        }
    }
}