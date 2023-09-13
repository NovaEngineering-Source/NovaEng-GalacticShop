package github.kasuminova.novaeng.gshop;

import github.kasuminova.novaeng.gshop.client.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("MethodMayBeStatic")
@Mod(modid = NovaEngineeringGShop.MOD_ID, name = NovaEngineeringGShop.MOD_NAME, version = NovaEngineeringGShop.VERSION,
        dependencies = "required-after:forge@[14.23.5.2847,);",
        acceptedMinecraftVersions = "[1.12, 1.13)"
)
public class NovaEngineeringGShop {
    public static final String MOD_ID = "novaeng_galactic_shop";
    public static final String MOD_NAME = "Nova Engineering: Galactic Shop";

    public static final String VERSION = Tags.VERSION;

    public static final String CLIENT_PROXY = "github.kasuminova.novaeng.gshop.client.proxy.ClientProxy";
    public static final String COMMON_PROXY = "github.kasuminova.novaeng.proxy.CommonProxy";

    public static final SimpleNetworkWrapper NET_CHANNEL = NetworkRegistry.INSTANCE.newSimpleChannel(MOD_ID);

    @Mod.Instance(MOD_ID)
    public static NovaEngineeringGShop instance = null;

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
    public static CommonProxy proxy = null;

    public static Logger log = null;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        event.getModMetadata().version = VERSION;
        log = event.getModLog();

        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }

}