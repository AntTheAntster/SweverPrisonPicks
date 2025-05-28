package me.swever.prisonpicks.listeners.other;

import me.swever.prisonpicks.PrisonPicks;
import me.swever.prisonpicks.utils.ChatColour;
import me.swever.prisonpicks.utils.Pickaxes;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UpgradeListener implements Listener {
    private Pickaxes pickaxes;
    private PrisonPicks plugin;
    public UpgradeListener(Pickaxes pickaxes, PrisonPicks plugin) {
        this.pickaxes = pickaxes;
        this.plugin = plugin;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if (player.isSneaking() && player.getInventory().getItemInMainHand().equals(pickaxes.getBlockPickaxe())){
            player.openInventory(upgradeMenu(player));
        }
    }

    public Inventory upgradeMenu(Player player){
        Inventory inv = Bukkit.createInventory(player, 27, ChatColour.message("&eUpgrade Menu"));
        inv.setItem(10, efficiencyUpgrade());
        inv.setItem(12, fortuneUpgrade());

        return inv;
    }

    public ItemStack efficiencyUpgrade(){
        ItemStack item = new ItemStack(Material.DIAMOND);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColour.message("&bEfficiency Upgrade"));

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack fortuneUpgrade(){
        ItemStack item = new ItemStack(Material.EMERALD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColour.message("&cFortune Upgrade"));

        item.setItemMeta(meta);

        return item;
    }

}
