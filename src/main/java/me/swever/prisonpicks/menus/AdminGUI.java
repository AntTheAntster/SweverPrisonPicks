package me.swever.prisonpicks.menus;

import me.swever.prisonpicks.PrisonPicks;
import me.swever.prisonpicks.utils.ChatColour;
import me.swever.prisonpicks.utils.Pickaxes;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

//Don't touch this class for now, I'll go over it with you.//Don't touch this class for now, I'll go over it with you.
public class AdminGUI {
    private PrisonPicks plugin;
    private Pickaxes pickaxes;
    public AdminGUI(PrisonPicks plugin, Pickaxes pickaxes) {
        this.plugin = plugin;

        makeAdminGUI();
    }
    public Inventory adminGUI;

    private void makeAdminGUI(){
        String title = plugin.getConfig().getString("Admin GUI.Title");
        int size = plugin.getConfig().getInt("Admin GUI.Size");
        adminGUI = Bukkit.createInventory(null, size, ChatColour.message(title));
        adminGUI.setItem(10, pickaxes.getBlockPickaxe());
        adminGUI.setItem(12, pickaxes.getSmeltersPickaxe());
        adminGUI.setItem(14, pickaxes.getExplosivePickaxe());
        adminGUI.setItem(21, pickaxes.getBountifulPickaxe());
    }


}
