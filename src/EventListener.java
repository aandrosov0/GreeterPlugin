import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import org.bukkit.configuration.file.FileConfiguration;

import org.bukkit.Bukkit;

class EventListener implements Listener {
	private FileConfiguration config;

	EventListener(FileConfiguration config) {
		this.config = config;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		String joinMsg = parseConfig("join", event);
        event.setJoinMessage(joinMsg);
	}

	@EventHandler 
	public void onPlayerQuit(PlayerQuitEvent event) {
        String quitMsg = parseConfig("quit", event);
        event.setQuitMessage(quitMsg);
	}

	private String parseConfig(String string, PlayerEvent event) {
		String displayName = event.getPlayer().getDisplayName();
		return config.getString(string).replace("&", "§").replace("<player>", displayName);
	}
}