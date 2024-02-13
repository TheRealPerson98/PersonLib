package com.person98.utils;

import org.bukkit.Bukkit;

import java.util.Properties;

public class Test {
    public static String getVersion() {
        String version = "unknown";
        try {
            Properties p = new Properties();
            p.load(Test.class.getResourceAsStream("/META-INF/maven/com.person98/PersonLib/pom.properties"));
            version = p.getProperty("version");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return version;
    }

    public static String TestPaperAPI() {
        String version = Bukkit.getVersion();
        return "The server is running version: " + version;
    }
}