package com.person98.ASCIIArt.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class AsciiFontLoader {
    private static final Logger LOGGER = Logger.getLogger(AsciiFontLoader.class.getName()); // Logger instance

    public Map<Character, List<String>> loadFont(String fontName) {
        Map<Character, List<String>> fontMap = new HashMap<>();
        InputStream is = getClass().getResourceAsStream("/fonts/" + fontName + ".txt");

        if (is == null) {
            return fontMap; // Return an empty map or handle this case as needed
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        try {
            String line;
            char currentChar = '\0';
            List<String> charLines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("[")) {
                    if (currentChar != '\0') {
                        fontMap.put(currentChar, new ArrayList<>(charLines));
                        charLines.clear();
                    }
                    currentChar = line.charAt(1);
                } else if (!line.equals("---")) {
                    charLines.add(line.substring(1, line.length() - 1)); // Remove the enclosing quotes
                }
            }
            // Add the last character to the map
            if (currentChar != '\0') {
                fontMap.put(currentChar, charLines);
            }
        } catch (Exception e) {
            // Depending on your application's needs, you might want to handle this error differently
        }

        return fontMap;
    }
}
