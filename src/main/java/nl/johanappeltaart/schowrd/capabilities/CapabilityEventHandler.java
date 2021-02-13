package nl.johanappeltaart.schowrd.capabilities;

import nl.johanappeltaart.schowrd.Schowrd;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class CapabilityEventHandler
{
	public static final ResourceLocation PLAYER_PAST_POS_AND_DIM = new ResourceLocation(Schowrd.MOD_ID, "player_past_pos_and_dim");

	public static void onAttachCapabilitiesToEntities(AttachCapabilitiesEvent<Entity> e)
	{
		Entity ent = e.getObject();
		if (ent instanceof PlayerEntity)
		{
			e.addCapability(PLAYER_PAST_POS_AND_DIM, new PastPosAndDimProvider());
		}
	}
}