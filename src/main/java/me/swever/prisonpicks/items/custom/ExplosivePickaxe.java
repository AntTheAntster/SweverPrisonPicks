package me.swever.prisonpicks.items.custom;

import me.swever.prisonpicks.PrisonPicks;
import me.swever.prisonpicks.items.BasePickaxe;
import me.swever.prisonpicks.utils.ChatColour;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

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

        NamespacedKey explosivePickaxeKey = new NamespacedKey(plugin, "explosive_pickaxe");
        meta.getPersistentDataContainer().set(explosivePickaxeKey, PersistentDataType.INTEGER, 1);

        for (String s : plugin.getConfig().getStringList("Explosive Pickaxe.Lore")){
            lore.add(ChatColour.message(s));
        }

        meta.setDisplayName(ChatColour.message(plugin.getConfig().getString("Explosive Pickaxe.Name")));
        meta.setLore(lore);

        explosivePickaxe.setItemMeta(meta);

    }
}
