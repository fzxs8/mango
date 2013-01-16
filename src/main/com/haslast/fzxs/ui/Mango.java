package com.haslast.fzxs.ui;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

import swing2swt.layout.BorderLayout;
import swing2swt.layout.FlowLayout;

import com.haslast.fzxs.logic.MangoTool;
import com.haslast.fzxs.provider.DBContentProvider;
import com.haslast.fzxs.provider.DBLabelProvider;
import com.haslast.fzxs.view.DataBasesView;
import com.haslast.fzxs.view.DataTableView;
import com.haslast.fzxs.view.ITreeView;
import com.haslast.fzxs.view.NetAddressView;
import com.haslast.fzxs.view.OptionIems;
import com.mongodb.MongoException;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class Mango extends ApplicationWindow {
    private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
    private Action action;
    private Action action_1;
    private Action action_2;
    private Action action_3;
    private Action action_4;
    private Action action_5;
    private Action action_6;
    private Action action_7;
    private Action action_8;
    private Action action_9;
    private Action action_10;
    private Action action_11;
    private Action action_12;
    private Action action_13;
    private Action action_14;
    private Composite composite;
    private Text text;
    private Text text_1;
    private Table table;
    private CTabFolder mainTabFolder;

    /**
     * Create the application window.
     */
    public Mango() {
        super(null);
        setBlockOnOpen(true);
        // setShellStyle(SWT.SHELL_TRIM | SWT.APPLICATION_MODAL);
        createActions();
        addToolBar(SWT.FLAT | SWT.WRAP);
        addMenuBar();
        addStatusLine();

    }

    private void createActions() {
        {
            action = new Action("New Action") {
            };
        }
        {
            action_1 = new Action("New Action") {
            };
        }
        {
            action_2 = new Action("退出") {

            };
        }
        {
            action_3 = new Action("新建") {
            };
        }
        {
            action_4 = new Action("导出") {
            };
        }
        {
            action_5 = new Action("导入") {
            };
        }
        {
            action_6 = new Action("语言") {
            };
        }
        {
            action_7 = new Action("设置") {
            };
        }
        {
            action_8 = new Action("性能") {
            };
        }
        {
            action_9 = new Action("关于") {
            };
        }
        {
            action_10 = new Action("检查更新") {
            };
        }
        {
            action_11 = new Action("新建") {
            };

            action_11.setImageDescriptor(ResourceManager.getImageDescriptor(Mango.class, "/icon/new.png"));

            action_11.setToolTipText("新建");
        }
        {
            action_12 = new Action("New Action") {
            };
            action_12.setImageDescriptor(ResourceManager.getImageDescriptor(Mango.class, "/icon/onebit_12.png"));
        }
        {
            action_13 = new Action("New Action") {
            };
            action_13.setImageDescriptor(ResourceManager.getImageDescriptor(Mango.class, "/icon/onebit_14.png"));
        }
        {
            action_14 = new Action("New Action") {
                int index = 1;

                @Override
                public void run() {
                    StackLayout layout = (StackLayout) composite.getLayout();
                    Control[] controls = composite.getChildren();
                    System.out.println(index);
                    layout.topControl = controls[index++ % 3];
                    composite.layout();

                }
            };
            action_14.setImageDescriptor(ResourceManager.getImageDescriptor(Mango.class, "/icon/onebit_15.png"));

        }
    }

    /**
     * Create contents of the application window.
     * 
     * @param parent
     */
    @Override
    protected Control createContents(Composite parent) {
        parent.setTouchEnabled(true);
        parent.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new BorderLayout(0, 0));
        {
            SashForm sashForm = new SashForm(container, SWT.NONE);
            // fd_sashForm.bottom = new FormAttachment(0, 535);
            // fd_sashForm.right = new FormAttachment(0, 1000);
            // sashForm.setLayoutData(fd_sashForm);
            // formToolkit.adapt(sashForm);
            // formToolkit.paintBordersFor(sashForm);
            {
                Composite composite_1 = new Composite(sashForm, SWT.BORDER);
                composite_1.setTouchEnabled(true);
                formToolkit.adapt(composite_1);
                formToolkit.paintBordersFor(composite_1);
                composite_1.setLayout(new BorderLayout(0, 0));
                {
                    Tree tree;
                    final TreeViewer treeViewer = new TreeViewer(composite_1, SWT.BORDER | SWT.H_SCROLL);
                    treeViewer.addDoubleClickListener(new IDoubleClickListener() {
                        public void doubleClick(DoubleClickEvent event) {
                            TreeSelection selection = (TreeSelection) event.getSelection();

                            Object obj = selection.getFirstElement();

                            if (obj instanceof NetAddressView) {

                                NetAddressView address = (NetAddressView) obj;

                                System.out.println(address.getLabel());
                                try {
                                    MangoTool tool = new MangoTool(address.getHost(), address.getPort());

                                    address.setMongo(tool.getMongo());
                                    List<ITreeView> children = new ArrayList<ITreeView>();
                                    List<String> dbs = tool.getDatabaseNames();
                                    for (String db : dbs) {
                                        children.add(new DataBasesView(db, address));
                                    }
                                    address.setChildren(children);
                                    event.getViewer().refresh();
                                } catch (UnknownHostException e) {
                                    e.printStackTrace();
                                } catch (MongoException e) {
                                    e.printStackTrace();
                                }
                            } else if (obj instanceof DataTableView) {
                                // DataTableView tables = (DataTableView) obj;
                                // event.getViewer().refresh();

                            } else if (obj instanceof OptionIems) {
                                OptionIems opt = (OptionIems) obj;
                                // mainTabFolder
                                opt.addTab(mainTabFolder);

                            }
                        }
                    });
                    tree = treeViewer.getTree();
                    tree.setLinesVisible(true);
                    tree.setHeaderVisible(true);

                    treeViewer.setLabelProvider(new DBLabelProvider());
                    treeViewer.setContentProvider(new DBContentProvider());
                    List<NetAddressView> list = new ArrayList<NetAddressView>();

                    NetAddressView add1 = new NetAddressView("127.0.0.1", 27017);
                    // List<IDBView> children = new ArrayList<IDBView>();
                    // children.add(new OptionsView("表"));
                    // children.add(new OptionsView("索引"));
                    // children.add(new OptionsView("角色"));
                    // children.add(new OptionsView("属性"));
                    // add1.setChildren(children);
                    list.add(add1);
                    NetAddressView add2 = new NetAddressView("localhost", 27017);
                    // add2.setChildren(children);
                    list.add(add2);
                    treeViewer.setInput(list);
                    formToolkit.adapt(tree);
                    formToolkit.paintBordersFor(tree);
                }
            }

            composite = formToolkit.createComposite(sashForm, SWT.NONE);
            formToolkit.paintBordersFor(composite);
            StackLayout sl_composite = new StackLayout();

            composite.setLayout(sl_composite);
            {
                SashForm sashForm_1_1 = new SashForm(composite, SWT.NONE);
                formToolkit.adapt(sashForm_1_1);
                formToolkit.paintBordersFor(sashForm_1_1);
                sl_composite.topControl = sashForm_1_1;

                Composite composite_2 = new Composite(sashForm_1_1, SWT.NONE);
                formToolkit.adapt(composite_2);
                formToolkit.paintBordersFor(composite_2);
                composite_2.setLayout(new BorderLayout(0, 0));

                Composite composite_3 = new Composite(composite_2, SWT.NONE);
                composite_3.setLayoutData(BorderLayout.NORTH);
                formToolkit.adapt(composite_3);
                formToolkit.paintBordersFor(composite_3);
                composite_3.setLayout(new FillLayout(SWT.HORIZONTAL));

                ToolBar toolBar = new ToolBar(composite_3, SWT.FLAT | SWT.RIGHT);
                formToolkit.adapt(toolBar);
                formToolkit.paintBordersFor(toolBar);

                ToolItem toolItem = new ToolItem(toolBar, SWT.NONE);
                toolItem.setImage(SWTResourceManager.getImage(Mango.class, "/icon/add.png"));
                toolItem.setText("增加");

                ToolItem tltmNewItem_1 = new ToolItem(toolBar, SWT.NONE);
                tltmNewItem_1.setImage(SWTResourceManager.getImage(Mango.class, "/icon/delete.gif"));
                tltmNewItem_1.setText("删除");

                ToolItem tltmNewItem = new ToolItem(toolBar, SWT.NONE);
                tltmNewItem.setImage(SWTResourceManager.getImage(Mango.class, "/icon/pencil.png"));
                tltmNewItem.setText("修改");

                ToolItem tltmAaa = new ToolItem(toolBar, SWT.NONE);
                tltmAaa.setImage(SWTResourceManager.getImage(Mango.class, "/icon/refresh.gif"));
                tltmAaa.setText("刷新");

                Composite composite_4 = new Composite(composite_2, SWT.NONE);
                composite_4.setLayoutData(BorderLayout.CENTER);
                formToolkit.adapt(composite_4);
                formToolkit.paintBordersFor(composite_4);
                composite_4.setLayout(new BorderLayout(0, 0));
                {
                    SashForm sashForm_2 = new SashForm(composite_4, SWT.VERTICAL);
                    formToolkit.adapt(sashForm_2);
                    formToolkit.paintBordersFor(sashForm_2);

                    mainTabFolder = new CTabFolder(sashForm_2, SWT.BORDER);
                    formToolkit.adapt(mainTabFolder);
                    formToolkit.paintBordersFor(mainTabFolder);
                    mainTabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(
                            SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

                    Composite composite_3_1 = new Composite(sashForm_2, SWT.BORDER);
                    formToolkit.adapt(composite_3_1);
                    formToolkit.paintBordersFor(composite_3_1);
                    composite_3_1.setLayout(new BorderLayout(0, 0));
                    sashForm_2.setWeights(new int[] { 260, 109 });
                }
                {
                    CTabFolder tabFolder = new CTabFolder(sashForm_1_1, SWT.BORDER);
                    formToolkit.adapt(tabFolder);
                    formToolkit.paintBordersFor(tabFolder);
                    tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(
                            SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
                    {
                        CTabItem tbtmNewItem = new CTabItem(tabFolder, SWT.NONE);
                        tbtmNewItem.setText("Outline");
                        {
                            Button btnNewButton_2 = new Button(tabFolder, SWT.NONE);
                            tbtmNewItem.setControl(btnNewButton_2);
                            btnNewButton_2.setText("New Button");
                        }
                    }
                    {
                        CTabItem tbtmNewItem_1 = new CTabItem(tabFolder, SWT.NONE);
                        tbtmNewItem_1.setText("Json");
                        {
                            Button button = new Button(tabFolder, SWT.NONE);
                            tbtmNewItem_1.setControl(button);
                            button.setText("111");
                        }
                    }
                    {
                        CTabItem tbtmXml = new CTabItem(tabFolder, SWT.NONE);
                        tbtmXml.setText("Xml");
                        {
                            Composite composite_1_1 = new Composite(tabFolder, SWT.BORDER);
                            tbtmXml.setControl(composite_1_1);
                            formToolkit.adapt(composite_1_1);
                            formToolkit.paintBordersFor(composite_1_1);
                            composite_1_1.setLayout(new BorderLayout(0, 0));
                        }
                    }
                }
                sashForm_1_1.setWeights(new int[] { 400, 200 });
            }
            {
                Composite composite_1 = new Composite(composite, SWT.NONE);
                formToolkit.adapt(composite_1);
                formToolkit.paintBordersFor(composite_1);

                Group group = new Group(composite_1, SWT.NONE);
                group.setText("新建连接");
                group.setBounds(78, 59, 359, 222);
                formToolkit.adapt(group);
                formToolkit.paintBordersFor(group);

                Button button = new Button(group, SWT.NONE);
                button.setBounds(53, 179, 92, 33);
                formToolkit.adapt(button, true, true);
                button.setText("连接");

                Button button_1 = new Button(group, SWT.NONE);
                button_1.setBounds(203, 179, 92, 33);
                formToolkit.adapt(button_1, true, true);
                button_1.setText("重置");

                Label label = new Label(group, SWT.NONE);
                label.setBounds(22, 96, 71, 21);
                label.setAlignment(SWT.CENTER);
                formToolkit.adapt(label, true, true);
                label.setText("端口:");

                text_1 = new Text(group, SWT.BORDER);
                text_1.setBounds(99, 87, 75, 30);
                formToolkit.adapt(text_1, true, true);

                Label lblNewLabel = new Label(group, SWT.NONE);
                lblNewLabel.setBounds(22, 30, 71, 21);
                lblNewLabel.setAlignment(SWT.CENTER);
                formToolkit.adapt(lblNewLabel, true, true);
                lblNewLabel.setText("地址:");

                text = new Text(group, SWT.BORDER);
                text.setBounds(99, 21, 147, 30);
                formToolkit.adapt(text, true, true);
            }

            Composite composite_1 = new Composite(composite, SWT.NONE);
            formToolkit.adapt(composite_1);
            formToolkit.paintBordersFor(composite_1);
            composite_1.setLayout(new BorderLayout(0, 0));

            Group grpXiugai = new Group(composite_1, SWT.NONE);
            grpXiugai.setLayoutData(BorderLayout.CENTER);
            grpXiugai.setText("编辑表结构");
            formToolkit.adapt(grpXiugai);
            formToolkit.paintBordersFor(grpXiugai);
            grpXiugai.setLayout(new BorderLayout(0, 0));

            table = new Table(grpXiugai, SWT.CHECK | SWT.FULL_SELECTION | SWT.VIRTUAL);
            table.setLayoutData(BorderLayout.CENTER);
            table.setTouchEnabled(true);
            formToolkit.adapt(table);
            formToolkit.paintBordersFor(table);
            table.setHeaderVisible(true);
            table.setLinesVisible(true);

            TableColumn tblclmnLie = new TableColumn(table, SWT.NONE);
            tblclmnLie.setWidth(143);
            tblclmnLie.setText("列名");

            TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
            tblclmnNewColumn.setWidth(100);
            tblclmnNewColumn.setText("新列名");

            TableItem tableItem_1 = new TableItem(table, SWT.NONE);
            tableItem_1.setFont(SWTResourceManager.getFont("Cantarell", 11, SWT.NORMAL));
            tableItem_1.setText("bbbbb");

            TableItem tableItem = new TableItem(table, SWT.NONE);
            tableItem.setText("aaa");

            TableCursor tableCursor = new TableCursor(table, SWT.NONE);
            formToolkit.adapt(tableCursor);
            formToolkit.paintBordersFor(tableCursor);

            TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
            tblclmnNewColumn_1.setWidth(100);
            tblclmnNewColumn_1.setText("默认值");

            ToolBar toolBar = new ToolBar(grpXiugai, SWT.FLAT | SWT.RIGHT);
            toolBar.setLayoutData(BorderLayout.NORTH);
            formToolkit.adapt(toolBar);
            formToolkit.paintBordersFor(toolBar);

            ToolItem toolItem = new ToolItem(toolBar, SWT.NONE);
            toolItem.setImage(SWTResourceManager.getImage(Mango.class, "/icon/add.png"));
            toolItem.setText("增加");

            ToolItem toolItem_1 = new ToolItem(toolBar, SWT.NONE);
            toolItem_1.setImage(SWTResourceManager.getImage(Mango.class, "/icon/delete.gif"));
            toolItem_1.setText("删除");

            Composite composite_2 = new Composite(composite_1, SWT.NONE);
            composite_2.setLayoutData(BorderLayout.SOUTH);
            formToolkit.adapt(composite_2);
            formToolkit.paintBordersFor(composite_2);
            composite_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

            Button btnNewButton_1 = new Button(composite_2, SWT.RIGHT);
            formToolkit.adapt(btnNewButton_1, true, true);
            btnNewButton_1.setText("提交");

            Button btnNewButton_5 = new Button(composite_2, SWT.RIGHT);
            formToolkit.adapt(btnNewButton_5, true, true);
            btnNewButton_5.setText("取消");

            Composite composite_3 = new Composite(composite, SWT.NONE);
            formToolkit.adapt(composite_3);
            formToolkit.paintBordersFor(composite_3);
            sashForm.setWeights(new int[] { 200, 600 });
        }

        return container;
    }

    /**
     * Create the menu manager.
     * 
     * @return the menu manager
     */
    @Override
    protected MenuManager createMenuManager() {
        MenuManager menuManager = new MenuManager("文件");
        menuManager.setVisible(true);
        {
            MenuManager file = new MenuManager("文件");
            menuManager.add(file);
            file.add(action_3);
            file.add(action_2);
        }
        {
            MenuManager menuManager_1 = new MenuManager("编辑");
            menuManager.add(menuManager_1);
            menuManager_1.add(action_5);
            menuManager_1.add(action_4);
        }
        {
            MenuManager menuManager_1 = new MenuManager("工具");
            menuManager.add(menuManager_1);
            menuManager_1.add(action_6);
            menuManager_1.add(action_8);
            menuManager_1.add(action_7);
        }
        {
            MenuManager menuManager_1 = new MenuManager("帮助");
            menuManager.add(menuManager_1);
            menuManager_1.add(action_10);
            menuManager_1.add(action_9);
        }
        return menuManager;
    }

    /**
     * Create the toolbar manager.
     * 
     * @return the toolbar manager
     */
    @Override
    protected ToolBarManager createToolBarManager(int style) {
        ToolBarManager toolBarManager = new ToolBarManager(style);
        toolBarManager.add(action_11);
        toolBarManager.add(action_12);
        toolBarManager.add(action_13);
        toolBarManager.add(action_14);

        return toolBarManager;
    }

    /**
     * Create the status line manager.
     * 
     * @return the status line manager
     */
    @Override
    protected StatusLineManager createStatusLineManager() {
        StatusLineManager statusLineManager = new StatusLineManager();
        return statusLineManager;
    }

    /**
     * Launch the application.
     * 
     * @param args
     */
    public static void main(String args[]) {
        try {

            Mango window = new Mango();
            window.setBlockOnOpen(true);
            // window.getShell().setSize(window.getInitialSize());
            window.open();
            Display.getCurrent().dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Configure the shell.
     * 
     * @param newShell
     */
    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("芒果");
    }

}
