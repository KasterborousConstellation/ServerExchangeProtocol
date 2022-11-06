package fr.supercomete.ServerExchangeProtocol.File;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.supercomete.ServerExchangeProtocol.Account.PlayerAccount;
import fr.supercomete.ServerExchangeProtocol.Server.Server;
import fr.supercomete.ServerExchangeProtocol.Server.ServerWrapper;
public class ProfileSerializationManager {
	private Gson gson;
	public ProfileSerializationManager() {
		this.gson=createGsonInstance();
	}
	private Gson createGsonInstance() {
		return new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.disableHtmlEscaping()
				
				.create();
	}
	public String serialize(PlayerAccount profile) {
		return this.gson.toJson(profile);
	}	
	public PlayerAccount deserialize(String json){
		return this.gson.fromJson(json, PlayerAccount.class);
	}
	public String ServerSerizalize(Server server) {
		return this.gson.toJson(server);
	}
	public Server ServerDeserizalize(String json) {
		return this.gson.fromJson(json, Server.class);
	}
	public String ServerWrapperSerizalize(ServerWrapper server) {
		return this.gson.toJson(server);
	}
	public ServerWrapper ServerWrapperDeserizalize(String json) {
		return this.gson.fromJson(json, ServerWrapper.class);
	}	
}