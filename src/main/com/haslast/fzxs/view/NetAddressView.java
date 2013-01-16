package com.haslast.fzxs.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.SWTResourceManager;


import com.haslast.fzxs.ui.Mango;
import com.mongodb.Mongo;

public class NetAddressView implements ITreeView {
    
    

    private String name;

    private String host;

    // private List<String> dbs = new ArrayList<String>();

    private Mongo mongo;

    private ITreeView parent;

    private List<ITreeView> children = new ArrayList<ITreeView>();

    public String getHost() {
        return host;
    }

    private int port;

    public int getPort() {
        return port;
    }

    public NetAddressView(String name, int port) {
        this.name = name;
        this.host = name;
        this.port = port;
    }

    public String getLabel() {

        return name + ":" + port;
    }

    public void setChildren(List<ITreeView> children) {
        this.children = children;

    }

    public List<ITreeView> getChildren() {
        return children;
    }

    public Mongo getMongo() {
        return mongo;
    }

    public void setMongo(Mongo mongo) {
        this.mongo = mongo;
    }

    public ITreeView getParent() {
        return parent;
    }

    public Image getIcon() {
        return SWTResourceManager.getImage(Mango.class, "/icon/tree.gif");
    }

}
