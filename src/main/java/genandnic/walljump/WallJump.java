package genandnic.walljump;

import genandnic.walljump.enchantment.ModEnchantment;
import genandnic.walljump.proxy.ClientProxy;
import genandnic.walljump.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(WallJump.MOD_ID)
@Mod.EventBusSubscriber(modid = WallJump.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WallJump {
    public static final String MOD_ID = "walljump";
    public static final CommonProxy PROXY = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    public static final Logger LOGGER = LogManager.getLogger();

    public WallJump() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        ModEnchantment.ENCHANTMENTS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_SPEC);
    }

    // imports up here // 


    private void setup(final FMLCommonSetupEvent event) {

    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        PROXY.setupCommon();
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        PROXY.setupClient();
    }

}
