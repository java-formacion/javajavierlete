package com.ipartek.services;

import java.rmi.RemoteException;

import eu.dataaccess.footballpool.InfoSoapType;
import eu.dataaccess.footballpool.InfoSoapTypeProxy;
import eu.dataaccess.footballpool.TGameInfo;

public class PartidoService {
	
	InfoSoapType soap;
	
	
	public PartidoService() {
		
		soap = new InfoSoapTypeProxy();
	}
	
	

	public TGameInfo[] getPartidos() {
		
		try {
			 
			return soap.allGames();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}

	
	
	
}
