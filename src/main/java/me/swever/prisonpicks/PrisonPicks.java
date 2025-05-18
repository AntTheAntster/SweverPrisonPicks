package me.swever.prisonpicks;

import me.swever.prisonpicks.commands.TestCommand;
import me.swever.prisonpicks.items.custom.BlockPickaxe;
import me.swever.prisonpicks.items.custom.BountifulPickaxe;
import me.swever.prisonpicks.items.custom.ExplosivePickaxe;
import me.swever.prisonpicks.items.custom.SmeltersPickaxe;
import me.swever.prisonpicks.listeners.BlockPickaxeListener;
import me.swever.prisonpicks.listeners.ExplosivePickaxeListener;
import me.swever.prisonpicks.listeners.SmeltersPickaxeListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PrisonPicks extends JavaPlugin {
    private BlockPickaxe bp;
    private SmeltersPickaxe sp;
    private ExplosivePickaxe ep;
    private BountifulPickaxe btp; //Correct

    private PluginManager pm = Bukkit.getPluginManager(); //Plugin Manager for Registering Events

    
    @Override
    public void onEnable() {
        setup();
    }

    @Override
    public void onDisable() {

    }


    private void setup() {
        saveDefaultConfig();

        registerClasses();

        getCommand("pick").setExecutor(new TestCommand(bp,sp, ep, btp)); //Correct

        pm.registerEvents(new BlockPickaxeListener(bp), this);
        pm.registerEvents(new SmeltersPickaxeListener(sp), this);
        pm.registerEvents(new ExplosivePickaxeListener(ep),this);
        //What's missing here, I wonder? :)
    }

    private void registerClasses() {
        bp = new BlockPickaxe(this);
        sp = new SmeltersPickaxe(this);
        ep = new ExplosivePickaxe(this);
        btp = new BountifulPickaxe(this); //Correct
    }
}
