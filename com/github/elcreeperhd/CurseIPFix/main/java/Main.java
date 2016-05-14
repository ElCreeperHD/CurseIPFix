package com.github.elcreeperhd.CurseIPFix;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	public Logger log = Bukkit.getLogger();
	public EventListener event = new EventListener(this);
	
	public void onEnable(){	
		log.info("CurseIPFix enabled");
		Bukkit.getServer().getPluginManager().registerEvents(event, this);
	}
	public void onDisable(){	
		log.info("CurseIPFix disabled");
	}
}
