package io.github.Andrew6rant.stacker;

import io.github.Andrew6rant.stacker.mixin.ItemAccess;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;
import java.util.stream.Collectors;

import static net.minecraft.util.registry.Registry.ITEM_KEY;

public class Stacker implements ModInitializer {
	private static Stacker stacker;
	static ConfigHolder<StackerConfig> stackerConfig;
	@Override
	public void onInitialize() {
		stacker = this;
		stackerConfig = AutoConfig.register(StackerConfig.class, GsonConfigSerializer::new);
		stackerConfig.registerSaveListener((configHolder, stackerConfig1) -> {
			loadStacker("save");
			return ActionResult.success(true);
		});
		ServerLifecycleEvents.SERVER_STARTED.register(server -> {
			loadStacker("load");
		});
		ServerLifecycleEvents.END_DATA_PACK_RELOAD.register((server, resourceManager, success) -> {
			loadStacker("reload");
		});
	}
	public static void loadStacker(String configMsg) {
		System.out.println("Stacker: Attempting to "+configMsg+" config...");
		for (Item item : Registry.ITEM) {
			if (!item.isDamageable()) {
				if (!Stacker.hasConfigTag(item, stackerConfig.getConfig().itemIgnore)) {
					if (!Stacker.hasConfigItem(Registry.ITEM.getId(item).toString(), stackerConfig.getConfig().itemIgnore)) {
						Stacker.setMax(item, stackerConfig.getConfig().maxStacker);
					}
				}
			}
			Stacker.setMax(item, Stacker.overrideItem(item, stackerConfig.getConfig().itemOverride));
		}
		System.out.println(configMsg.equals("save") ? "Stacker: Config saved!": "Stacker: Config "+configMsg+"ed!");
	}
	public static void setMax(Item item, int max) {
		if (max >0) {
			((ItemAccess) item).setMaxCount(max);
		}
	}
	public StackerConfig getStackerConfig() {
		return stackerConfig.getConfig();
	}
	public static Stacker getStacker() {
		return stacker;
	}
	public static Integer overrideItem(Item item, List<String> overrideList) {
		for(String overrideEntry : overrideList) {
			if (overrideEntry.startsWith("#")) {
				String[] splitEntry = overrideEntry.substring(1).split(":"); // split into three parts: tag id, item name, max count
				List<TagKey<Item>> itemStream = item.getRegistryEntry().streamTags().collect(Collectors.toList());
				for (TagKey<Item> tagKey : itemStream) {
					if (item.getRegistryEntry().isIn(TagKey.of(ITEM_KEY, new Identifier(splitEntry[0], splitEntry[1])))) {
						return Integer.parseInt(splitEntry[2]);
					}
				}
			} else {
				String[] splitEntry = overrideEntry.split(":"); // split into three parts: tag id, item name, max count
				if (Registry.ITEM.getId(item).toString().equalsIgnoreCase(splitEntry[0] + ":" + splitEntry[1])) {
					return Integer.parseInt(splitEntry[2]);
				}
			}
		}
		return 0;
	}
	public static boolean hasConfigTag(Item item, List<String> configTags) {
		for(String tag : configTags) {
			if (tag.startsWith("#")) {
				String[] splitTag = tag.substring(1).split(":"); // split into two parts: tag id, item name
				List<TagKey<Item>> itemStream = item.getRegistryEntry().streamTags().collect(Collectors.toList());
				for (TagKey<Item> tagKey : itemStream) {
					if (item.getRegistryEntry().isIn(TagKey.of(ITEM_KEY, new Identifier(splitTag[0], splitTag[1])))) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public static boolean hasConfigItem(String registryItem, List<String> configItems) {
		for(String item : configItems) {
			if(registryItem.equalsIgnoreCase(item.trim())) {
				return true;
			}
		}
		return false;
	}
}
