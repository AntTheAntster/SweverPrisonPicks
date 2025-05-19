package me.swever.prisonpicks.listeners.other;

import me.swever.prisonpicks.menus.AdminGUI;
import me.swever.prisonpicks.utils.Pickaxes;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

//Don't touch this class for now, I'll go over it with you.
public class AdminGUIListener implements Listener {

    //Construct the class with the necessary references
    private AdminGUI adminGUI;
    private Pickaxes pickaxes;
    public AdminGUIListener(AdminGUI adminGUI, Pickaxes pickaxes) {
        this.adminGUI = adminGUI;
        this.pickaxes = pickaxes;
    }

    @EventHandler
    public void onGUIClick(InventoryClickEvent event){
        if (!event.getInventory().equals(adminGUI.adminGUI)) return;

        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();

        if (item.equals(pickaxes.getBlockPickaxe())) player.getInventory().addItem(pickaxes.getBlockPickaxe());
        if (item.equals(pickaxes.getSmeltersPickaxe())) player.getInventory().addItem(pickaxes.getSmeltersPickaxe());
        if (item.equals(pickaxes.getExplosivePickaxe())) player.getInventory().addItem(pickaxes.getExplosivePickaxe());
        if (item.equals(pickaxes.getBountifulPickaxe())) player.getInventory().addItem(pickaxes.getBountifulPickaxe());

    }


}
