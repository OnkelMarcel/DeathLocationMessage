package de.snowcase.deathlocation;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.snowcase.deathlocation.events.DeathLocationEvent;

public class DeathLocationMain extends JavaPlugin {
	
	public void onEnable() {
		loadCommands();
		loadConfig();
		registerEvents(getServer().getPluginManager());
	}
	
	public void loadCommands() {
		
	}
	
	public void registerEvents(PluginManager pm) {
		pm.registerEvents(new DeathLocationEvent(), this);
	}
	
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
}
