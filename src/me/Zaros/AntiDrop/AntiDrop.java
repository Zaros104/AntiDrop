package me.Zaros.AntiDrop;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiDrop extends JavaPlugin {
	static Logger log = Logger.getLogger("Minecraft");
	private final PL playerListener = new PL(this);
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		log.info("[AntiDrop] v" + pdfFile.getVersion() + " - Disabled");
	}

	@Override
	public void onEnable() {	
		PluginDescriptionFile pdfFile = this.getDescription();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_DROP_ITEM, playerListener, Priority.Normal, this);
		log.info("[AntiDrop] v" + pdfFile.getVersion() + " - Enabled");		
	}
}