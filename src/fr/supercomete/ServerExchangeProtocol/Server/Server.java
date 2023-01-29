package fr.supercomete.ServerExchangeProtocol.Server;

import java.util.ArrayList;

import fr.supercomete.ServerExchangeProtocol.Rank.Rank;

public class Server {
	private String servername;
	private int playercount=0;
	private boolean isOnline=false;
	private int material;
	private int slot;
	private String title;
	private Rank[] neededrank;
	private ArrayList<String> players = new ArrayList<String>();
	private ArrayList<ServerModifier> servermodifier= new ArrayList<ServerModifier>();
	private ArrayList<String> desc;
	public int getMaterial() {
		return material;
	}
	public void setMaterial(int material) {
		this.material = material;
	}
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public ArrayList<String> getPlayers(){
		return players;
		
	}
	public void setPlayers(ArrayList<String> string) {
		this.players= string;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Rank[] getNeededrank() {
		return neededrank;
	}
	public void setNeededrank(Rank[] neededrank) {
		this.neededrank = neededrank;
	}
	public Server(String servername,ArrayList<String>description,int mat,int slot,String title,Rank[]neededrank) {
		super();
		if(mat==-1){
			this.material=95;
		}
		desc=description;
		this.servername = servername;
		this.material=mat;
		this.slot=slot;
		this.title=title;
		this.neededrank=neededrank;
	}
	public String getServername() {
		return servername;
	}
	public void setServername(String servername) {
		this.servername = servername;
	}
	
	public int getPlayercount() {
		return playercount;
	}
	public void setPlayercount(int playercount) {
		this.playercount = playercount;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public ArrayList<ServerModifier> getServermodifier() {
		return servermodifier;
	}
	public void setServermodifier(ArrayList<ServerModifier> servermodifier) {
		this.servermodifier = servermodifier;
	}
	public boolean hasModifier(ServerModifier modifier) {
		return(this.servermodifier.contains(modifier));
	}
	public ArrayList<String> getDescription(){
		return desc;
	}
	public void setDescription(ArrayList<String>description){
		desc= description;
	}
}	
