package io.github.Andrew6rant.stacker;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "stacker")
public class StackerConfig implements ConfigData {
    public static StackerConfig CONFIG;
    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.Tooltip
    public int maxStacker = 64;

    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.Tooltip
    public boolean variableOverride = true;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 0, max = 50)
    public int itemCountScaleInt = 25;

    static {
        AutoConfig.register(StackerConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(StackerConfig.class).getConfig();
    }
}
