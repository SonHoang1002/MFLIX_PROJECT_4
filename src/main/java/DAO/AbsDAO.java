package DAO;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public abstract class AbsDAO {
    static MongoDatabase md;
    MongoDatabase getMd(){
        if(md == null){
            ConnectionString connectionString = new ConnectionString("mongodb+srv://root:root@cluster0.lh5rj.mongodb.net/sample_mflix?retryWrites=true&w=majority");
            MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
            MongoClient mongoClient = MongoClients.create(settings);
            md= mongoClient.getDatabase("sample_mflix");
            System.out.println("Connecting to DB");


        }
        return md;
    }
}
