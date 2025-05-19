package me.swever.prisonpicks.utils;

import me.swever.prisonpicks.items.custom.BlockPickaxe;
import me.swever.prisonpicks.items.custom.BountifulPickaxe;
import me.swever.prisonpicks.items.custom.ExplosivePickaxe;
import me.swever.prisonpicks.items.custom.SmeltersPickaxe;
import org.bukkit.inventory.ItemStack;

public class Pickaxes {
    private SmeltersPickaxe smeltersPickaxe;
    private ExplosivePickaxe explosivePickaxe;
    private BlockPickaxe blockPickaxe;
    private BountifulPickaxe bountifulPickaxe;
    public Pickaxes(SmeltersPickaxe smeltersPickaxe, ExplosivePickaxe explosivePickaxe, BlockPickaxe blockPickaxe, BountifulPickaxe bountifulPickaxe) {
        this.smeltersPickaxe = smeltersPickaxe;
        this.explosivePickaxe = explosivePickaxe;
        this.blockPickaxe = blockPickaxe;
        this.bountifulPickaxe = bountifulPickaxe;
    }

    public ItemStack getSmeltersPickaxe() {
        return smeltersPickaxe.smeltersPickaxe;
    }
    public ItemStack getExplosivePickaxe() {
        return explosivePickaxe.explosivePickaxe;
    }
    public ItemStack getBlockPickaxe() {
        return blockPickaxe.blockPickaxe;
    }
    public ItemStack getBountifulPickaxe() {
        return bountifulPickaxe.bountifulPickaxe;
    }

    
}
