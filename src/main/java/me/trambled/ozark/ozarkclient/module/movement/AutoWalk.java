package me.trambled.ozark.ozarkclient.module.movement;

import net.minecraft.client.settings.KeyBinding;
import me.trambled.ozark.ozarkclient.module.Category;
import me.trambled.ozark.ozarkclient.module.Module;

public class AutoWalk extends Module
{
    public AutoWalk() {
        super(Category.MOVEMENT);
        this.name = "AutoWalk";
        this.tag = "AutoWalk";
        this.description = "automatically walks";
    }
    

    public void update() {
        KeyBinding.setKeyBindState(AutoWalk.mc.gameSettings.keyBindForward.getKeyCode(), true);
    }

