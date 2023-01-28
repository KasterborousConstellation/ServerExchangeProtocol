package fr.supercomete.ServerExchangeProtocol.Account;
import java.util.UUID;
import org.bukkit.Bukkit;
import fr.supercomete.ServerExchangeProtocol.Rank.Rank;
import org.bukkit.ChatColor;

public class PlayerAccount {
	private UUID owner;
	private int level = 0;
	private int exp = 0;
	private Rank rank = Rank.Joueur;
	private ChatColor rankColor = ChatColor.WHITE;
	private String username;
	private int coins;
	private int host;
	private boolean chat=true;
	private int TimePlayed;
	private Rank[] unlockedRanks = {Rank.Joueur};
	public PlayerAccount(UUID owner, int level, int exp,int coins, int host,Rank rank, ChatColor rankColor,int timePlayed,Rank[] unlockedranks,String Username) {
		this.owner = owner;this.unlockedRanks = unlockedranks;	this.level = level;
		this.exp = exp;this.rank = rank;this.rankColor = rankColor;
		this.TimePlayed = timePlayed;this.coins=coins;this.host = host;
		this.username=Username;
	}
	public void addRank(Rank rank) {
		Rank[] newranks= new Rank[unlockedRanks.length+1];
		for(int i = 0; i < unlockedRanks.length;i++) {
			newranks[i] = unlockedRanks[i];
		}
		newranks[unlockedRanks.length] = rank;
		this.unlockedRanks = newranks;
	}
	public boolean hasRank(Rank Rank) {
		for(Rank rank : unlockedRanks) {
			if(Rank.equals(rank))return true;
		}
		return false;
	}
	public int getHost() {
		return host;
	}
	public void setHost(int host) {
		this.host = host;
	}
	public Rank[] getUnlockedRanks() {
		return unlockedRanks;
	}
	public void setUnlockedRanks(Rank[] unlockedRanks) {
		this.unlockedRanks = unlockedRanks;
	}
	public PlayerAccount(UUID owner) {
		this.owner = owner;
		this.username=Bukkit.getPlayer(owner).getName();
	}

	public UUID getOwner() {
		return owner;
	}

	public void setOwner(UUID owner) {
		this.owner = owner;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public int getTimePlayed() {
		return TimePlayed;
	}

	public void setTimePlayed(int timePlayed) {
		TimePlayed = timePlayed;
	}

	public ChatColor getRankColor() {
		return rankColor;
	}

	public void setRankColor(ChatColor rankColor) {
		this.rankColor = rankColor;
	}
	public int getCoins() {
		return coins;
	}
	public void setCoins(int coins) {
		this.coins = coins;
	}
	public String getUser() {
		return this.username;
	}
	/**
	 * @return the chat
	 */
	public boolean isChat() {
		return chat;
	}
	/**
	 * @param chat the chat to set
	 */
	public void setChat(boolean chat) {
		this.chat = chat;
	}
}