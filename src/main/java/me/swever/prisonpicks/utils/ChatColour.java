package me.swever.prisonpicks.utils;

import org.bukkit.ChatColor;

public class ChatColour {

    public static String message(String message) {
        String msg = ChatColor.translateAlternateColorCodes('&', message);;

        return msg;
    }

}
