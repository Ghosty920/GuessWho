package dev.ghosty.guesswho;

import dev.ghosty.guesswho.features.command.GWCommand;
import dev.ghosty.guesswho.config.ConfigHandler;
import dev.ghosty.guesswho.features.game.GameManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class GuessWho extends JavaPlugin {
	
	@Getter
	private static GuessWho instance;
	public boolean hasProtocolLib;
	public GameManager gameManager;
	public ConfigHandler configuration;
	
	@Override
	public void onLoad() {
		super.onLoad();
		instance = this;
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		hasProtocolLib = Bukkit.getPluginManager().isPluginEnabled("ProtocolLib");
		saveDefaultConfig();
		configuration = new ConfigHandler();
		gameManager = new GameManager();
		getCommand("guesswho").setExecutor(new GWCommand());
		getCommand("guesswho").setTabCompleter(new GWCommand());
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
}
