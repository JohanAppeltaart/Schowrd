package nl.johanappeltaart.schowrd.block;

import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class StrippedBananaLog extends RotatedPillarBlock {
    public StrippedBananaLog() {
        super(Properties.create(
                Material.WOOD,MaterialColor.GOLD)
                .hardnessAndResistance(2.0F)
                .slipperiness(1.2F)
                .sound(SoundType.WOOD));
    }
}