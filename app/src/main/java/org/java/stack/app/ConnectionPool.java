package org.java.stack.app;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	
	private static ConnectionPool _instance = null;
	
	private ConnectionPool() {}
	
	class Connection {
		
		public boolean isBusy;
		public void closeConnection() {
			isBusy = !isBusy;
		}
		
	}
	private List<Connection> allConnections = new ArrayList<Connection>();
	private List<Connection> freeConnection = new ArrayList<Connection>();
	
	
	public ConnectionPool getInstance() {
		if(_instance == null) {
			synchronized(ConnectionPool.class) {
				if(_instance == null) {
					_instance =  new ConnectionPool();
				}
			}
		}
		return _instance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
