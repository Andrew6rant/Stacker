package io.github.Andrew6rant.stacker;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;

public class StackerClient implements ClientModInitializer {
    //public static StackerConfig CONFIG;

    @Override
    public void onInitializeClient() {
        //AutoConfig.register(StackerConfig.class, GsonConfigSerializer::new);
        //CONFIG = AutoConfig.getConfigHolder(StackerConfig.class).getConfig();
    }
}
