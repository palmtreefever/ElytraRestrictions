package com.palmtreefever.ElytraRestrictions.Commands;

import java.util.Collections;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.google.common.math.Stats;
import com.palmtreefever.ElytraRestrictions.Main;

public class GetVel implements CommandExecutor {
	String sName = Main.plugin.getConfig().getString("ServerPrefix");
	String noPerm = Main.plugin.getConfig().getString("NoPermission");
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("getvel")) {
			if (sender.hasPermission("ER.GetVel")) {
				if(Main.Vs.isEmpty()) {
					sender.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + " No data collected yet! (It's hard disabled because it wasnt smooth at slowing elytra speeds)")));
					return true;
				}
				sender.sendMessage((ChatColor.translateAlternateColorCodes('&',sName +" Out Of " + Main.Vs.size() + ", " + Collections.max(Main.Vs) + " is the max!")));
				sender.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + " Avg: " + Stats.meanOf(Main.Vs.iterator()))));
				return true;
			}
			sender.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + noPerm)));
		}
		return false;
	}
}