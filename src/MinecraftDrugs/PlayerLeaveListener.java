package MinecraftDrugs;

import java.io.File;
import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener
{	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) throws IOException
	{
		FileHandler handler = new FileHandler();
		Player player = event.getPlayer();
		String name = player.getName();
		File dir = new File(DrugsInit.DOCUMENTS + "\\datafiles\\" + "\\" + name.charAt(0) + "\\" + name + "\\");
		File file = new File(dir + "\\" + name + ".ini\\");
		
		handler.fileSave(file, DrugsInit.playerStats.get(DrugsInit.playerid.get(name)));
		DrugsInit.playeridUsed[DrugsInit.playerid.get(name)] = false;
		DrugsInit.playerid.remove(name);
		return;
	}
}
