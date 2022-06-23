package io.github.Andrew6rant.stacker;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Items;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Config(name = "stacker")
public class StackerConfig implements ConfigData {

    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.Tooltip
    public int maxStacker = 64;

    @ConfigEntry.Gui.Tooltip
    public boolean fontOverride = true;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 0, max = 50)
    public int itemCountScaleInt = 25;

    @ConfigEntry.Gui.Tooltip
    public List<String> itemOverride = Arrays.asList(
        "minecraft:bundle:1",
        "minecraft:totem_of_undying:16",
        "#c:potions:16",
        "#inmis:backpacks:1",
        "#techreborn:not_stackable:1"
    );
}
