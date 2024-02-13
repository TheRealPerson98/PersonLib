package com.person98.ASCIIArt.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class AsciiArtGenerator {
    private final Map<Character, List<String>> fontMap;
    private static final Logger LOGGER = Logger.getLogger(AsciiArtGenerator.class.getName()); // Logger instance

    public AsciiArtGenerator(String fontName) {
        AsciiFontLoader loader = new AsciiFontLoader();
        try {
            this.fontMap = loader.loadFont(fontName);
        } catch (Exception e) {
            throw new RuntimeException("Font loading failed.", e); // Rethrow or handle as appropriate for your application
        }
    }

    public List<String> generateAsciiArt(String input) {
        List<String> result = new ArrayList<>();
        try {
            // Determine the maximum height of the ASCII art
            int maxHeight = input.chars()
                    .mapToObj(c -> (char) c)
                    .mapToInt(c -> fontMap.getOrDefault(c, List.of(" ")).size())
                    .max()
                    .orElse(0);

            for (int i = 0; i < maxHeight; i++) {
                final int lineIndex = i;
                String line = input.chars()
                        .mapToObj(c -> (char) c)
                        .map(c -> {
                            List<String> charLines = fontMap.getOrDefault(c, List.of(" "));
                            int padding = maxHeight - charLines.size(); // Calculate padding needed for bottom alignment
                            return lineIndex < padding ? " " : charLines.get(lineIndex - padding); // Adjust index for padding
                        })
                        .collect(Collectors.joining(" "));
                result.add(line);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error generating ASCII art", e);
        }
        return result;
    }
}
