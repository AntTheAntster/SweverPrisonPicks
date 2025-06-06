package me.swever.prisonpicks.items;

import me.swever.prisonpicks.PrisonPicks;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

//Abstract for the Base Item so other classes can extend from here and get the base item.
public abstract class BasePickaxe {
    protected final PrisonPicks plugin;

    protected final NamespacedKey pickaxeType;

    public BasePickaxe(PrisonPicks plugin) {
        this.plugin = plugin;

        pickaxeType = new NamespacedKey(plugin, "pickaxe_type");
    }

    protected void applyPickaxeType(ItemMeta meta, String type){
        meta.getPersistentDataContainer().set(pickaxeType, PersistentDataType.STRING, type);
    }

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
