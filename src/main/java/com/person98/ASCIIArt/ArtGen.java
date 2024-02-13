package com.person98.ASCIIArt;

import com.person98.ASCIIArt.utils.AsciiArtGenerator;
import com.person98.ASCIIArt.utils.enums.LineStyle;
import com.person98.ASCIIArt.utils.enums.StyleType;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class ArtGen {
    public static List<String> generateAsciiArt(String input, StyleType type) {
        // Initialize the ASCII art generator with the font corresponding to the type
        AsciiArtGenerator artGenerator = new AsciiArtGenerator(type.name().toLowerCase());
        return artGenerator.generateAsciiArt(input);
    }
    public static List<String> generateAsciiArtColorColor(String input, StyleType type, ChatColor color) {
        // Initialize the ASCII art generator with the font corresponding to the type
        AsciiArtGenerator artGenerator = new AsciiArtGenerator(type.name().toLowerCase());
        List<String> asciiLines = artGenerator.generateAsciiArt(input);

        // Apply the ChatColor to each line
        return asciiLines.stream()
                .map(line -> color + line)
                .collect(Collectors.toList());
    }
    public static List<Component> generateAsciiArtColor(String input, StyleType type, NamedTextColor color) {
        // Initialize the ASCII art generator with the font corresponding to the type
        AsciiArtGenerator artGenerator = new AsciiArtGenerator(type.name().toLowerCase());
        List<String> asciiLines = artGenerator.generateAsciiArt(input);

        // Apply the color to each line using Adventure API components
        return asciiLines.stream()
                .map(line -> Component.text(line, color))
                .collect(Collectors.toList());
    }
    public static String GetLine(LineStyle lineStyle, int length) {
        StringBuilder line = new StringBuilder();
        switch (lineStyle) {
            case SOLID -> line.append("-".repeat(Math.max(0, length)));
            case DOTTED -> {
                for (int i = 0; i < length; i++) {
                    line.append(i % 2 == 0 ? "." : " ");
                }
            }
            case DASHED -> {
                for (int i = 0; i < length; i++) {
                    line.append(i % 3 == 0 ? "-" : " ");
                }
            }
            case DOUBLE -> line.append("=".repeat(Math.max(0, length)));
            case ZIGZAG -> {
                for (int i = 0; i < length; i++) {
                    line.append(i % 2 == 0 ? "=" : "-");
                }
            }
            case BRACKETED -> line.append("[").append("-".repeat(Math.max(0, length - 2))).append("]");
            case WAVY -> line.append("~ ".repeat(Math.max(0, length / 2)));
            case CHECKERED -> {
                for (int i = 0; i < length; i++) {
                    line.append(i % 2 == 0 ? "#" : " ");
                }
            }
            case BLOCKY -> {
                String block = "|█|";
                line.append(block.repeat(Math.max(0, length / 3)));
            }
            case SPIRAL -> {
                String top = "/\\/";
                String bottom = "\\/\\";
                line.append(top.repeat(Math.max(0, length / 3)));
                line.append("\n");
                line.append(bottom.repeat(Math.max(0, length / 3)));
            }
        }
        return line.toString();
    }
    public static Component GetLineColor(LineStyle lineStyle, int length, NamedTextColor color) {
        String lineString = GetLine(lineStyle, length);
        return Component.text(lineString, color);
    }
}
