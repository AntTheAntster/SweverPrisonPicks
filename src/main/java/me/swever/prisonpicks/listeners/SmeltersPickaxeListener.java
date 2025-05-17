package me.swever.prisonpicks.listeners;

import me.swever.prisonpicks.items.custom.SmeltersPickaxe;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class SmeltersPickaxeListener implements Listener {
    private SmeltersPickaxe sp;
    public SmeltersPickaxeListener(SmeltersPickaxe sp) {
        this.sp = sp;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void smeltersPickaxeBreak (BlockBreakEvent event) {

        Player player = event.getPlayer();
        Material ore = event.getBlock().getType();

        if (player.getInventory().getItemInMainHand().equals(sp.smeltersPickaxe)){
            if (ore.equals(Material.COPPER_ORE)){
                event.setDropItems(false);
                player.getInventory().addItem(new ItemStack(Material.COPPER_INGOT));
            }
            if (ore.equals(Material.IRON_ORE)){
                event.setDropItems(false);
                player.getInventory().addItem(new ItemStack(Material.IRON_INGOT));
            }
            if (ore.equals(Material.GOLD_ORE)){
                event.setDropItems(false);
                player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT));
            }
        }
    }
}


