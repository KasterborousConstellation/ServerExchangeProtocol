package fr.supercomete.ServerExchangeProtocol.Account;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.UUID;

public class Ban {
	private ArrayList<BanCause> causes = new ArrayList<>();
	private LocalDate date = (LocalDate.now(ZoneId.of("GMT+2")));
	private UUID owner;
	public ArrayList<BanCause> getCauses() {
		return causes;
	}
	public void setCauses(ArrayList<BanCause> causes) {
		this.causes = causes;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public UUID getOwner() {
		return owner;
	}
	public void setOwner(UUID owner) {
		this.owner = owner;
	}
	public Ban(UUID owner) {
		this.owner=owner;
	}
	public void add(BanCause cause) {
		this.causes.add(cause);
	}
	public void remove(BanCause cause) {
		this.causes.remove(cause);
	}
	public int getDuration(){
		int amount =0;
		for(BanCause cause : causes ) {
			if(cause.getType()==BanType.Add) {
				amount += cause.getTime();
			}else if(cause.getType()==BanType.Multi) {
				amount*=cause.getTime();
			}
		}
		return amount;
	}
}