package me.swever.prisonpicks.items.custom;

import me.swever.prisonpicks.PrisonPicks;
import me.swever.prisonpicks.items.BasePickaxe;
import me.swever.prisonpicks.utils.ChatColour;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class BountifulPickaxe extends BasePickaxe {
    public BountifulPickaxe(PrisonPicks plugin) {
        super(plugin);
        makeBountifulPickaxe();
    }

    private ArrayList<String> lore = new ArrayList<>();

    public ItemStack bountifulPickaxe = new ItemStack(basePickaxe());

    private void makeBountifulPickaxe() {
        ItemMeta meta = bountifulPickaxe.getItemMeta();
        if (meta == null){ return; }

        applyPickaxeType(meta, "bountiful_pickaxe");

        for (String s : plugin.getConfig().getStringList("Bountiful Pickaxe.Lore")) {
            lore.add(ChatColour.message(s));
        }

        meta.setDisplayName(ChatColour.message(plugin.getConfig().getString("Bountiful Pickaxe.Name")));
        meta.setLore(lore);

        bountifulPickaxe.setItemMeta(meta);

    }
}
