package me.swever.prisonpicks.items.custom;

import me.swever.prisonpicks.PrisonPicks;
import me.swever.prisonpicks.items.BasePickaxe;
import me.swever.prisonpicks.utils.ChatColour;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SmeltersPickaxe extends BasePickaxe {

    private PrisonPicks plugin;
    public SmeltersPickaxe (PrisonPicks plugin) {
        this.plugin = plugin;
        makeSmeltersPickaxe();
    }

    public ItemStack smeltersPickaxe = new ItemStack(basePickaxe());

    private ArrayList<String> lore = new ArrayList<>();

    private void makeSmeltersPickaxe(){
        ItemMeta meta = smeltersPickaxe.getItemMeta();
        for (String s : plugin.getConfig().getStringList("Smelters Pickaxe.Lore")){
            lore.add(ChatColour.message(s));
        }

        meta.setDisplayName(ChatColour.message(plugin.getConfig().getString("Explosive Pickaxe.Name")));
        meta.setLore(lore);

        smeltersPickaxe.setItemMeta(meta);
    }
}
