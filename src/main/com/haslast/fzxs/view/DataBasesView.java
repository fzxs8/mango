package com.haslast.fzxs.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.SWTResourceManager;

import com.haslast.fzxs.ui.Mango;
import com.mongodb.DB;

public class DataBasesView implements ITreeView {

    private String lable;
    private ITreeView parent;
    private DB db;

    public DataBasesView(String lable, ITreeView parent) {
        this.parent = parent;
        this.lable = lable;
        this.db = ((NetAddressView) parent).getMongo().getDB(lable);

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
        children.add(new DataTableView("表", this));
        children.add(new OptionIndexItem("索引", this));
        children.add(new OptionRoleItem("角色", this));
        children.add(new OptionPropertyItem("属性", this));
        return children;
    }

    public ITreeView getParent() {
        return parent;
    }

    public DB getDb() {
        return db;
    }

}
