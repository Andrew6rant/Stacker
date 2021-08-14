package io.github.Andrew6rant.stacker;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

@Config(name = "stacker")
public class StackerConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    public int maxStacker = 64;

    public static StackerConfig CONFIG;

    static {
        AutoConfig.register(StackerConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(StackerConfig.class).getConfig();
    }
}
