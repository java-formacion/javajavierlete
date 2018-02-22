package com.ipartek.mongo.DB;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class Conexion {
	MongoDatabase abrirConexion() {
		MongoClient client = new MongoClient(
		        new ServerAddress("localhost", 27017));

		//
		// Conectar a la base de datos mongo
		//
		MongoDatabase mongo = client.getDatabase("mongo");
		return mongo;
	}
	


	void cerrarConexion(MongoClient client) {
		if(client!=null) {
			client.close();
		}
	}
}
