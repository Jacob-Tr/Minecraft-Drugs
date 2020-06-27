package MinecraftDrugs;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener
{
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) throws IOException
	{
		FileHandler handler = new FileHandler();
		Player player = event.getPlayer();
		String name = player.getName();
		File dir = new File(DrugsInit.DOCUMENTS + "\\datafiles\\" + "\\" + name.charAt(0) + "\\" + name + "\\");
		File file = new File(dir + "\\" + name + ".ini\\");
		
		//player.getServer().broadcastMessage((System.getenv("USERPROFILE")));
		
		for(int i = 0; i <= DrugsInit.MAX_PLAYERS; i++)
		{
			if(DrugsInit.playeridUsed[i] == false)
			{
				DrugsInit.playerid.put(name, i);
				DrugsInit.playeridUsed[i] = true;
				break;
			}
		}
		DrugsInit.playerPool++;
		
		if(handler.fileExists(file))
		{
			DrugsInit.playerStats.add(DrugsInit.playerid.get(name), handler.fileLoad(file, DrugsInit.numberOfStats(), player));
		}
		else
		{
			handler.fileCreate(dir, file, player);
			
			DrugsInit.playerStats.add(DrugsInit.playerid.get(name), handler.fileLoad(file, DrugsInit.numberOfStats(), player));
		}
		return;
	}
}
