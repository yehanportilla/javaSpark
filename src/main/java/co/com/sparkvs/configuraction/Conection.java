package co.com.sparkvs.configuraction;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class Conection {
    /**
     * Metodo encargado de la conexion a la base de datos mongoDB
     */
    public Datastore conectionDB(){
        MongoClient client = new MongoClient("localhost",27017);
        Datastore datastore = new Morphia().createDatastore(client,"blog");
        return datastore;
    }
}
