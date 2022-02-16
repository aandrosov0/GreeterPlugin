import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public class Greeter extends JavaPlugin {
	private FileConfiguration config = getConfig();

	@Override 
	public void onEnable() {
		config.addDefault("join", "&e<player> &4JOIN TO THE SERVER");
		config.addDefault("quit", "&e<player> &4LEAVE FROM SERVER");

		config.addDefault("join-display", null);
		config.addDefault("join-display.title-display", "WELCOME TO THE SERVER");
		config.addDefault("join-display.subtitle-display", "THANKS FOR USING Greeter PLUGIN");

		config.options().copyDefaults(true);
		saveConfig();

		getServer().getPluginManager().registerEvents(new EventListener(config), this);
	}

	@Override 
	public void onDisable() {
		
	}
}