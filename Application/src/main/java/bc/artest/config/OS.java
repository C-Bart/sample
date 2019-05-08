package bc.artest.config;

class OS {

    private static String os = System.getProperty("os.name").toLowerCase();

    static String checkOS() {
        if (os.contains("win")) {
            return "win";
        } else if (os.contains("mac")) {
            return "mac";
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            return "unix";
        } else {
            return null;
        }
    }
}
