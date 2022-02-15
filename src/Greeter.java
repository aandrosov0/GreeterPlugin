import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public class Greeter extends JavaPlugin {
	private FileConfiguration config = getConfig();

	@Override 
	public void onEnable() {
		config.addDefault("join", "&e<player> &4JOIN TO THE SERVER");
		config.addDefault("quit", "&e<player> &4LEAVE FROM SERVER");

		config.options().copyDefaults(true);
		saveConfig();

		getServer().getPluginManager().registerEvents(new EventListener(config), this);
	}

	@Override 
	public void onDisable() {
		
	}
}