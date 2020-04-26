package com.palmtreefever.ElytraRestrictions.Events;

import org.bukkit.World.Environment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class AntiGoldFarms implements Listener {
	
	@EventHandler
	public void pigmanSpawn(CreatureSpawnEvent e) {
		if(!e.getLocation().getWorld().getEnvironment().equals(Environment.NETHER)) {
			return;
		} else {
			if(!(e.getLocation().getY() >= 128)) {
				return;
			} else {
				if(!e.getEntityType().equals(EntityType.PIG_ZOMBIE)) {
					return;
				} else {
					//System.out.print("STOPPED");
					e.setCancelled(true);
				}
			}
		}
	}
}