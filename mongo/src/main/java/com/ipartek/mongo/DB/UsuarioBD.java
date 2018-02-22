package com.ipartek.mongo.DB;

import org.bson.Document;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import com.ipartek.mongo.DB.Conexion;
import com.mongodb.client.MongoDatabase;

public class UsuarioBD extends Conexion{

	public void mostrarUsuarios() {
		abrirConexion();
		//MongoCursor<Document> collection = database.getCollection("usuarios");
		
		
				//
				// Gets a single document / object from this collection.
				//
				//DBObject document = collection.findOne();
				
				//MongoCursor<Document> docu = collection.find().iterator();
				

				//
				// Prints out the document.
				//
				//System.out.println(document);
		
		//cerrarConexion(client);
	}
	
	public void insertarUsuario() {
		abrirConexion();
		
		/*DBCollection collection = database.getCollection("usuarios");
		
		BasicDBObject document = new BasicDBObject();
		document.put("name", "Shubham");
		document.put("company", "Baeldung");
		collection.insert(document);*/
	}
	
}



