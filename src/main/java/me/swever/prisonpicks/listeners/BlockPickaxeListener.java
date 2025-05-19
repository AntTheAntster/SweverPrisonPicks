package me.swever.prisonpicks.listeners;

import me.swever.prisonpicks.items.custom.BlockPickaxe;
import me.swever.prisonpicks.utils.BlockPriority;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockPickaxeListener implements Listener {
    private BlockPickaxe bp;
    public BlockPickaxeListener(BlockPickaxe bp) {
        this.bp = bp;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void blockPickaxeBreak (BlockBreakEvent event){

        Player player = event.getPlayer();
        Material ore = event.getBlock().getType();

        if (player.getInventory().getItemInMainHand().equals(bp.blockPickaxe)){
            if (ore.equals(Material.COAL_ORE)){
                event.setDropItems(false);
                player.getInventory().addItem(new ItemStack(Material.COAL_BLOCK));
            }

            if (ore.equals(Material.COPPER_ORE)){
                event.setDropItems(false);
                player.getInventory().addItem(new ItemStack(Material.COPPER_BLOCK));
            }

            if (ore.equals(Material.IRON_ORE)){
                event.setDropItems(false);
                player.getInventory().addItem(new ItemStack(Material.IRON_BLOCK));
            }

            if (ore.equals(Material.GOLD_ORE)){
                event.setDropItems(false);
                player.getInventory().addItem(new ItemStack(Material.GOLD_BLOCK));
            }

            if (ore.equals(Material.DIAMOND_ORE)){
                event.setDropItems(false);
                player.getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK));
            }

            if (ore.equals(Material.EMERALD_ORE)){
                event.setDropItems(false);
                player.getInventory().addItem(new ItemStack(Material.EMERALD_BLOCK));
            }
        }
    }
}
