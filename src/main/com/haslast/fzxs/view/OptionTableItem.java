package com.haslast.fzxs.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.eclipse.wb.swt.SWTResourceManager;

import com.haslast.fzxs.ui.DataTableComposite;
import com.haslast.fzxs.ui.Mango;
import com.mongodb.DB;

public class OptionTableItem extends OptionIems {
    private DB db;

    public OptionTableItem(String lable, ITreeView parent) {
        this.lable = lable;
        this.parent = parent;

        DataBasesView view = (DataBasesView) parent;
        db = view.getDb();
    }

    public Image getIcon() {

        return SWTResourceManager.getImage(Mango.class, "/icon/table.gif");
    }

    @Override
    public Control getControl(CTabFolder parent) {
        DataTableComposite composite = new DataTableComposite(parent, SWT.NONE);

        composite.setInput(db.getCollection(getLabel()));
        return composite;
    }

}
