package me.swever.prisonpicks.items.custom;

import me.swever.prisonpicks.PrisonPicks;
import me.swever.prisonpicks.items.BasePickaxe;
import me.swever.prisonpicks.utils.ChatColour;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

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

        NamespacedKey smeltersPickaxeKey = new NamespacedKey(plugin, "smelters_pickaxe");
        meta.getPersistentDataContainer().set(smeltersPickaxeKey, PersistentDataType.INTEGER, 1);

        for (String s : plugin.getConfig().getStringList("Smelters Pickaxe.Lore")){
            lore.add(ChatColour.message(s));
        }

        meta.setDisplayName(ChatColour.message(plugin.getConfig().getString("Explosive Pickaxe.Name")));
        meta.setLore(lore);

        smeltersPickaxe.setItemMeta(meta);


    }
}
