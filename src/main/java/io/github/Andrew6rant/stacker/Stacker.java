package io.github.Andrew6rant.stacker;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class Stacker implements ModInitializer {
	public static StackerConfig CONFIG;

	@Override
	public void onInitialize() {
		AutoConfig.register(StackerConfig.class, GsonConfigSerializer::new);
		CONFIG = AutoConfig.getConfigHolder(StackerConfig.class).getConfig();
	}
}
