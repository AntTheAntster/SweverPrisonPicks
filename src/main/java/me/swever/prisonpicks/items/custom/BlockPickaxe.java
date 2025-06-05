package me.swever.prisonpicks.items.custom;

import me.swever.prisonpicks.PrisonPicks;
import me.swever.prisonpicks.items.BasePickaxe;
import me.swever.prisonpicks.utils.ChatColour;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class BlockPickaxe extends BasePickaxe {

    //Instantiate the class so that the pickaxe actually exists (Added to Setup() function in MAIN class)
    private PrisonPicks plugin;
    public BlockPickaxe(PrisonPicks plugin){
        this.plugin = plugin;
        makeBlockPickaxe();
    }
    //Make custom pickaxe name and point it to the BASE
    public ItemStack blockPickaxe = new ItemStack(basePickaxe());

    private ArrayList<String> lore = new ArrayList<>();

    private void makeBlockPickaxe(){
        ItemMeta meta = blockPickaxe.getItemMeta();

        NamespacedKey blockPickaxeKey = new NamespacedKey(plugin, "block_pickaxe");
        meta.getPersistentDataContainer().set(blockPickaxeKey, PersistentDataType.INTEGER, 1);

        for (String s : plugin.getConfig().getStringList("Block Pickaxe.Lore")) {
            lore.add(ChatColour.message(s));
        }
        meta.setDisplayName(ChatColour.message(plugin.getConfig().getString("Block Pickaxe.Name")));
        meta.setLore(lore);

        blockPickaxe.setItemMeta(meta);

    }


}
