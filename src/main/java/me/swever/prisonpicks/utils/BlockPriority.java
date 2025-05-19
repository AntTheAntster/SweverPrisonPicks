package me.swever.prisonpicks.utils;

import me.swever.prisonpicks.PrisonPicks;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public class BlockPriority {
public BlockPriority(PrisonPicks plugin){
    this.plugin = plugin;

}
    public Map<Material, Integer> getValueMap() {
        return valueMap;
    }

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
    public static final HashMap<Material, Integer> valueMap = HashMap.newHashMap(
            valueMap.put(Material.EMERALD_BLOCK, 9);
            valueMap.put(Material.EMERALD_ORE, 8,);
            valueMap.put(Material.DIAMOND_BLOCK, 7,);
            valueMap.put(Material.DIAMOND_ORE, 6,);
            valueMap.put(Material.GOLD_BLOCK, 5,);
            valueMap.put(Material.GOLD_ORE, 4,);
            valueMap.put(Material.IRON_BLOCK, 3,);
            valueMap.put(Material.IRON_ORE, 2,);
            valueMap.put(Material.COAL_BLOCK, 1,);
            valueMap.put(Material.COAL_ORE, 0);
    );
}
