package com.person98.ASCIIArt.utils.enums;

/**
 * Defines various styles of lines that can be generated using the ASCII art generator.
 * Each enum constant represents a unique pattern or style for the lines, allowing for
 * diverse visual representations in ASCII art creations.
 */
public enum LineStyle {
    /**
     * Represents a solid line, using repeated '-' characters.
     */
    SOLID,

    /**
     * Represents a dotted line, alternating between '.' and ' ' characters.
     */
    DOTTED,

    /**
     * Represents a dashed line, with '-' characters separated by spaces.
     */
    DASHED,

    /**
     * Represents a double line, using repeated '=' characters for a thicker appearance.
     */
    DOUBLE,

    /**
     * Represents a zigzag pattern, alternating between '=' and '-' characters.
     */
    ZIGZAG,

    /**
     * Represents a line enclosed within brackets, with '-' characters in between.
     */
    BRACKETED,

    /**
     * Represents a wavy line, using '~' characters to create a sinusoidal appearance.
     */
    WAVY,

    /**
     * Represents a checkered pattern, alternating between '#' and ' ' characters.
     */
    CHECKERED,

    /**
     * Represents a blocky line, using '|█|' patterns to create a bold, block-like appearance.
     */
    BLOCKY,

    /**
     * Represents a spiral pattern, composed of two lines with '/\' and '\/' characters to mimic a spiral.
     */
    SPIRAL
}
