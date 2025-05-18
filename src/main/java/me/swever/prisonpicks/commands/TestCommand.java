package me.swever.prisonpicks.commands;

import me.swever.prisonpicks.items.custom.BlockPickaxe;
import me.swever.prisonpicks.items.custom.ExplosivePickaxe;
import me.swever.prisonpicks.items.custom.SmeltersPickaxe;
import me.swever.prisonpicks.items.custom.BountifulPickaxe;
import me.swever.prisonpicks.utils.ChatColour;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {

    private BlockPickaxe blockPickaxe;
    private SmeltersPickaxe smeltersPickaxe;
    private ExplosivePickaxe explosivePickaxe;
    private BountifulPickaxe bountifulPickaxe;

    public TestCommand(BlockPickaxe blockPickaxe, SmeltersPickaxe smeltersPickaxe, ExplosivePickaxe explosivePickaxe, BountifulPickaxe bountifulPickaxe) {
        this.blockPickaxe = blockPickaxe;
        this.smeltersPickaxe = smeltersPickaxe;
        this.explosivePickaxe = explosivePickaxe;
        this.bountifulPickaxe = bountifulPickaxe;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("pick")) return false;

        if (args.length != 3 || !args[0].equalsIgnoreCase("give")) {
            sender.sendMessage("Usage: /pick give <player> <pickaxe>");
            return true;
        }

        Player target = sender.getServer().getPlayer(args[1]);
        if (target == null) {
            sender.sendMessage("Player not found.");
            return true;
        }

        String pickaxeName = args[2].toLowerCase();

        switch (pickaxeName) {
            case "block":
                target.getInventory().addItem(blockPickaxe.blockPickaxe);
                sender.sendMessage(ChatColour.message("Block Pickaxe given to ") + target.getName());
                break;
            case "smelter":
                target.getInventory().addItem(smeltersPickaxe.smeltersPickaxe);
                sender.sendMessage(ChatColour.message("Smelter Pickaxe given to ") + target.getName());
                break;
            case "explosive":
                target.getInventory().addItem(explosivePickaxe.explosivePickaxe);
                sender.sendMessage(ChatColour.message("Explosive Pickaxe given to") + target.getName());
                break;
            case "bountiful":
                target.getInventory().addItem(bountifulPickaxe.bountifulPickaxe);
                sender.sendMessage(ChatColour.message("Bountiful Pickaxe given to ") + target.getName());

                break;
            default:
                sender.sendMessage(ChatColour.message("Invalid pickaxe type. Choose from: block, smelter, explosive, bountiful."));
                break;
        }

        return true;
    }
}
