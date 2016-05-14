package com.github.elcreeperhd.CurseIPFix;

import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class EventListener implements Listener{


	private Main plugin;

	public EventListener(Main plugin)
	{
		this.plugin = plugin;
	}
	boolean ipforwarding = true;
	String fixedip;

	@EventHandler(ignoreCancelled=true)
	public void LoginEvent(PlayerLoginEvent ev){
		if(ipforwarding == true)	{
			fixedip = ev.getRealAddress().toString();
		}else if(ipforwarding == false){	
			fixedip = ev.getAddress().toString();
		}	

		fixedip = fixedip.replaceAll("/", "");
		final String bungeeip = "104.129.41.37";
		Log.info(ev.getPlayer().getName() + "joined using " + fixedip);
		try{	

			if(!fixedip.equals(bungeeip)){	
				ev.disallow(Result.KICK_OTHER, "Please connect using the bungee IP!");
			}//end ip check

		}//end try
		catch(Exception e){	
			e.printStackTrace();
		}


	}


}
