package cn.zxczxc.view;

import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.SWTResourceManager;

import cn.zxczxc.ui.Mango;

public class OptionPropertyItem extends OptionIems {

    public OptionPropertyItem(String lable, ITreeView parent) {
        this.lable = lable;
        this.parent = parent;
    }

    public Image getIcon() {
        return SWTResourceManager.getImage(Mango.class, "/icon/cms-ico1.gif");
    }

}
