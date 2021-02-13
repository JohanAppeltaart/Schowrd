package nl.johanappeltaart.schowrd.items;

import nl.johanappeltaart.schowrd.Schowrd;

import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {

	public ItemBase() {
		super(new Item.Properties().group(Schowrd.TAB));
	}

}
