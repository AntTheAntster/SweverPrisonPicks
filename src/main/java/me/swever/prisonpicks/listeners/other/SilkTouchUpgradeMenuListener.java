package me.swever.prisonpicks.listeners.other;

import me.swever.prisonpicks.utils.ChatColour;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.net.http.WebSocket;

public class SilkTouchUpgradeMenuListener implements Listener {
    private UpgradeListener upgradeListener;
    public SilkTouchUpgradeMenuListener(UpgradeListener upgradeListener) {this.upgradeListener = upgradeListener;}

    @EventHandler
    public void onSilkTouchUpgrade(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        if (!event.getView().getTitle().contains("Upgrade Menu")) event.setCancelled(true);

        if (player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.FORTUNE)) {
            player.closeInventory();
            player.sendMessage(ChatColour.message("&cYou are unable to add Silk Touch to this item"));
            return;
        }


        if (event.getCurrentItem().equals(upgradeListener.silktouchUpgrade())){
            event.setCancelled(true);
            int silkLevel = player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.SILK_TOUCH);

            if (silkLevel == 1) {
                player.sendMessage(ChatColour.message("&cMax Silk Touch Level Reached! "));
                return;
            }
            player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.SILK_TOUCH, silkLevel + 1);
            player.sendMessage(ChatColour.message("&Silk Touch Level Upgraded to level: &e" +
                    player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.SILK_TOUCH)));

        }
    }
}
