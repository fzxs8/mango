package cn.zxczxc.view;

import java.util.List;

import org.eclipse.swt.graphics.Image;

public interface ITreeView {

    String getLabel();

    Image getIcon();

    void setChildren(List<ITreeView> children);

    List<ITreeView> getChildren();

    ITreeView getParent();

}