package com.person98.utils;

import org.bukkit.Bukkit;

import java.util.Properties;

public class Test {
    public static String TestPaperAPI() {
        String version = Bukkit.getVersion();
        return "The server is running version: " + version;
    }
}