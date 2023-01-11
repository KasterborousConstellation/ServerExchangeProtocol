package fr.supercomete.ServerExchangeProtocol.Server;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import fr.supercomete.ServerExchangeProtocol.Rank.Rank;

public class ServerManager {
	public static ArrayList<Server> ServerList = new ArrayList<Server>();
	public static Server getRandomHub() {
		ArrayList<Server> hublist= new ArrayList<Server>();
		for(Server s : ServerList) {
			if(s.getServermodifier().contains(ServerModifier.Hub))hublist.add(s);
		}
		return hublist.get(new Random().nextInt(hublist.size()));
	}
	public static void sendPluginMessage(String sub, Player player, String[] args,Plugin plugin) {
		final ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF(sub);
		for (String arg : args) {
			out.writeUTF(arg);
		}
		if (player == null) {
			player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
		}
		player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
	}
	
	public static void updatePlayerCount(String upserver, int playercount) {
		for (Server server : ServerList) {
			if (server.getServername().equalsIgnoreCase(upserver)) {
				server.setPlayercount(playercount);
			}
		}
	}
	public static ArrayList<Server> getServerListByModifier(ServerModifier modifier){
		ArrayList<Server> server =new  ArrayList<Server>();
		for(Server s:ServerList)if(s.hasModifier(modifier)&&s.isOnline())server.add(s);
		return server;
	}
	public static Server getCurrentPluginServer() {
		File file = new File("");
		String built="";
		String path = file.getAbsolutePath();
		char choose =' ';
		int i =0;
		while(choose !='/' && choose !=005) {
			choose=path.charAt(path.length()-1-i);
			built=choose+built;
			i++;
		}
		built =built.subSequence(1, built.length()).toString();
		return getServer(built);
	}
	public static boolean isContainingServer(String ServerName) {
		for (Server server: ServerList) {
			if (ServerName.equalsIgnoreCase(server.getServername())) {
				return true;
			}
		}
		return false;
	}
	public static Server getServer(String servername) {
		for (Server server: ServerList) {
			if (servername.equalsIgnoreCase(server.getServername())) {
				return server;
			}
		}
		return null;
	}
	public static ArrayList<Rank> getServerRankRequierement(String servername) {
		ArrayList<Rank> ranks = new ArrayList<Rank>();
		for(Server s : ServerManager.ServerList) {
			if(s.getServername().equalsIgnoreCase(servername)) {
				ranks.addAll(Arrays.asList(s.getNeededrank()));
			}
		}
		return ranks;
	}
}