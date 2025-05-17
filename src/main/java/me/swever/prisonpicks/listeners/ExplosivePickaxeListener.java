package me.swever.prisonpicks.listeners;

import me.swever.prisonpicks.items.custom.ExplosivePickaxe;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class ExplosivePickaxeListener implements Listener {
    private ExplosivePickaxe ep;
    public ExplosivePickaxeListener(ExplosivePickaxe ep) {
        this.ep = ep;
    }

    @EventHandler
    public void explosivePickaxeBreak(BlockBreakEvent event){

        Player player = event.getPlayer();
        Block centreBlock = event.getBlock();
        int centreX = centreBlock.getX();
        int centreY = centreBlock.getY();
        int centreZ = centreBlock.getZ();

        if (isEPickaxe(player)){
            for (int x = -1; x <= 1; x++){
                for (int y = -1; y <= 1; y++){
                    for (int z = -1; z <= 1; z++){
                        Block block = centreBlock.getWorld().getBlockAt(centreX + x, centreY + y, centreZ + z);
                        if (block.equals(centreBlock)) continue;
                        if (block.getType().equals(Material.AIR)) continue;
                        player.getInventory().addItem(new ItemStack(block.getType()));
                        block.setType(Material.AIR);

                        event.setDropItems(false);
                    }
                }
            }
        }
    }

    private Boolean isEPickaxe(Player player){
        return player.getInventory().getItemInMainHand().equals(ep.explosivePickaxe);
    }
}
