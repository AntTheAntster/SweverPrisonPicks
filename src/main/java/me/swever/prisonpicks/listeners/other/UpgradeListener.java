package me.swever.prisonpicks.listeners.other;

import me.swever.prisonpicks.PrisonPicks;
import me.swever.prisonpicks.items.BasePickaxe;
import me.swever.prisonpicks.utils.ChatColour;
import me.swever.prisonpicks.utils.Pickaxes;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class UpgradeListener implements Listener {
    private Pickaxes pickaxes;
    private PrisonPicks plugin;

    private final NamespacedKey key;

    public UpgradeListener(Pickaxes pickaxes, PrisonPicks plugin) {
        this.pickaxes = pickaxes;
        this.plugin = plugin;
        this.key = new NamespacedKey(plugin, "pickaxe_type");
    }



    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        ItemStack held = player.getInventory().getItemInMainHand(); // Step 5 - Get the held item
        ItemMeta meta = held.getItemMeta(); // Step 4 - Get the held item's meta
        if (meta == null) return;

        PersistentDataContainer container = meta.getPersistentDataContainer(); // Step 3 - Get the Data off of the item meta
        String type = container.get(key, PersistentDataType.STRING);

        if (player.isSneaking() && type != null) {
            switch (type) {
                case "block_pickaxe":
                case "bountiful_pickaxe":
                case "explosive_pickaxe":
                case "smelters_pickaxe":
                    player.openInventory(upgradeMenu(player));
                    break;
            }

        }


                                    // Step 1
                                    // Check if the string below equals the string in the held item's "PersistentData" via the .equals(type)

    }

    public Inventory upgradeMenu(Player player){
        Inventory inv = Bukkit.createInventory(player, 27, ChatColour.message("&eUpgrade Menu"));
        inv.setItem(10, efficiencyUpgrade());
        inv.setItem(12, fortuneUpgrade());
        inv.setItem(14, silktouchUpgrade());

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

    public ItemStack silktouchUpgrade() {
        ItemStack item = new ItemStack(Material.DIAMOND_ORE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColour.message("&5Silk Touch Upgrade"));

        item.setItemMeta(meta);
        return item;
    }
}
