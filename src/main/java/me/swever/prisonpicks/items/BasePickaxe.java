package me.swever.prisonpicks.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

//Abstract for the Base Item so other classes can extend from here and get the base item.
public abstract class BasePickaxe {


    //Make Base Item
    public ItemStack basePickaxe() {
        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE); //Assign New Item Material
        ItemMeta meta = item.getItemMeta(); //Get Default Item Meta

        //Tweak the BASE item to what we want
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); //Hides stuff like "unbreakable", etc in the lore

        //Apply the new changes we have made
        item.setItemMeta(meta);

        //Make the function return our new pickaxe for passthrough
        return item;
    }

}
