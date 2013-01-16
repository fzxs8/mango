package cn.zxczxc.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;

public abstract class OptionIems implements ITreeView {

    protected String lable;

    protected ITreeView parent;

    public String getLabel() {
        return lable;
    }

    public void setChildren(List<ITreeView> Children) {

    }

    public List<ITreeView> getChildren() {
        return new ArrayList<ITreeView>();
    }

    public ITreeView getParent() {
        return parent;
    }

    public abstract Image getIcon();
}
