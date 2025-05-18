package me.swever.prisonpicks.commands;

import me.swever.prisonpicks.items.custom.BlockPickaxe;
import me.swever.prisonpicks.items.custom.BountifulPickaxe;
import me.swever.prisonpicks.items.custom.ExplosivePickaxe;
import me.swever.prisonpicks.items.custom.SmeltersPickaxe;
import me.swever.prisonpicks.utils.ChatColour;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class TestCommand implements CommandExecutor {

    private BlockPickaxe blockPickaxe;
    private SmeltersPickaxe smeltersPickaxe;
    private ExplosivePickaxe explosivePickaxe;
    private BountifulPickaxe bountifulPickaxe; //Correct
                                                                                                                        //Correct
    public TestCommand(BlockPickaxe blockPickaxe, SmeltersPickaxe smeltersPickaxe, ExplosivePickaxe explosivePickaxe, BountifulPickaxe bountifulPickaxe){
        this.blockPickaxe = blockPickaxe;
        this.smeltersPickaxe = smeltersPickaxe;
        this.explosivePickaxe = explosivePickaxe;
        this.bountifulPickaxe = bountifulPickaxe; //Correct
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

        //Bad way to check for this, I'll include the correct way commented out below the line. Another 10 points if you can tell me why and what exactly has changed.
        Player target = sender.getServer().getPlayer(args[1]);
        /*
        Player target = null;
        try {
            target = Bukkit.getPlayerExact(args[1]);
        } catch (NullPointerException e) {
            sender.sendMessage("Player not found or offline!");
        }
        //Replaced '==' with '#equals()', have a google and see if you can tell me why '#equals()' is better in this case. (HINT: Tell me the difference between '==' and '#equals()').
        if (target == null) {
            sender.sendMessage("Player not found.");
            return true;
        }
         */

        /*
        This is interesting because I didn't teach you this. And, this is Java stuff. Not Spigot API stuff.
        Where did you get this from? And do you understand how this works? Or is it re-typed from online/AI?
        (Not annoyed as I see you're doing your research). But can you include comments throughout here explaining your thought process?
            -> And, how the code works, of course. Otherwise, using a switch statement is a good idea and segways into command groups.
                -> BUT... Using 'switch' statements will only work in these cases really. You don't want to have "switchers"
                    -> for args[1], args[2], args[3], args[4] and so on; otherwise your code gets really long and tedious.
                        -> And, you RARELY ever want to nest 'switch' statements because it ends up looking worse than nesting a million 'if' statements. (In other words, it's better readability)
         */
        String pickaxeName = args[2].toLowerCase();

        /*
        There are no colour codes in the messages?
        Also, side note: to make the player's names colour-coded, you want to do:
        ChatColour.message("&eBlock Pickaxe given to &b" + target.getName()));
        TL:DR, Putting the colour code before adding the string variable (In this case, target.getName() returns the targets name as a String variable)
            -> will set the name to whatever colour you choose. But the 'target.getName()' needs to be passed inside the 'ChatColor.message()' too.
         */
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
