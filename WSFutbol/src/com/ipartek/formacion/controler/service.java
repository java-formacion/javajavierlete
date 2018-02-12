package com.ipartek.formacion.controler;

import java.rmi.RemoteException;
import java.util.ArrayList;

import eu.dataaccess.footballpool.InfoSoapType;
import eu.dataaccess.footballpool.TGameInfo;

public class service {
	
	private static ArrayList<TGameInfo> arrayPartidos= new ArrayList<TGameInfo>();
	
	

	public static ArrayList<TGameInfo> obtenerArraydePartidos(InfoSoapType soap) throws RemoteException {
		TGameInfo[] resultados = soap.allGames();
		for(TGameInfo r: resultados) {
			arrayPartidos.add(r);
		}
		
		return arrayPartidos;
	}
}
