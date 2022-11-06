package fr.supercomete.ServerExchangeProtocol.Server;

import java.util.ArrayList;

public class ServerWrapper {
	private ArrayList<Server> serverlist;
	public ServerWrapper(ArrayList<Server> server) {
		this.serverlist=server;	
	}
	public ArrayList<Server> extract(){
		return serverlist;
	}
}
