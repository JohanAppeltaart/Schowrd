package nl.johanappeltaart.schowrd.init;

import nl.johanappeltaart.schowrd.Schowrd;
//import com.johanappeltaart.schowrd.entity.item.BananaBoatEntity;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Schowrd.MOD_ID);

    //Boat Entity
//    public static RegistryObject<EntityType<BananaBoatEntity>> BANANA_BOAT = ENTITY_TYPES.register("banana_boat",
//            ()->EntityType.Builder.<BananaBoatEntity>create(BananaBoatEntity::new, EntityClassification.MISC)
//                    .size(1.375F, 0.5625F)
//                    .func_233606_a_(10)
//                    .build(new ResourceLocation(Schowrd.MOD_ID, "banana_boat").toString()));

}
