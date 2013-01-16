package cn.zxczxc.provider;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import cn.zxczxc.view.ITreeView;

public class DBLabelProvider extends LabelProvider implements ILabelProvider {

    @Override
    public Image getImage(Object element) {
        ITreeView view = (ITreeView) element;
        return view.getIcon();
    }

    @Override
    public String getText(Object element) {
        ITreeView view = (ITreeView) element;
        return view.getLabel();
    }

}
