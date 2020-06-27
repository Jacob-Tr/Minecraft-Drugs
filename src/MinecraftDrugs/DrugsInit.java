package MinecraftDrugs;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class DrugsInit extends JavaPlugin
{
	public static final String DOCUMENTS = ((System.getenv("USERPROFILE"))+("\\Desktop\\Games\\Minecraft server\\"));  // Only works with English computers.
	//public static final Plugin plugin = new DrugsInit();
	
	public static final int MAX_PLAYERS = 150;
	
	public static int playerPool = -1;
	
	public static int highLevel[][] = new int[2][MAX_PLAYERS - 1];
	
	public static List<HashMap<String, String>> playerStats = new ArrayList<HashMap<String, String>>();
	public static Map<String, Integer> playerid = new HashMap<String, Integer>();
	public static boolean playeridUsed[] = new boolean[MAX_PLAYERS - 1];
	
	public static final int HIGH_LIMIT = 5;
	public static String consoleMessage = "";
	
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new DrugUseListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeaveListener(), this);
	}
	
	@Override
	public void onDisable()
	{
		return;
	}
	
	public static int numberOfStats()
	{
		int val = 0;
		FileHandler handler = new FileHandler();
		
		for(int i = 0; i < 1000; i++)
		{
			if(handler.keyValue(i) == null)
			{
				if(i != 0) val = i - 1;
				else return val;
				break;
			}
		}
		return val ;
	}
}
