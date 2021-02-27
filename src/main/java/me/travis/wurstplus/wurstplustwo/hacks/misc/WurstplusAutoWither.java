package me.travis.wurstplus.wurstplustwo.hacks.misc;

import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.travis.wurstplus.wurstplustwo.util.WurstplusBlockInteractHelper;
import me.travis.wurstplus.wurstplustwo.util.WurstplusBlockUtil;
import me.travis.wurstplus.wurstplustwo.util.WurstplusMessageUtil;
import me.travis.wurstplus.wurstplustwo.util.WurstplusPlayerUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;

/**
 * Made by @Trambled on 2/17/2021
 * Modified from WurstplusSocks
 */
public class WurstplusAutoWither extends WurstplusHack {

    public WurstplusAutoWither() {
        super(WurstplusCategory.WURSTPLUS_MISC);

        this.name = "Auto Wither";
        this.tag = "AutoWither";
        this.description = "makes withers";
    }

    WurstplusSetting tick_for_place = create("Delay", "AutoWitherDelay", 2, 0, 10);
    WurstplusSetting rotate = create("Rotate", "AutoWitherRotate", true);
    WurstplusSetting swing = create("Swing", "AutoWitherSwing", "Mainhand", combobox("Mainhand", "Both", "Offhand"));

    private int delay_counter;

    @Override
    public void update() {
        if (find_soulsand_hotbar() == -1) {
            WurstplusMessageUtil.send_client_error_message("No Soulsand!");
            this.set_disable();
        }

        if (find_witherskull_hotbar() == -1) {
            WurstplusMessageUtil.send_client_message("No Wither Skulls!");
            this.set_disable();
        }

        if (did_soul_sand()) {
            do_wither_skull();
        } else {
            do_soul_sand();
        }
    }

    public void do_soul_sand() {
        BlockPos center_pos = WurstplusPlayerUtil.GetLocalPlayerPosFloored();
        ArrayList<BlockPos> blocks_to_fill = new ArrayList<>();

        switch (WurstplusPlayerUtil.GetFacing())
        {
            case East:
                blocks_to_fill.add(center_pos.east().east());
                blocks_to_fill.add(center_pos.east().east().up());
                blocks_to_fill.add(center_pos.east().east().up().north());
                blocks_to_fill.add(center_pos.east().east().up().south());
                break;
            case North:
                blocks_to_fill.add(center_pos.north().north());
                blocks_to_fill.add(center_pos.north().north().up());
                blocks_to_fill.add(center_pos.north().north().up().west());
                blocks_to_fill.add(center_pos.north().north().up().east());
                break;
            case South:
                blocks_to_fill.add(center_pos.south().south());
                blocks_to_fill.add(center_pos.south().south().up());
                blocks_to_fill.add(center_pos.south().south().up().west());
                blocks_to_fill.add(center_pos.south().south().up().east());
                break;
            case West:
                blocks_to_fill.add(center_pos.west().west());
                blocks_to_fill.add(center_pos.west().west().up());
                blocks_to_fill.add(center_pos.west().west().up().north());
                blocks_to_fill.add(center_pos.west().west().up().south());
                break;
            default:
                break;
        }

        BlockPos pos_to_fill = null;

        for (BlockPos pos : blocks_to_fill) {

            WurstplusBlockInteractHelper.ValidResult result = WurstplusBlockInteractHelper.valid(pos);

            if (result != WurstplusBlockInteractHelper.ValidResult.Ok) continue;

            if (pos == null) continue;

            pos_to_fill = pos;
            break;

        }

        if (delay_counter > this.tick_for_place.get_value(1)) {
            WurstplusBlockUtil.placeBlock(pos_to_fill, find_soulsand_hotbar(), rotate.get_value(true), rotate.get_value(true), swing);
            delay_counter = 0;
        }

        delay_counter++;
    }

