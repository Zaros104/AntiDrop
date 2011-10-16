package me.Zaros.AntiDrop;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerListener;
import static me.Zaros.AntiDrop.AntiDrop.log;

public class PL extends PlayerListener{
	
    public final AntiDrop plugin;

    public PL(AntiDrop plugin) {
        this.plugin = plugin;
    }
	
    //Special thanks to celticmistrel who taught me something
    
    @Override
	public void onPlayerDropItem(PlayerDropItemEvent e){
		Player p = e.getPlayer();
		String pstring = e.getPlayer().getName();
		if (p.getGameMode().equals(GameMode.CREATIVE)) {
			if (!p.hasPermission("AntiDrop.Allow") && !p.isOp()) {
				p.sendMessage(ChatColor.RED + "You are not allowed to do this.");
				log.info("Player '" + pstring + "' tried to drop blocks in creative mode!");
				e.setCancelled(true);
			}
		}
	}
}
