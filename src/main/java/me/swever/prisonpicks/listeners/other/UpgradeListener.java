package me.swever.prisonpicks.listeners.other;

import me.swever.prisonpicks.PrisonPicks;
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
import org.bukkit.persistence.PersistentDataType;

public class UpgradeListener implements Listener {
    private Pickaxes pickaxes;
    private PrisonPicks plugin;
    private final NamespacedKey blockPickaxeKey;
    private final NamespacedKey bountifulPickaxeKey;
    private final NamespacedKey explosivePickaxeKey;
    private final NamespacedKey smeltersPickaxeKey;


    public UpgradeListener(Pickaxes pickaxes, PrisonPicks plugin) {
        this.pickaxes = pickaxes;
        this.plugin = plugin;
        this.blockPickaxeKey =  new NamespacedKey(plugin, "block_pickaxe");
        this.bountifulPickaxeKey = new NamespacedKey(plugin,"bountiful_pickaxe");
        this.explosivePickaxeKey = new NamespacedKey(plugin, "explosive_pickaxe");
        this.smeltersPickaxeKey = new NamespacedKey(plugin, "smelters_pickaxe");
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack held = player.getInventory().getItemInMainHand();

        if (player.isSneaking() && hasPersistentKey(held, blockPickaxeKey)) {
            player.openInventory(upgradeMenu(player));
        }
        if (player.isSneaking() && hasPersistentKey(held, bountifulPickaxeKey)) {
            player.openInventory(upgradeMenu(player));
        }
        if (player.isSneaking() && hasPersistentKey(held, explosivePickaxeKey)) {
            player.openInventory(upgradeMenu(player));
        }
        if (player.isSneaking() && hasPersistentKey(held, smeltersPickaxeKey)) {
            player.openInventory(upgradeMenu(player));
        }
    }

    private boolean hasPersistentKey(ItemStack held, NamespacedKey Key) {

        if (held == null || !held.hasItemMeta()) return false;

        ItemMeta meta = held.getItemMeta();

        return meta.getPersistentDataContainer().has(Key, PersistentDataType.INTEGER);
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
