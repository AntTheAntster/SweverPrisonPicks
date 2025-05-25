package me.swever.prisonpicks.listeners;

import me.swever.prisonpicks.items.custom.BountifulPickaxe;
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

    public BountifulPickaxeListener(BountifulPickaxe btp) {
        this.btp = btp;
        initValueMap();
    }


    public HashMap<Material, Integer> values = new HashMap<>();

    @EventHandler
    public void bountifulPickaxeBreak(BlockBreakEvent event){

        Player player = event.getPlayer();
        Block centreBlock = event.getBlock();

        int centreX = centreBlock.getX();
        int centreY = centreBlock.getY();
        int centreZ = centreBlock.getZ();

        if (hasBTP(player)){
            if (centreBlock.getType().equals(Material.ANCIENT_DEBRIS)){
                event.setDropItems(false);
                player.getInventory().addItem(new ItemStack(Material.NETHERITE_BLOCK));
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
                        if (values.get(block.getType()) >= 0) event.setDropItems(false);

                        checkPriority(player, block, 15);
                    }
                }
            }
        }
    }

    private Boolean hasBTP(Player p){
        return p.getInventory().getItemInMainHand().equals(btp.bountifulPickaxe);
    }

    private void checkPriority(Player player, Block block, int i){
        for (int n = -1; n < i; i++){
            if (values.get(block.getType()) == 15){
                player.getInventory().addItem(new ItemStack(Material.NETHERITE_BLOCK));
            }
            if (values.get(block.getType()) == 14){
                player.getInventory().addItem(new ItemStack(Material.ANCIENT_DEBRIS));
            }
            if (values.get(block.getType()) == 13){
                player.getInventory().addItem(new ItemStack(Material.EMERALD_BLOCK));
            }
            if (values.get(block.getType()) == 12){
                player.getInventory().addItem(new ItemStack(Material.EMERALD_ORE));
            }
            if (values.get(block.getType()) == 11){
                player.getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK));
            }
            if (values.get(block.getType()) == 10){
                player.getInventory().addItem(new ItemStack(Material.DIAMOND_ORE));
            }
            if (values.get(block.getType()) == 9){
                player.getInventory().addItem(new ItemStack(Material.LAPIS_BLOCK));
            }
            if (values.get(block.getType()) == 8){
                player.getInventory().addItem(new ItemStack(Material.LAPIS_ORE));
            }
            if (values.get(block.getType()) == 7){
                player.getInventory().addItem(new ItemStack(Material.REDSTONE_BLOCK));
            }
            if (values.get(block.getType()) == 6){
                player.getInventory().addItem(new ItemStack(Material.REDSTONE_ORE));
            }
            if (values.get(block.getType()) == 5){
                player.getInventory().addItem(new ItemStack(Material.GOLD_BLOCK));
            }
            if (values.get(block.getType()) == 4){
                player.getInventory().addItem(new ItemStack(Material.GOLD_ORE));
            }
            if (values.get(block.getType()) == 3){
                player.getInventory().addItem(new ItemStack(Material.IRON_BLOCK));
            }
            if (values.get(block.getType()) == 2){
                player.getInventory().addItem(new ItemStack(Material.IRON_ORE));
            }
            if (values.get(block.getType()) == 1){
                player.getInventory().addItem(new ItemStack(Material.COAL_BLOCK));
            }
            if (values.get(block.getType()) == 0){
                player.getInventory().addItem(new ItemStack(Material.COAL_ORE));
            }
        }
    }



    private void initValueMap(){
        values.put(Material.NETHERITE_BLOCK, 15);
        values.put(Material.ANCIENT_DEBRIS,14);
        values.put(Material.EMERALD_BLOCK, 13);
        values.put(Material.EMERALD_ORE, 12);
        values.put(Material.DIAMOND_BLOCK, 11);
        values.put(Material.DIAMOND_ORE, 10);
        values.put(Material.LAPIS_BLOCK, 9);
        values.put(Material.LAPIS_ORE, 8);
        values.put(Material.REDSTONE_BLOCK, 7);
        values.put(Material.REDSTONE_ORE, 6);
        values.put(Material.GOLD_BLOCK, 5);
        values.put(Material.GOLD_ORE, 4);
        values.put(Material.IRON_BLOCK, 3);
        values.put(Material.IRON_ORE, 2);
        values.put(Material.COAL_BLOCK, 1);
        values.put(Material.COAL_ORE, 0);

        //Negative Values for Listener purposes
        values.put(Material.STONE, -1);
        values.put(Material.DEEPSLATE, -1);
        values.put(Material.COBBLESTONE, -1);
        values.put(Material.COBBLED_DEEPSLATE, -1);
        values.put(Material.SANDSTONE, -1);
        values.put(Material.NETHERRACK, -1);
        values.put(Material.SNOW, -1);
        values.put(Material.ICE, -1);
        values.put(Material.PACKED_ICE, -1);
    }

}
