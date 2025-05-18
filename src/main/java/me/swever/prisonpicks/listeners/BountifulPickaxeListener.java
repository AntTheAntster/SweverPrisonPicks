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

public class BountifulPickaxeListener implements Listener {
    private BountifulPickaxe btp;
    public BountifulPickaxeListener(BountifulPickaxe btp) {
        this.btp = btp;
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
                            //Added this in not sure if thats how it works

                        /*
                            Yes it is, and it isn't. This will stop the Bountiful Pickaxe from mining anything that isn't on that list. INCLUDING Stone, Deepslate, etc.
                            To fix this, add them to the HashMap with values like -1. They can all have the -1 value because they are the lowest priority and that doesn't matter.
                            Regarding not mining anything else, let's pretend that that is the intended behavior for now. You now need to use the HashMap in the block checks.
                            To achieve the functionality with a HashMap, you want to check all blocks that are in the vicinity (Which is what the nested 'for' loops are doing).
                            Then check the hashmap for the returned block with the highest Integer (value) attached to it and then give the drops accordingly
                                -> (Using a switch statement that I see you've taught yourself to use in the TestCommand Class).
                            Also FYI, It's easier to assign the HashMap to a local variable (A variable in this class) than to reference BlockPriority.valueMap each time you need the map.
                                -> Just do [private HashMap<Material, Integer> values = BlockPriority.valueMap;] and then use [values.get(block.getType());] to get the value of the block.
                                    -> You only need to check for "#containsKey()" once as that will return a true/false. To get the value of the actual block, you insert the block.getType()
                                        -> into "values.get()" (values.get(block.getType()) to be exact). Then do a reverse 'for' statement (Google it) to count down to the highest value.
                                            -> Then you will know what to give the player.

                            This seems like a lot of stuff to do, but the result will be 1/4 the size of the current code. And, it is a far more efficient and readable way to do it.
                            There is a lot of writing here because I have done my best to explain each step, whilst still giving you some homework to research and find out for yourself.
                            Obviously, I'll be around to help if you get completely stuck.
                        */

                        if (!BlockPriority.valueMap.containsKey(block.getType())) continue ;

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
