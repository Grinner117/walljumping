package genandnic.walljump.enchantment;

import genandnic.walljump.WallJump;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantment {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, WallJump.MOD_ID);

    public static final RegistryObject<Enchantment> DOUBLEJUMP = ENCHANTMENTS.register("doublejump", DoubleJumpEnchant::new);
    public static final RegistryObject<Enchantment> SPEEDBOOST = ENCHANTMENTS.register("speedboost", SpeedBoostEnchant::new);
    public static final RegistryObject<Enchantment> WALLJUMP = ENCHANTMENTS.register("walljump", WallJumpEnchant::new);
}
