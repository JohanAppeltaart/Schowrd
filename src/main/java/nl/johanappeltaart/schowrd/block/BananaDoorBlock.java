package nl.johanappeltaart.schowrd.block;

import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class BananaDoorBlock extends DoorBlock {

    public BananaDoorBlock() {
        super(Properties.create(Material.WOOD, MaterialColor.WOOD)
                .hardnessAndResistance(0.5f)
                .slipperiness(1.1f)
                .sound(SoundType.WOOD)
                .tickRandomly()
                .harvestLevel(0)
                .harvestTool(ToolType.AXE)
        );
    }
}
