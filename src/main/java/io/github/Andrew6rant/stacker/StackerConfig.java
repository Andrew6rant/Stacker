package io.github.Andrew6rant.stacker;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "stacker")
public class StackerConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    public int maxStacker = 64;
}
