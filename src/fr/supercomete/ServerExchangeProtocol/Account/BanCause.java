package fr.supercomete.ServerExchangeProtocol.Account;

public enum BanCause {
	Xray(15,BanType.Add,"GOLD_ORE"),
	Devo(4,BanType.Add,"PAPER"),
	Alt(2,BanType.Multi,"COMMAND"),
	;
	private int time;
	private BanType type;
	private String material;
	BanCause(int time, BanType type,String Material) {
		this.time =time;
		this.type=type;
		this.material=Material;
	}
	public int getTime() {
		return time;
	}
	public BanType getType() {
		return type;
	}
	public String getMaterial() {
		return material;
	}
}
