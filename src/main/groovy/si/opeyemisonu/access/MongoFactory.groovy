package si.opeyemisonu.access

import com.mongodb.DB
import com.mongodb.MongoClient

class MongoFactory {
    private static MongoClient mongoClient
    
    public static MongoClient getClient() {
        return getMongoClient("localhost", 27017);
    }

    public static MongoClient getClient(String host, int port) {
        if(mongoClient == null) {
            mongoClient = new MongoClient(host, port)
        }
        
        return mongoClient
    }
    
    public static DB getDB(String host, int port, String dbName) {
        getClient(host, port).getDB(dbName)
    }
}
