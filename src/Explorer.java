import java.io.File;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class Explorer extends ApplicationWindow {
    public Explorer() {
        super(null);
        this.addMenuBar();
    }

    // protected void addMenuBar(){}

    protected Control createContents(Composite parent) {
        SashForm sash_form = new SashForm(parent, SWT.HORIZONTAL | SWT.NULL);
        // sash_form.setSize(100,200);
        TreeViewer tv = new TreeViewer(sash_form);

        // tv.setContentProvider(new FileTreeContentProvider());
        // tv.setLabelProvider(new FileTreeLabelProvider());
        // tv.setInput(new File("D:\\"));
        SashForm sf = new SashForm(sash_form, SWT.VERTICAL | SWT.NULL);
        // sash_form.setSize(300,200);
        final TableViewer tbv = new TableViewer(sf, SWT.BORDER);
        // tbv.setContentProvider(new FileTableContentProvider());
        // tv.addSelectionChangedListener(new ISelectionChangedListener() {
        // public void selectionChanged(SelectionChangedEvent event) {
        // IStructuredSelection selection = (IStructuredSelection)
        // event.getSelection();
        // Object selected_file = selection.getFirstElement();
        // tbv.setInput(selected_file);
        // }
        // });

        Button b = new Button(sf, SWT.PUSH);
        b.setText("Hello World");

        return sash_form;
    }

    protected MenuManager createMenuManager() {
        MenuManager bar_menu = new MenuManager("");

        MenuManager file_menu = new MenuManager("&File");
        MenuManager edit_menu = new MenuManager("&Edit");
        MenuManager view_menu = new MenuManager("&View");

        bar_menu.add(file_menu);
        bar_menu.add(edit_menu);
        bar_menu.add(view_menu);

        // file_menu.add(new ExitAction(this));
        // file_menu.add(new ExitAction(this));
        // edit_menu.add("&Usdafndo");

        return bar_menu;
    }

    public static void main(String[] args) {
        Explorer w = new Explorer();
        w.setBlockOnOpen(true);
        w.open();
        Display.getCurrent().dispose();
        // Shell shell = new Shell(Display);
    }
}