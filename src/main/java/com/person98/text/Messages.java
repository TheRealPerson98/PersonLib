package com.person98.text;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;

public class Messages {

    public static String getPlainMessage() {
        return "Made by Person98\nSupport at https://discord.gg/person98";
    }

    public static Component getMadeBy() {
        return Component.text()
                .append(Component.text("Made by ", NamedTextColor.WHITE))
                .append(Component.text("Person98", NamedTextColor.DARK_PURPLE))
                .append(Component.newline()) // For a new line
                .build();
    }

    public static Component getSupport() {
        return Component.text()
                .append(Component.text("Support at ", NamedTextColor.WHITE))
                .append(Component.text("https://discord.gg/person98", NamedTextColor.BLUE, TextDecoration.UNDERLINED))
                .build();
    }
}
