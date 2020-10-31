package com.johanappeltaart.schowrd.util;

import net.minecraft.item.ItemUseContext;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

public class BlockposArray {
    public static BlockPos[] BlockposArrayfromNum(ItemUseContext context, int x, int y){
//        x= (int) Math.floor(x/2);
//        y= (int) Math.floor(y/2);

        ArrayList<BlockPos> blockpositions = new ArrayList<>();
//        BlockPos[] blockpositions = new BlockPos[(x+2)*(y+2)];
        switch(context.getFace()){
            case UP:case DOWN:
                for(int a=-x;a<=x;a++){
                    for(int b=-y;b<=y;b++){
                        blockpositions.add(context.getPos().add(a,0,b));
                    }
                }
                break;
            case EAST:case WEST:
                for(int a=-x;a<=x;a++){
                    for(int b=-y;b<=y;b++){
                        blockpositions.add(context.getPos().add(0,a,b));
                    }
                }
                break;
            case NORTH:case SOUTH:
                for(int a=-x;a<=x;a++){
                    for(int b=-y;b<=y;b++){
                        blockpositions.add(context.getPos().add(a,b,0));
                    }
                }
                break;
        }
//        for(int j=0;j<=8;j++){
//            blockpositions.add(context.getPos().add(0,0,0));
//            blockpositions.add(2);
//        }
//        LogManager.getLogger().info("bposabpos "+blockpositions);
        return blockpositions.toArray(new BlockPos[0]);
    }
}
