package me.swever.prisonpicks.commands;

import me.swever.prisonpicks.items.custom.BlockPickaxe;
import me.swever.prisonpicks.items.custom.ExplosivePickaxe;
import me.swever.prisonpicks.items.custom.SmeltersPickaxe;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {

    private BlockPickaxe blockPickaxe;
    private SmeltersPickaxe smeltersPickaxe;
    private ExplosivePickaxe explosivePickaxe;

    public TestCommand(BlockPickaxe blockPickaxe, SmeltersPickaxe smeltersPickaxe, ExplosivePickaxe explosivePickaxe){
        this.blockPickaxe = blockPickaxe;
        this.smeltersPickaxe = smeltersPickaxe;
        this.explosivePickaxe = explosivePickaxe;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("pick")){
            Player player = (Player) sender;
            player.getInventory().addItem(blockPickaxe.blockPickaxe);
            player.getInventory().addItem(smeltersPickaxe.smeltersPickaxe);
            player.getInventory().addItem(explosivePickaxe.explosivePickaxe);
        }

        return false;
    }
}
