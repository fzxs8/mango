package com.haslast.fzxs.provider;

import java.util.ArrayList;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.haslast.fzxs.view.ITreeView;
import com.haslast.fzxs.view.NetAddressView;


public class DBContentProvider implements IStructuredContentProvider, ITreeContentProvider {

    public void dispose() {
        // TODO Auto-generated method stub

    }

    public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
        System.out.println("55555" + arg0);

    }

    public Object[] getChildren(Object arg0) {
        ITreeView view = (ITreeView) arg0;
        return view.getChildren().toArray();
    }

    public Object getParent(Object arg0) {
        ITreeView view = (ITreeView) arg0;
        return view.getParent();
    }

    public boolean hasChildren(Object arg0) {
        ITreeView view = (ITreeView) arg0;
        return !view.getChildren().isEmpty();
    }

    public Object[] getElements(Object arg0) {
        ArrayList<NetAddressView> list = (ArrayList<NetAddressView>) arg0;
        return list.toArray();
    }

}
