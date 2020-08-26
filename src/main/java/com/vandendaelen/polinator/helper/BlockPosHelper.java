package com.vandendaelen.polinator.helper;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BlockPosHelper {
    public static ArrayList<BlockPos> getFreeBlockInRadius(World world, int radius, BlockPos center){
        int semiRadius = radius/2;
        BlockPos start = center.add(-semiRadius, -semiRadius, -semiRadius);
        BlockPos end = center.add(semiRadius, semiRadius, semiRadius);
        ArrayList<BlockPos> blockPosArrayList = new ArrayList<>();

        for(int x = start.getX(); x <= end.getX(); x++){
            for (int z = start.getZ(); z <= end.getZ(); z++){
                for (int y = start.getY(); y <= end.getY(); y++){
                    blockPosArrayList.add(new BlockPos(x, y, z));
                }
            }
        }

        return (ArrayList<BlockPos>) blockPosArrayList.stream()
                .filter(pos -> world.isAirBlock(pos))
                .filter(pos -> world.getBlockState(pos.add(0,-1,0)).equals(Blocks.DIRT.getDefaultState()) || world.getBlockState(pos.add(0,-1,0)).equals(Blocks.GRASS_BLOCK.getDefaultState()))
                .collect(Collectors.toList());
    }
}
