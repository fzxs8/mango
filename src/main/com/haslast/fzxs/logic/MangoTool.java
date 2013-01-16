package com.haslast.fzxs.logic;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.haslast.fzxs.view.ITreeView;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;

public class MangoTool {
    private Mongo mongo;

    public Mongo getMongo() {
        return mongo;
    }

    public MangoTool(String host, int port) throws UnknownHostException, MongoException {
        System.out.println(host + "----" + port);
        mongo = new Mongo(new ServerAddress(host, port));
    }

    public List<String> getDatabaseNames() {
        return mongo.getDatabaseNames();
    }

    public Set<String> getCollectionNames(String name) {
        DB db = mongo.getDB(name);

        Set<String> set = db.getCollectionNames();
        return set;

    }

    public static void main(String[] args) {
        try {
            Mongo mongo = new Mongo();
            List<String> list = mongo.getDatabaseNames();

            List<ITreeView> idbViews = new ArrayList<ITreeView>();

            for (String st : list) {
                // DataBasesView db = new DataBasesView();
                // db.setDbName(st);
                // db.setCollectionNames(db.getCollectionNames());
                // db.setDbs(dbs)
            }

            System.out.println(list);

            DB db = mongo.getDB("test");

            Set<String> set = db.getCollectionNames();

            System.out.println(set);

            DBCollection collection = db.getCollection("t1");
            DBCursor cursor = collection.find();
            while (cursor.hasNext()) {
                DBObject obj = cursor.next();
                System.out.println(obj);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
