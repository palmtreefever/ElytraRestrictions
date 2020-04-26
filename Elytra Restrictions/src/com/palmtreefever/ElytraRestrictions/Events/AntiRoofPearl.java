package com.palmtreefever.ElytraRestrictions.Events;

import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class AntiRoofPearl implements Listener {
	
	@EventHandler
	public void throwPearl(PlayerInteractEvent e) {
		final Player p = e.getPlayer();

		if (!p.getWorld().getEnvironment().equals(Environment.NETHER)) {
			return;
		} else {
			if (!e.getMaterial().equals(Material.ENDER_PEARL)) {
				return;
			} else {
				if (!(p.getLocation().getY() >= 128)) {
					return;
				} else {
					e.setCancelled(true);
				}
			}
		}
	}
}