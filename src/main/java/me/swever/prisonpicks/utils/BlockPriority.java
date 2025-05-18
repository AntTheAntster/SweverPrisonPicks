package me.swever.prisonpicks.utils;

import org.bukkit.Material;

import java.util.Map;

public class BlockPriority {

    /*
    Class needs initialising in the main class, otherwise the map doesn't yet exist when you try to use it.
    This is because the map is static, meaning it is a class variable and not an instance variable. (Google the difference between static and instance variables for more info).
    The class needs a constructor in here too. We have already done constructors in the pickaxe classes, so you can use them as reference.
    Hint: public BlockPickaxe() {}

    You should also initialise the valueMap in a private void as opposed to declaring the map's contents upon creation of the map.
    Hint: private void initValueMap() {
        valueMap.put(Material.EMERALD_BLOCK, 9);
        valueMap.put(Material.EMERALD_ORE, 8);
        (etc)
    }
    Remember to initialise the map in the class constructor (Again, we have done stuff like this in the pickaxe classes).
     */
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
