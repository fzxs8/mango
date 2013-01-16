package com.haslast.fzxs.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.SWTResourceManager;

import com.haslast.fzxs.ui.Mango;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class DataTableView implements ITreeView {

    private String lable;
    private ITreeView parent;

    // private DBCollection collection;

    public DataTableView(String lable, ITreeView parent) {
        this.parent = parent;
        this.lable = lable;
    }

    public String getLabel() {
        return lable;
    }

    public Image getIcon() {
        return SWTResourceManager.getImage(Mango.class, "/icon/onebit_14.png");
    }

    public void setChildren(List<ITreeView> children) {
        // TODO Auto-generated method stub

    }

    public List<ITreeView> getChildren() {
        List<ITreeView> children = new ArrayList<ITreeView>();
        DataBasesView view = (DataBasesView) parent;
        DB db = view.getDb();
        Set<String> colls = db.getCollectionNames();
        for (String coll : colls) {
            OptionTableItem item = new OptionTableItem(coll, parent);
            // item.setDb(db);
            children.add(item);
        }
        return children;
    }

    public ITreeView getParent() {
        return parent;
    }

    // public DBCollection getCollection() {
    // return collection;
    // }

}
