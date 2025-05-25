package me.swever.prisonpicks.commands;

import me.swever.prisonpicks.menus.AdminGUI;
import me.swever.prisonpicks.utils.Pickaxes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {

    private AdminGUI adminGUI;
    private Pickaxes pickaxes;
                                                                                                                        //Correct
    public TestCommand(AdminGUI adminGUI, Pickaxes pickaxes) {

        this.pickaxes = pickaxes;
        this.adminGUI = adminGUI;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("pick")) return false; //Good idea changing a 'true' check to a 'false' check. 10 points if you can tell me why (I've told you the reason to check for false's over true's previously)

        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;
        //player.openInventory(adminGUI.adminGUI);
        player.getInventory().addItem(pickaxes.getBlockPickaxe());
        player.getInventory().addItem(pickaxes.getSmeltersPickaxe());
        player.getInventory().addItem(pickaxes.getExplosivePickaxe());
        player.getInventory().addItem(pickaxes.getBountifulPickaxe());


        return true;
    }
}
