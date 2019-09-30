package de.snowcase.deathlocation.events;

import java.io.File;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathLocationEvent implements Listener {
	
	// only needed in this Class so both is private
	private File file = new File("plugins/DeathLocationMessage/config.yml");
	private FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		Location loc = event.getEntity().getLocation();
		
		String message = fc.getString("location.message");
		
		String xReplaced = message.replace("%x", String.valueOf(loc.getBlockX()));
		String yReplaced = xReplaced..replace("%y", String.valueOf(loc.getBlockY()));
		String zReplaced = yReplaced..replace("%z", String.valueOf(loc.getBlockZ()));
		String playerNameReplaced = zReplaced.replace("%name", event.getEntity().getDisplayName());
		
		event.setDeathMessage(playerNameReplaced);
		
	}

}
