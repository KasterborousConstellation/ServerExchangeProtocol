package fr.supercomete.ServerExchangeProtocol.File;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.supercomete.ServerExchangeProtocol.Account.Fileutils;
import fr.supercomete.ServerExchangeProtocol.Account.PlayerAccount;
public class PlayerAccountManager {
	private static  ProfileSerializationManager profileSerializationManager= new ProfileSerializationManager();
	private static File saveDir=new File("/var/games/minecraft/PlayerAccounts/");
	
	public static void testfor(Player player){
		if(player==null)return;
		final File file = new File(saveDir,player.getUniqueId()+".json");
		if(file.exists())return;
		try{
			Fileutils.createFile(file);
		}catch(IOException e){
			e.printStackTrace();
		}
		final PlayerAccount profile = new PlayerAccount(player.getUniqueId());
		final String json = profileSerializationManager.serialize(profile);
		Fileutils.save(file, json);
	}
	public static PlayerAccount getPlayerAccount(Player player) {
		final File file = new File(saveDir,player.getUniqueId()+".json");
		testfor(player);
		String json = Fileutils.loadContent(file);
		final PlayerAccount profile = profileSerializationManager.deserialize(json);
		profile.setUsername(player.getName());
		return profile;
	}
	public static PlayerAccount getPlayerAccount(String player) {
		testfor(Bukkit.getPlayer(player));
		for(File file:saveDir.listFiles()) {
			String json = Fileutils.loadContent(file);
			final PlayerAccount profile = profileSerializationManager.deserialize(json);
			if(profile.getUser().equals(player)) {
				return profile;
			}
		}
		return null;
	}
	public static PlayerAccount getPlayerAccount(UUID uuid) {
		testfor(Bukkit.getPlayer(uuid));
		for(File file:saveDir.listFiles()) {
			String json = Fileutils.loadContent(file);
			final PlayerAccount profile = profileSerializationManager.deserialize(json);
			if(profile.getOwner().equals(uuid)) {
				return profile;
			}
		}
		return null;
	}
	public static void setPlayerAccount(Player player,PlayerAccount account) {
		final File file = new File(saveDir,player.getUniqueId()+".json");
		testfor(player);
		String json = profileSerializationManager.serialize(account);
		Fileutils.save(file, json);
	}
}