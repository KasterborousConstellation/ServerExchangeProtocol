package fr.supercomete.ServerExchangeProtocol.Rank;

public enum Rank {
	Joueur("Joueur","f","PAPER",0,"Simple Joueur"),
	Survivor("Guest","e","SUGAR_CANE",1,"Grade exclusif aux amis"),
	Host("Host","c","GOLDEN_APPLE",2,"Grade permettant de créer des hosts"),
	Admin("Admin","4","COMMAND",3,"Grade administrateur")
	;
	
	private String name;
	private String rankcolor;
	private String mat;
	private String desc;
	Rank(String name,String rankColor,String mat,int priority,String desc){
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
	public String getRankcolor() {
		return rankcolor;
	}
	public String getDescription() {
		return desc;
	}
}