    public void do_wither_skull() {

        BlockPos center_pos = WurstplusPlayerUtil.GetLocalPlayerPosFloored();
        ArrayList<BlockPos> blocks_to_fill = new ArrayList<>();

        switch (WurstplusPlayerUtil.GetFacing())
        {
            case East:
                blocks_to_fill.add(center_pos.east().east().up().up());
                blocks_to_fill.add(center_pos.east().east().up().up().south());
                blocks_to_fill.add(center_pos.east().east().up().up().north());
                break;
            case North:
                blocks_to_fill.add(center_pos.north().north().up().up());
                blocks_to_fill.add(center_pos.north().north().up().up().east());
                blocks_to_fill.add(center_pos.north().north().up().up().west());
                break;
            case South:
                blocks_to_fill.add(center_pos.south().south().up().up());
                blocks_to_fill.add(center_pos.south().south().up().up().west());
                blocks_to_fill.add(center_pos.south().south().up().up().east());
                break;
            case West:
                blocks_to_fill.add(center_pos.west().west().up().up());
                blocks_to_fill.add(center_pos.west().west().up().up().north());
                blocks_to_fill.add(center_pos.west().west().up().up().south());
                break;
            default:
                break;
        }

        BlockPos pos_to_fill = null;

        for (BlockPos pos : blocks_to_fill) {

            WurstplusBlockInteractHelper.ValidResult result = WurstplusBlockInteractHelper.valid(pos);

            if (result != WurstplusBlockInteractHelper.ValidResult.Ok) continue;

            if (pos == null) continue;

            pos_to_fill = pos;
            break;

        }

        if (delay_counter > this.tick_for_place.get_value(1)) {
            WurstplusBlockUtil.placeBlock(pos_to_fill, find_witherskull_hotbar(), rotate.get_value(true), rotate.get_value(true), swing);
            delay_counter = 0;
        }

        delay_counter++;
    }


    private int find_soulsand_hotbar() {

        for (int i = 0; i < 9; ++i) {

            final ItemStack stack = mc.player.inventory.getStackInSlot(i);

            if (stack != ItemStack.EMPTY && stack.getItem() instanceof ItemBlock) {

                final Block block = ((ItemBlock) stack.getItem()).getBlock();

                if (block instanceof BlockSoulSand)
                    return i;


            }
        }
        return -1;
    }

    //this is from salhack
    private int find_witherskull_hotbar()
    {
        for (int i = 0; i < 9; ++i)
        {
            final ItemStack stack = mc.player.inventory.getStackInSlot(i);
            if (stack != ItemStack.EMPTY && stack.getItem() instanceof ItemSkull)
                return i;
        }
        return -1;
    }

    //kinda from salhack
    public static boolean did_soul_sand()
    {
        BlockPos player_pos = WurstplusPlayerUtil.GetLocalPlayerPosFloored();

        final BlockPos[] east_pos = {
            player_pos.east().east(),
            player_pos.east().east().up(),
            player_pos.east().east().up().north(),
            player_pos.east().east().up().south(),
        };

        final BlockPos[] west_pos = {
            player_pos.west().west(),
            player_pos.west().west().up(),
            player_pos.west().west().up().north(),
            player_pos.west().west().up().south(),
        };

        final BlockPos[] north_pos = {
            player_pos.north().north(),
            player_pos.north().north().up(),
            player_pos.north().north().up().west(),
            player_pos.north().north().up().east(),
        };

        final BlockPos[] south_pos = {
            player_pos.south().south(),
            player_pos.south().south().up(),
            player_pos.south().south().up().west(),
            player_pos.south().south().up().east(),
        };

        switch (WurstplusPlayerUtil.GetFacing()) {
            case East:
                for (BlockPos l_Pos : east_pos)
                {
                    IBlockState l_State = mc.world.getBlockState(l_Pos);

                    if (l_State.getBlock() != Blocks.SOUL_SAND)
                        return false;
                }
                break;
            case West:
                for (BlockPos l_Pos : west_pos)
                {
                    IBlockState l_State = mc.world.getBlockState(l_Pos);

                    if (l_State.getBlock() != Blocks.SOUL_SAND)
                        return false;
                }
                break;
            case North:
                for (BlockPos l_Pos : north_pos)
                {
                    IBlockState l_State = mc.world.getBlockState(l_Pos);

                    if (l_State.getBlock() != Blocks.SOUL_SAND)
                        return false;
                }
                break;
            case South:
                for (BlockPos l_Pos : south_pos)
                {
                    IBlockState l_State = mc.world.getBlockState(l_Pos);

                    if (l_State.getBlock() != Blocks.SOUL_SAND)
                        return false;
                }
                break;
            default:
                break;
        }

        return true;
    }

}
