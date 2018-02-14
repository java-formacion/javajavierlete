package com.ipartek.formacion.controler;

import java.rmi.RemoteException;
import java.util.ArrayList;

import eu.dataaccess.footballpool.InfoSoapType;
import eu.dataaccess.footballpool.InfoSoapTypeProxy;
import eu.dataaccess.footballpool.TGameInfo;

public class PartidoService {
	InfoSoapType footballPool;
	
	public PartidoService() {
		footballPool = new InfoSoapTypeProxy();
	}
	/*private static ArrayList<TGameInfo> arrayPartidos= new ArrayList<TGameInfo>();
	
	

	public static ArrayList<TGameInfo> obtenerArraydePartidos(InfoSoapType soap) throws RemoteException {
		TGameInfo[] resultados = soap.allGames();
		for(TGameInfo r: resultados) {
			arrayPartidos.add(r);
		}
		
		return arrayPartidos;
	}*/
	
	public TGameInfo[] getPartidos() {
		
		try {
			return footballPool.allGames();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
}
