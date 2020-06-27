package MinecraftDrugs;

import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class DrugUseListener implements Listener
{	
	public final Plugin plugin = DrugsInit.getProvidingPlugin(DrugsInit.class);
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event)
	{	
		Player player = event.getPlayer();
		String playerName = player.getName();
		
		ConsoleCommandSender console = plugin.getServer().getConsoleSender();
		
		ItemStack item = player.getInventory().getItemInMainHand();
		if(event.getAction().equals(Action.RIGHT_CLICK_AIR) && item.getType() == Material.BROWN_MUSHROOM)
		{
			applyDrug(player, 0, item);
			DrugsInit.highLevel[0][DrugsInit.playerid.get(playerName)]++;
			PotionEffect effectOne = new PotionEffect(PotionEffectType.CONFUSION, (60 * 20), 1, false, false);
			effectOne.apply(player);
			item.setAmount(item.getAmount() - 1);
			
			console.sendMessage("[Drugs]: " + playerName + "took mushrooms.");
			player.getServer().broadcastMessage("* " + playerName + " eats a mushroom.");
			return;
		}
		else item = player.getInventory().getItemInOffHand();
		if(event.getAction().equals(Action.LEFT_CLICK_AIR) && item.getType() == Material.BROWN_MUSHROOM)
		{
			DrugsInit.highLevel[0][DrugsInit.playerid.get(playerName)]++;
			PotionEffect effectOne = new PotionEffect(PotionEffectType.CONFUSION, (30 * 20) * DrugsInit.highLevel[0][DrugsInit.playerid.get(playerName)], 1, false, false);
			effectOne.apply(player);
			item.setAmount(item.getAmount() - 1);
			
			console.sendMessage("[Drugs]: " + playerName + "took mushrooms.");
			player.getServer().broadcastMessage("* " + playerName + " eats a mushroom.");
			return;
		}
		
		else item = player.getInventory().getItemInMainHand();
		if(event.getAction().equals(Action.RIGHT_CLICK_AIR) && item.getType() == Material.SUGAR)
		{
			DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)]++;
			PotionEffect effectOne = new PotionEffect(PotionEffectType.SPEED, (60 * 20) * DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)], 1 * DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)], false, false);
			PotionEffect effectTwo = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, (15 * 20) * (DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)] / 2), 1, false, false);
			PotionEffect effectThree = new PotionEffect(PotionEffectType.FAST_DIGGING, (75 * 20) * DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)], 1 * DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)], false, false);
			
			if(DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)] != 0)
			{
				
			}
			
			effectOne.apply(player);
			effectTwo.apply(player);
			effectThree.apply(player);
			item.setAmount(item.getAmount() - 1);
			
			console.sendMessage("[Drugs]: " + playerName + " took cocaine.");
			player.getServer().broadcastMessage("* " + playerName + " takes a bump of coke.");
			
			new BukkitRunnable()
			{
				public void run()
				{
					DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)]--;
					console.sendMessage("[Drugs]: " + playerName + "'s cocaine wore off.");
					this.cancel();
				}
			}.runTaskTimer(plugin, 0, (75 * 20) * DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)]);
			
			if(DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)] > DrugsInit.HIGH_LIMIT) 
			{
					player.setHealth(0.0);
					DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)] = 0;
					player.getServer().broadcastMessage(player.getName() + " has died from a cocaine overdose.");
			}
			return;
		}
		else item = player.getInventory().getItemInOffHand();
		if(event.getAction().equals(Action.LEFT_CLICK_AIR) && item.getType() == Material.SUGAR)
		{
			DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)]++;
			PotionEffect effectOne = new PotionEffect(PotionEffectType.SPEED, (60 * 20) * DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)], 1 * DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)], false, false);
			PotionEffect effectTwo = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, (15 * 20) * (DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)] / 2), 1, false, false);
			PotionEffect effectThree = new PotionEffect(PotionEffectType.FAST_DIGGING, (75 * 20) * DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)], 1 * DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)], false, false);
			effectOne.apply(player);
			effectTwo.apply(player);
			effectThree.apply(player);
			item.setAmount(item.getAmount() - 1);
			
			console.sendMessage("[Drugs]: " + playerName + "took cocaine.");
			player.getServer().broadcastMessage("* " + playerName + " takes a bump of coke.");
			
			new BukkitRunnable()
			{
				public void run()
				{
					DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)]--;
					console.sendMessage("[Drugs]: " + playerName + "cocaine wore off.");
				}
			}.runTaskTimer(plugin, 0, (75 * 20) * DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)]);
			
			if(DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)] > DrugsInit.HIGH_LIMIT) 
			{
					player.setHealth(0.0);
					DrugsInit.highLevel[1][DrugsInit.playerid.get(playerName)] = 0;
					player.getServer().broadcastMessage(player.getName() + " has died from a cocaine overdose.");
			}
			return;
		}
		return;
	}
	
	public int prevIterations = 0;
	
	public void applyDrug(Player player, int drugID, ItemStack item)
	{
		final int seconds = 20;
		int time[] = new int[2];
		int duration = 0;
		
		PotionEffect effectOne = new PotionEffect(PotionEffectType.CONFUSION, seconds * 200, 1, false, false);
		
		DrugsInit.highLevel[drugID][DrugsInit.playerid.get(player.getName())]++;
		if(DrugsInit.highLevel[drugID][DrugsInit.playerid.get(player.getName())] == 0)
		{
			if(drugID == 0) time[drugID] = 20;
			else time[drugID] = 45;
		}
		else 
		{
			if(drugID == 0) time[drugID] = player.getPotionEffect(PotionEffectType.CONFUSION).getDuration() + (seconds * 20);
		}
		
		new BukkitRunnable()
		{
			int staticDrugID = drugID;
			int iterations = 0;
			public void run()
			{
				if(prevIterations != 0)
				{
					if((iterations < prevIterations) && drugID == staticDrugID) this.cancel();
				}
				prevIterations = iterations;
				iterations++;
				
				DrugsInit.highLevel[staticDrugID][DrugsInit.playerid.get(player.getName())]--;
				if(DrugsInit.highLevel[staticDrugID][DrugsInit.playerid.get(player.getName())] == 0)
				{
					if(staticDrugID == 0)
					{
						player.removePotionEffect(PotionEffectType.CONFUSION);
						effectOne.apply(player);
					}
					this.cancel();
				}
			}
		}.runTaskTimer(plugin, 0, ((time[drugID] * DrugsInit.highLevel[drugID][DrugsInit.playerid.get(player.getName())]) * seconds));
		
		effectOne.apply(player);
		item.setAmount(item.getAmount() - 1);
		
	}
}
