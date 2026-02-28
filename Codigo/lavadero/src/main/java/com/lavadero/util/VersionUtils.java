package com.lavadero.util;

import java.io.InputStream;
import java.util.Properties;

public class VersionUtils {
    public static String getVersion() {
        String version = "Desarrollo";
        try (InputStream is = VersionUtils.class.getResourceAsStream("/META-INF/maven/com.lavadero/lavadero/pom.properties")) {
            if (is != null) {
                Properties props = new Properties();
                props.load(is);
                version = props.getProperty("version");
            }
        } catch (Exception e) {
            // Si falla (por ejemplo, corriendo desde el IDE), devuelve "Desarrollo"
        }
        return version;
    }
}
