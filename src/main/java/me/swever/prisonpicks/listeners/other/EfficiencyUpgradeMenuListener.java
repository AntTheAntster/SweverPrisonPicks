package me.swever.prisonpicks.listeners.other;

import me.swever.prisonpicks.utils.ChatColour;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class EfficiencyUpgradeMenuListener implements Listener {
    private UpgradeListener upgradeListener;
    public EfficiencyUpgradeMenuListener(UpgradeListener upgradeListener) {
        this.upgradeListener = upgradeListener;
    }

    @EventHandler
    public void onEfficiencyUpgrade(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked(); //Get the player in the inventory and assign them to the "player" variable
        if (event.getInventory().equals(upgradeListener.upgradeMenu(player))) event.setCancelled(true);

        if (event.getCurrentItem().equals(upgradeListener.efficiencyUpgrade())){
            event.setCancelled(true);
            int effLevel = player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.EFFICIENCY);
            if (effLevel == 10) {
                player.sendMessage(ChatColour.message("&cMax Efficiency Level Reached!"));
                return;
            }
            player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.EFFICIENCY, effLevel + 1);
            player.sendMessage(ChatColour.message("&aEfficiency Level Upgraded to level: &e" +
                    player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.EFFICIENCY)));
        }
    }

}
