package dev.ghosty.guesswho.config;

import dev.ghosty.guesswho.GuessWho;
import org.bukkit.configuration.file.FileConfiguration;

public final class ConfigHandler {
	
	public ConfigHandler() {
		load();
	}
	
	public boolean isOnBungee;
	public String goBackWorld;
	public int worldsPerMap;
	public boolean hideItem;
	
	public void load() {
		FileConfiguration config = GuessWho.getInstance().getConfig();
		this.isOnBungee = config.getBoolean("bungee", false);
		this.goBackWorld = config.getString("world", "NONE");
		this.worldsPerMap = config.getInt("worldsPerMap", 1);
		this.hideItem = config.getBoolean("hideItem", true);
	}
	
}
