package me.swever.prisonpicks.utils;

import org.bukkit.Material;

import java.util.Map;

public class BlockPriority {

    public static final Map<Material, Integer> valueMap = Map.of(
            Material.EMERALD_BLOCK, 9,
            Material.EMERALD_ORE, 8,
            Material.DIAMOND_BLOCK, 7,
            Material.DIAMOND_ORE, 6,
            Material.GOLD_BLOCK, 5,
            Material.GOLD_ORE, 4,
            Material.IRON_BLOCK, 3,
            Material.IRON_ORE, 2,
            Material.COAL_BLOCK, 1,
            Material.COAL_ORE, 0
    );
}
