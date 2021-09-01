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
    /*public enum itemCountScale {
        VARIABLE(),
        LARGE,
        MEDIUM,
        SMALL
    }*/
    //@ConfigEntry.Category("Stacker Config")
    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.Tooltip
    public int maxStacker = 64;

    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.Tooltip
    public boolean variableOverride = true;

    @ConfigEntry.Gui.Tooltip
    //public ItemCountRenderEnum itemCountScale = ItemCountRenderEnum.VARIABLE;
    @ConfigEntry.BoundedDiscrete(min = 0, max = 50)
    public int itemCountScaleInt = 25;
    //public enum itemCountScale = VARIABLE;

    static {
        AutoConfig.register(StackerConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(StackerConfig.class).getConfig();
    }
}
