package com.haslast.fzxs.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;

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

    public void addTab(CTabFolder parent) {
        CTabItem tbtmBiao = new CTabItem(parent, SWT.CLOSE);
        tbtmBiao.setImage(this.getIcon());
        tbtmBiao.setText(this.getLabel());
        tbtmBiao.setControl(getControl(parent));
    }

    public abstract Control getControl(CTabFolder parent);

    public abstract Image getIcon();
}
