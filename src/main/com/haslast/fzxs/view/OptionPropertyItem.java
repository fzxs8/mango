package com.haslast.fzxs.view;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.eclipse.wb.swt.SWTResourceManager;

import com.haslast.fzxs.ui.Mango;


public class OptionPropertyItem extends OptionIems {

    public OptionPropertyItem(String lable, ITreeView parent) {
        this.lable = lable;
        this.parent = parent;
    }

    public Image getIcon() {
        return SWTResourceManager.getImage(Mango.class, "/icon/cms-ico1.gif");
    }

    @Override
    public Control getControl(CTabFolder parent) {
        // TODO Auto-generated method stub
        return null;
    }

}
