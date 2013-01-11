import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import swing2swt.layout.FlowLayout;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.List;

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
    private Button btnNewButton;
    private Button btnNewButton_1;

    /**
     * Create the application window.
     */
    public Mango() {
        super(null);
        setShellStyle(SWT.RESIZE | SWT.TITLE | SWT.APPLICATION_MODAL);
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
                    Tree tree = new Tree(composite_1, SWT.BORDER);
                    formToolkit.adapt(tree);
                    formToolkit.paintBordersFor(tree);
                }
            }
            {
                SashForm sashForm_1 = new SashForm(sashForm, SWT.VERTICAL);
                formToolkit.adapt(sashForm_1);
                formToolkit.paintBordersFor(sashForm_1);

                Composite composite_1 = formToolkit.createComposite(sashForm_1, SWT.NONE);
                formToolkit.paintBordersFor(composite_1);
                StackLayout sl_composite_1 = new StackLayout();

                composite_1.setLayout(sl_composite_1);
                {
                    SashForm sashForm_1_1 = new SashForm(composite_1, SWT.NONE);
                    formToolkit.adapt(sashForm_1_1);
                    formToolkit.paintBordersFor(sashForm_1_1);
                    sl_composite_1.topControl = sashForm_1_1;

                    Composite composite_2 = new Composite(sashForm_1_1, SWT.NONE);
                    formToolkit.adapt(composite_2);
                    formToolkit.paintBordersFor(composite_2);
                    composite_2.setLayout(new BorderLayout(0, 0));

                    Composite composite_3 = new Composite(composite_2, SWT.NONE);
                    composite_3.setLayoutData(BorderLayout.NORTH);
                    formToolkit.adapt(composite_3);
                    formToolkit.paintBordersFor(composite_3);
                    composite_3.setLayout(new BorderLayout(0, 0));
                    {
                        Button btnNewButton_6 = new Button(composite_3, SWT.NONE);
                        formToolkit.adapt(btnNewButton_6, true, true);
                        btnNewButton_6.setText("New Button");
                    }

                    Composite composite_4 = new Composite(composite_2, SWT.NONE);
                    composite_4.setLayoutData(BorderLayout.CENTER);
                    formToolkit.adapt(composite_4);
                    formToolkit.paintBordersFor(composite_4);
                    composite_4.setLayout(new BorderLayout(0, 0));
                    {
                        SashForm sashForm_2 = new SashForm(composite_4, SWT.VERTICAL);
                        formToolkit.adapt(sashForm_2);
                        formToolkit.paintBordersFor(sashForm_2);
                        {
                            Composite composite_3_1 = new Composite(sashForm_2, SWT.NONE);
                            formToolkit.adapt(composite_3_1);
                            formToolkit.paintBordersFor(composite_3_1);
                            composite_3_1.setLayout(new BorderLayout(0, 0));

                            Button btnNewButton_3 = new Button(composite_3_1, SWT.NONE);
                            formToolkit.adapt(btnNewButton_3, true, true);
                            btnNewButton_3.setText("New Button");
                        }

                        Composite composite_3_1 = new Composite(sashForm_2, SWT.BORDER);
                        formToolkit.adapt(composite_3_1);
                        formToolkit.paintBordersFor(composite_3_1);
                        composite_3_1.setLayout(new BorderLayout(0, 0));

                        Button btnNewButton_4 = new Button(composite_3_1, SWT.NONE);
                        formToolkit.adapt(btnNewButton_4, true, true);
                        btnNewButton_4.setText("New Button");
                        sashForm_2.setWeights(new int[] {411, 109});
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
                    sashForm_1_1.setWeights(new int[] { 482, 310 });
                }
                {
                    btnNewButton = new Button(composite_1, SWT.NONE);
                    btnNewButton.setImage(SWTResourceManager.getImage(Mango.class, "/icon/onebit_15.png"));
                    formToolkit.adapt(btnNewButton, true, true);
                    btnNewButton.setText("按钮1");

                }
                {
                    btnNewButton_1 = new Button(composite_1, SWT.NONE);
                    formToolkit.adapt(btnNewButton_1, true, true);
                    btnNewButton_1.setText("按钮2");
                }
                composite_1.setTabList(new Control[] { btnNewButton, btnNewButton_1 });
                sashForm_1.setWeights(new int[] { 374 });
            }
            sashForm.setWeights(new int[] { 223, 970 });
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
        menuManager.setVisible(true);
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

    /**
     * Return the initial size of the window.
     */
    @Override
    protected Point getInitialSize() {
        return new Point(1202, 673);
    }
}
