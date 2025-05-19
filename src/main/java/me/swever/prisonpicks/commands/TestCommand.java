package me.swever.prisonpicks.commands;

import me.swever.prisonpicks.utils.ChatColour;
import me.swever.prisonpicks.utils.Pickaxes;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {

    private Pickaxes pickaxes; //Correct
                                                                                                                        //Correct
    public TestCommand(Pickaxes pickaxes) {
        this.pickaxes = pickaxes;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("pick")) return false; //Good idea changing a 'true' check to a 'false' check. 10 points if you can tell me why (I've told you the reason to check for false's over true's previously)

        /*
        Bad idea doing it this way.
        By doing it this way, you are checking for the length of the args array (args length) to be 3 and 3 only.
        Therefore, the command will only work if the player enters /pick give <player> <pickaxe> no matter who issues the command.
        You should still include a /pick command with 0 args that will open an admin GUI that pickaxes can be taken from.
        I'll go over GUI's in our next lesson.
        TLDR; don't force people to have to provide 3 arguments as it can be tedious in the long run,
            -> especially if they're trying to give themselves only the pickaxe(s).
         */
        if (args.length != 3 || !args[0].equalsIgnoreCase("give")) {
            sender.sendMessage("Usage: /pick give <player> <pickaxe>");
            return true;
        }

        Player target = null;
        try {
            target = Bukkit.getPlayerExact(args[1]);
        } catch (NullPointerException e) {
            sender.sendMessage(ChatColour.message("&cPlayer not found"));
        }

        if(target == null) {
            sender.sendMessage(ChatColour.message("&cPlayer not found"));
        }

        String pickaxeName = args[2].toLowerCase();

        switch (pickaxeName) {
            case "block":
                target.getInventory().addItem(pickaxes.getBlockPickaxe());
                sender.sendMessage(ChatColour.message("Block Pickaxe given to " + target.getName()));
                break;
            case "smelter":
                target.getInventory().addItem(pickaxes.getSmeltersPickaxe());
                sender.sendMessage(ChatColour.message("Smelter Pickaxe given to " + target.getName()));
                break;
            case "explosive":
                target.getInventory().addItem(pickaxes.getExplosivePickaxe());
                sender.sendMessage(ChatColour.message("Explosive Pickaxe given to" + target.getName()));
                break;
            case "bountiful":
                target.getInventory().addItem(pickaxes.getBountifulPickaxe());
                sender.sendMessage(ChatColour.message("Bountiful Pickaxe given to " + target.getName()));

                break;
            default:

                sender.sendMessage(ChatColour.message("Invalid pickaxe type. Choose from: block, smelter, explosive, bountiful."));
                break;
        }

        return true;
    }
}
