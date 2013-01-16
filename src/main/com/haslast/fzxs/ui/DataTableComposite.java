package com.haslast.fzxs.ui;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.viewers.IStructuredContentProvider;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class DataTableComposite extends Composite {

    private static class ContentProvider implements IStructuredContentProvider {
        public Object[] getElements(Object inputElement) {
            DBCollection collection = (DBCollection) inputElement;
            System.out.println("33333---------------" + collection);
            DBCursor cursor = collection.find();
            Object[] res = new Object[cursor.size()];
            int c = 0;
            while (cursor.hasNext()) {
                DBObject obj = cursor.next();
                res[c++] = obj;
            }
            return res;
        }

        public void dispose() {
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }
    }

    private class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
        public Image getColumnImage(Object element, int columnIndex) {
            return null;
        }

        public String getColumnText(Object element, int columnIndex) {
            DBObject obj = (DBObject) element;
            System.out.println("11---------------" + element + "==" + columnIndex);
           // obj.
            return element.toString();
        }
    }

    private static class Sorter extends ViewerSorter {
        public int compare(Viewer viewer, Object e1, Object e2) {
            Object item1 = e1;
            Object item2 = e2;
            return 0;
        }
    }

    private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
    private Table table;
    private Composite composite;
    private TableViewer tableViewer;

    /**
     * Create the composite.
     * 
     * @param parent
     * @param style
     */
    public DataTableComposite(Composite parent, int style) {
        super(parent, style);
        addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                toolkit.dispose();
            }
        });
        toolkit.adapt(this);
        toolkit.paintBordersFor(this);
        setLayout(new BorderLayout(0, 0));

        composite = new Composite(this, SWT.BORDER);
        composite.setLayoutData(BorderLayout.CENTER);
        toolkit.adapt(composite);
        toolkit.paintBordersFor(composite);
        TableColumnLayout tcl_composite = new TableColumnLayout();
        composite.setLayout(tcl_composite);

        tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
        tableViewer.setSorter(new Sorter());
        tableViewer.setUseHashlookup(true);
        table = tableViewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        toolkit.paintBordersFor(table);

        TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
        tcl_composite.setColumnData(tblclmnNewColumn, new ColumnPixelData(150, true, true));
        tblclmnNewColumn.setText("New Column");

        TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
        tcl_composite.setColumnData(tblclmnNewColumn_1, new ColumnPixelData(150, true, true));
        tblclmnNewColumn_1.setText("New Column");
        tableViewer.setContentProvider(new ContentProvider());
        tableViewer.setLabelProvider(new TableLabelProvider());

    }

    public void setInput(Object input) {
        tableViewer.setInput(input);
        tableViewer.refresh();
    };

}
