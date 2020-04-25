package com.palmtreefever.ElytraRestrictions;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.palmtreefever.ElytraRestrictions.Commands.GetVel;
import com.palmtreefever.ElytraRestrictions.Events.Gliding;

public class Main extends JavaPlugin implements Listener {

	public static Plugin plugin;
	public static ArrayList<Double> Vs = new ArrayList<Double>();

	public void onEnable() {
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new Gliding(), this);
		getCommand("getvel").setExecutor(new GetVel());
		loadConfig();
	}

	public void onDisable() {
		saveDefaultConfig();
	}

	private void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
	}

}