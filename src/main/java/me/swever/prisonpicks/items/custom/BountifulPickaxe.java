package me.swever.prisonpicks.items.custom;

import me.swever.prisonpicks.PrisonPicks;
import me.swever.prisonpicks.items.BasePickaxe;
import me.swever.prisonpicks.utils.ChatColour;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class BountifulPickaxe extends BasePickaxe {
    private PrisonPicks plugin;
    public BountifulPickaxe(PrisonPicks plugin){
        this.plugin = plugin;
        makeBountifulPickaxe();
    }

    private ArrayList<String> lore = new ArrayList<>();

    public ItemStack bountifulPickaxe = new ItemStack(basePickaxe());

    private void makeBountifulPickaxe() {
        ItemMeta meta = bountifulPickaxe.getItemMeta();

        NamespacedKey bountifulPickaxeKey = new NamespacedKey(plugin, "bountiful_pickaxe");
        meta.getPersistentDataContainer().set(bountifulPickaxeKey, PersistentDataType.INTEGER, 1);

        for (String s : plugin.getConfig().getStringList("Bountiful Pickaxe.Lore")) {
            lore.add(ChatColour.message(s));
        }

        meta.setDisplayName(ChatColour.message(plugin.getConfig().getString("Bountiful Pickaxe.Name")));
        meta.setLore(lore);

        bountifulPickaxe.setItemMeta(meta);

    }
}
