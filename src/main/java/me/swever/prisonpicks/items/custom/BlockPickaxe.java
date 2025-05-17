package me.swever.prisonpicks.items.custom;

import me.swever.prisonpicks.PrisonPicks;
import me.swever.prisonpicks.items.BasePickaxe;
import me.swever.prisonpicks.utils.ChatColour;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
        meta.setDisplayName(ChatColour.message("&eBlock &aPickaxe"));
        lore.add(ChatColour.message("&cTest1"));
        lore.add(ChatColour.message("&cTest2"));
        lore.add(ChatColour.message("&cTest3"));
        meta.setLore(lore);

        blockPickaxe.setItemMeta(meta);
    }


}
