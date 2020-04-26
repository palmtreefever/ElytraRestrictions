package com.palmtreefever.ElytraRestrictions.Events;

import org.bukkit.ChatColor;
import org.bukkit.World.Environment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import com.palmtreefever.ElytraRestrictions.Main;

public class Gliding implements Listener {
	
	String sName = Main.plugin.getConfig().getString("ServerPrefix");
	String denyMessage = Main.plugin.getConfig().getString("DenyNetherRoof");
	@EventHandler
	public void moveCheck(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if (!p.getWorld().getEnvironment().equals(Environment.NETHER)) {
			return;
		} else if (!(p.getLocation().getY() >= 128)) { // if their y in nether doesnt equal 128
			return;
		} else if (e.getTo().getBlockX() == e.getFrom().getBlockX() && e.getTo().getBlockZ() == e.getFrom().getBlockZ()) { // returns if dont actually move
			return;
		} else { // if they actually move either X or Z
			if(e.getTo().getChunk() != e.getFrom().getChunk()) {
			p.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + denyMessage)));
			e.setCancelled(true);  
			//p.teleport(p.getServer().getWorlds().get(0).getSpawnLocation(),TeleportCause.PLUGIN);
			return;
			} else 
			{
				return;
			}
		}
		/**
		if (!p.isGliding()) {
			return;
		} else if (!p.getInventory().getChestplate().getType().equals(Material.ELYTRA)) {
			return;
		} else {
			Main.Vs.add(p.getVelocity().length());
			if (p.getVelocity().length() > Main.plugin.getConfig().getInt("Elytra-Speed-Max")) {
				p.sendMessage(ChatColor.RED + "Speed Limit hit! " + p.getVelocity().length());
				p.setVelocity(p.getVelocity().multiply(Main.plugin.getConfig().getInt("Elytra-Speed-Decrease")));
			}
			return;
		} **/
	} 
}