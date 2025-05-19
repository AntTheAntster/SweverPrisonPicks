package me.swever.prisonpicks.listeners;

import me.swever.prisonpicks.items.custom.BountifulPickaxe;
import me.swever.prisonpicks.utils.BlockPriority;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class BountifulPickaxeListener implements Listener {
    private BountifulPickaxe btp;
    public BlockPriority blockPriority;
    private HashMap<Material, Integer> values = BlockPriority.valueMap;
    public BountifulPickaxeListener(BountifulPickaxe btp) {

        this.btp = btp;
        this.blockPriority = blockPriority;
        this.values = (HashMap<Material, Integer>) blockPriority.getValueMap();
    }


    @EventHandler
    public void bountifulPickaxeBreak(BlockBreakEvent event){

        Player player = event.getPlayer();
        Block centreBlock = event.getBlock();

        int centreX = centreBlock.getX();
        int centreY = centreBlock.getY();
        int centreZ = centreBlock.getZ();

        if (hasBTP(player)){
            if (centreBlock.getType().equals(Material.EMERALD_ORE)){
                event.setDropItems(false);
                player.getInventory().addItem(new ItemStack(Material.EMERALD));
                return;
            }
            if (centreBlock.getType().equals(Material.EMERALD_BLOCK)){
                event.setDropItems(false);
                player.getInventory().addItem(new ItemStack(Material.EMERALD_BLOCK));
                return;
            }
            outerLoop:
            for (int x = -1; x <= 1; x++){
                for (int y = -1; y <= 1; y++){
                    for (int z = -1; z <= 1; z++){
                        Block block = centreBlock.getWorld().getBlockAt(centreX + x, centreY + y, centreZ + z);
                        if (block.equals(centreBlock)) continue;
                        if (block.getType().equals(Material.AIR)) continue;

                        if (!values.containsKey(block.getType())) continue;

                        if (block.getType().equals(Material.EMERALD_BLOCK)){
                            event.setDropItems(false);
                            player.getInventory().addItem(new ItemStack(Material.EMERALD_BLOCK));
                            break outerLoop;
                        }

                        if (block.getType().equals(Material.EMERALD_ORE)){
                            event.setDropItems(false);
                            player.getInventory().addItem(new ItemStack(Material.EMERALD));
                            break outerLoop;
                        }

                        if (block.getType().equals(Material.DIAMOND_BLOCK)){
                            event.setDropItems(false);
                            player.getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK));
                            break outerLoop;
                        }

                        if (block.getType().equals(Material.DIAMOND_ORE)){
                            event.setDropItems(false);
                            player.getInventory().addItem(new ItemStack(Material.DIAMOND));
                            break outerLoop;
                        }

                        if (block.getType().equals(Material.GOLD_BLOCK)){
                            event.setDropItems(false);
                            player.getInventory().addItem(new ItemStack(Material.GOLD_BLOCK));
                            break outerLoop;
                        }

                        if (block.getType().equals(Material.GOLD_ORE)){
                            event.setDropItems(false);
                            player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT));
                            break outerLoop;
                        }

                        if (block.getType().equals(Material.IRON_BLOCK)){
                            event.setDropItems(false);
                            player.getInventory().addItem(new ItemStack(Material.IRON_BLOCK));
                            break outerLoop;
                        }

                        if (block.getType().equals(Material.IRON_ORE)){
                            event.setDropItems(false);
                            player.getInventory().addItem(new ItemStack(Material.IRON_INGOT));
                            break outerLoop;
                        }
                        if (block.getType().equals(Material.COAL_BLOCK)){
                            event.setDropItems(false);
                            player.getInventory().addItem(new ItemStack(Material.COAL_BLOCK));
                            break outerLoop;
                        }

                        if (block.getType().equals(Material.COAL_ORE)){
                            event.setDropItems(false);
                            player.getInventory().addItem(new ItemStack(Material.COAL));
                            break outerLoop;
                        }
                    }
                }
            }
        }
    }

    private Boolean hasBTP(Player p){
        return p.getInventory().getItemInMainHand().equals(btp.bountifulPickaxe);
    }

}
