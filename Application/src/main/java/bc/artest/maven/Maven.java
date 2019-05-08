package bc.artest.maven;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import java.io.FileReader;

/**
 * Class with information about Maven project from pom.xml
 */
public class Maven {

    private static MavenXpp3Reader reader = new MavenXpp3Reader();
    private static Model model;
    static {
        try {
            model = reader.read(new FileReader("pom.xml"));
        } catch (Exception e) {
            // TODO: handle exception and do something smart
        }
    }

    /**
     * Getter for ArtifactId.
     * @return - artifact id.
     */
    public static String getMavenArtifactId() {
        return model.getArtifactId();
    }

}
