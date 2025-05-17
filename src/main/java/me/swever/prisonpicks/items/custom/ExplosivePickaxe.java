package me.swever.prisonpicks.items.custom;

import me.swever.prisonpicks.PrisonPicks;
import me.swever.prisonpicks.items.BasePickaxe;
import me.swever.prisonpicks.utils.ChatColour;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ExplosivePickaxe extends BasePickaxe {

    private PrisonPicks plugin;
    public ExplosivePickaxe(PrisonPicks plugin){
        this.plugin = plugin;
        makeExplosivePickaxe();
    }

    public ItemStack explosivePickaxe = new ItemStack(basePickaxe());

    private ArrayList<String> lore = new ArrayList<>();

    private void makeExplosivePickaxe(){
        ItemMeta meta = explosivePickaxe.getItemMeta();
        meta.setDisplayName(ChatColour.message("&cExplosive &aPickaxe"));
        lore.add(ChatColour.message("&cTest1"));
        lore.add(ChatColour.message("&cTest2"));
        lore.add(ChatColour.message("&cTest3"));
        meta.setLore(lore);

        explosivePickaxe.setItemMeta(meta);
    }
}
