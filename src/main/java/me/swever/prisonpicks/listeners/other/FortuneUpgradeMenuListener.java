package me.swever.prisonpicks.listeners.other;

import me.swever.prisonpicks.utils.ChatColour;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class FortuneUpgradeMenuListener implements Listener {
    private UpgradeListener upgradeListener;
    public FortuneUpgradeMenuListener(UpgradeListener upgradeListener) {
        this.upgradeListener = upgradeListener;
    }

    @EventHandler
    public void onFortuneUpgrade(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        if (event.getInventory().equals(upgradeListener.upgradeMenu(player))) event.setCancelled(true);

        if (event.getCurrentItem().equals(upgradeListener.fortuneUpgrade())){
            if (player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
                player.closeInventory();
                player.sendMessage(ChatColour.message("&cYou are unable to add FORTUNE to this item"));
                return;
            }

            try {
                event.setCancelled(true);
                int fortLevel = player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.FORTUNE);

                if (fortLevel == 5) {
                    player.sendMessage(ChatColour.message("&cMax Fortune Level Reached! "));
                    return;
                }
                player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.FORTUNE, fortLevel + 1);
                player.sendMessage(ChatColour.message("&aFortune Level Upgraded to level: &e" +
                        player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.FORTUNE)));

            } catch (NullPointerException e) {

            }

        }
    }
}
