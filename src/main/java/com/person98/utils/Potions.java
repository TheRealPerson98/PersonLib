package com.person98.utils;

import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class Potions {
    /**
     * Returns a list of beneficial PotionEffectTypes.
     * @return List of "good" potion effects.
     */
    public static List<PotionEffectType> getGoodPotionEffects() {
        List<PotionEffectType> goodEffects = new ArrayList<>();

        // Add beneficial effects
        goodEffects.add(PotionEffectType.REGENERATION);
        goodEffects.add(PotionEffectType.ABSORPTION);
        goodEffects.add(PotionEffectType.FAST_DIGGING); // Increase in dig speed
        goodEffects.add(PotionEffectType.INCREASE_DAMAGE); // Strength
        goodEffects.add(PotionEffectType.HEAL);
        goodEffects.add(PotionEffectType.HEALTH_BOOST);
        goodEffects.add(PotionEffectType.JUMP);
        goodEffects.add(PotionEffectType.SPEED);
        goodEffects.add(PotionEffectType.FIRE_RESISTANCE);
        goodEffects.add(PotionEffectType.WATER_BREATHING);
        goodEffects.add(PotionEffectType.NIGHT_VISION);
        goodEffects.add(PotionEffectType.INVISIBILITY); // Can be considered good in certain contexts

        return goodEffects;
    }

}
