package fr.supercomete.ServerExchangeProtocol.Rank;

import org.bukkit.ChatColor;

public enum Rank {
	Joueur("Joueur", ChatColor.WHITE,"PAPER",0,"Simple Joueur"),
	Survivor("Guest",ChatColor.GREEN,"SUGAR_CANE",1,"Grade exclusif aux amis"),
	Host("Host",ChatColor.RED,"GOLDEN_APPLE",2,"Grade permettant de créer des hosts"),
	Admin("Admin",ChatColor.DARK_RED,"COMMAND",3,"Grade administrateur")
	;
	
	private String name;
	private ChatColor rankcolor;
	private String mat;
	private String desc;
	Rank(String name,ChatColor rankColor,String mat,int priority,String desc){
		this.name=name;
		this.mat=mat;
		this.rankcolor= rankColor;
		this.desc=desc;
	}
	public String getMaterial() {
		return mat;
	}
	public String getName() {
		return name;
	}
	public ChatColor getRankcolor() {
		return rankcolor;
	}
	public String getDescription() {
		return desc;
	}
}
