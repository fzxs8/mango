/* ************************************************************************

   Copyright:

   License:

   Authors:

 ************************************************************************ */

/* ************************************************************************

 #asset(mango/*)

 ************************************************************************ */

/**
 * This is the main application class of your custom application "Mango"
 */
qx.Class.define("mango.Application", {
    extend : qx.application.Standalone,

    /*
     * ****************************************************************************
     * MEMBERS
     * ****************************************************************************
     */

    members : {
        /**
         * This method contains the initial application code and gets called
         * during startup of the application
         * 
         * @lint ignoreDeprecated(alert)
         */
        main : function() {
            // Call super class
            this.base(arguments);

            // Enable logging in debug variant
            if (qx.core.Environment.get("qx.debug")) {
                // support native logging capabilities, e.g. Firebug for Firefox
                qx.log.appender.Native;
                // support additional cross-browser console. Press F7 to toggle
                // visibility
                qx.log.appender.Console;
            }

            /*
             * -------------------------------------------------------------------------
             * Below is your actual application code...
             * -------------------------------------------------------------------------
             */
            var scroll = new qx.ui.container.Scroll();

            this.getRoot().add(scroll, {
                edge : 0
            });
            // container.setHeight(1400);
            // container.setWidth(1400);
            // scroll.add(container);
            // default layout, auto-sized
            var widget = new qx.ui.container.Composite(new qx.ui.layout.Dock());

            // var bar = this.createBar();

            widget.add(this.createMenuBar(), {
                edge : "north"
            });
            // widget.add(this.createToolBar(), {
            // edge : "center"
            // });
            widget.add(this.createMain(), {
                edge : "center"
            });
            scroll.add(widget);
        },
        // createBar : function() {
        // var container = new qx.ui.container.Composite(new
        // qx.ui.layout.Dock());
        // container.add(this.createMenuBar(), {
        // edge : "north"
        // });
        // container.add(this.createToolBar(), {
        // edge : "south"
        // });
        // container.add(this.createToolBar(), {
        // edge : "center"
        // });
        //
        // return container;
        // },
        createToolBar : function() {
            var container = new qx.ui.container.Composite(new qx.ui.layout.Dock);

            var toolbar = new qx.ui.toolbar.ToolBar();
            toolbar.setSpacing(5);
            container.add(toolbar);
            var part1 = new qx.ui.toolbar.Part();
            var newButton = new qx.ui.toolbar.Button("New", "icon/22/actions/document-new.png");
            var copyButton = new qx.ui.toolbar.Button("Copy", "icon/22/actions/edit-copy.png");
            var cutButton = new qx.ui.toolbar.Button("Cut", "icon/22/actions/edit-cut.png");
            var pasteButton = new qx.ui.toolbar.Button("Paste", "icon/22/actions/edit-paste.png");
            part1.add(newButton);
            part1.add(new qx.ui.toolbar.Separator());
            part1.add(copyButton);
            part1.add(cutButton);
            part1.add(pasteButton);
            toolbar.add(part1);
            return container;
        },
        createMenuBar : function() {
            var frame = new qx.ui.container.Composite(new qx.ui.layout.Grow);

            var menubar = new qx.ui.menubar.MenuBar;
            menubar.setWidth(600);
            frame.add(menubar);

            var fileMenu = new qx.ui.menubar.Button("文件", null, this.getFileMenu());

            menubar.add(fileMenu);

            return frame;
        },
        createMain : function() {

            var widget = new qx.ui.container.Composite(new qx.ui.layout.Dock());

            var pan1 = new qx.ui.splitpane.Pane("horizontal");

            pan1.setDecorator("main");

            // Left
            pan1.add(this.leftSide(), 1);

            pan1.add(this.mainSide(), 2);

            // splitpane.add(this.rightSide(), 3);

            // var pan2 = new qx.ui.splitpane.Pane("horizontal");

            // pan2.add(pan1, 1);

            // pan2.add(this.rightSide(), 2);

            widget.add(this.createToolBar(), {
                edge : "north"
            });

            widget.add(pan1, {
                edge : "center"
            });

            return widget;
        },

        leftSide : function() {

            // var hBox = new qx.ui.layout.HBox();
            // var container = new qx.ui.container.Composite(hBox);
            var tree = new qx.ui.tree.Tree();
            tree.set({
                // width : 200,
                minWidth : 250
            });
            // tree.initWidth(200);

            var root = new qx.ui.tree.TreeFolder("root");
            root.setOpen(true);
            tree.setRoot(root);

            var te1 = new qx.ui.tree.TreeFolder("Desktop");
            te1.setOpen(true);
            te1.setIcon("icon/22/places/user-desktop.png");
            root.add(te1);

            var te1_1 = new qx.ui.tree.TreeFolder("Files");
            var te1_2 = new qx.ui.tree.TreeFolder("Workspace");
            var te1_3 = new qx.ui.tree.TreeFolder("Network");
            var te1_4 = new qx.ui.tree.TreeFolder("Trash");
            te1.add(te1_1, te1_2, te1_3, te1_4);

            var te1_2_1 = new qx.ui.tree.TreeFile("Windows (C:)");
            var te1_2_2 = new qx.ui.tree.TreeFile("Documents (D:)");
            te1_2.add(te1_2_1, te1_2_2);

            var te2 = new qx.ui.tree.TreeFolder("Inbox");

            var te2_1 = new qx.ui.tree.TreeFolder("Presets");
            var te2_2 = new qx.ui.tree.TreeFolder("Sent");
            var te2_3 = new qx.ui.tree.TreeFolder("Trash");

            for ( var i = 0; i < 30; i++) {
                te2_3.add(new qx.ui.tree.TreeFile("Junk #" + i));
            }

            var te2_4 = new qx.ui.tree.TreeFolder("Data");
            var te2_5 = new qx.ui.tree.TreeFolder("Edit");

            te2.add(te2_1, te2_2, te2_3, te2_4, te2_5);

            root.add(te2);
            return tree;

        },
        mainSide : function() {
            var container = new qx.ui.container.Composite(new qx.ui.layout.Dock());
            // create the form

            var form = new qx.ui.form.Form();

            // add the first headline
            form.addGroupHeader("Registration");

            // add usernamne
            var userName = new qx.ui.form.TextField();
            userName.setRequired(true);
            form.add(userName, "Name");
            // add password
            var password = new qx.ui.form.PasswordField();
            password.setRequired(true);
            form.add(password, "Password");
            // add a save checkbox
            form.add(new qx.ui.form.CheckBox(), "Save?");

            // add the second header
            form.addGroupHeader("Personal Information");

            // add some additional widgets
            form.add(new qx.ui.form.Spinner(), "Age");
            form.add(new qx.ui.form.TextField(), "Country");

            var genderBox = new qx.ui.form.SelectBox();
            genderBox.add(new qx.ui.form.ListItem("male"));
            genderBox.add(new qx.ui.form.ListItem("female"));

            form.add(genderBox, "Gender");
            form.add(new qx.ui.form.TextArea(), "Bio");

            // send button with validation
            var sendButton = new qx.ui.form.Button("Send");
            sendButton.addListener("execute", function() {
                if (form.validate()) {
                    alert("send...");
                }
            }, this);
            form.addButton(sendButton);

            // reset button
            var resetButton = new qx.ui.form.Button("Reset");
            resetButton.addListener("execute", function() {
                form.reset();
            }, this);

            form.addButton(resetButton);
            var renderer = new qx.ui.form.renderer.Single(form);
            container.add(renderer);
            return container;
        },
        rightSide : function() {
            var container = new qx.ui.container.Composite(new qx.ui.layout.Dock());
            return container;
        },
        debugButton : function(e) {
            this.debug("Execute button: " + this.getLabel());
        },
        getFileMenu : function() {
            var menu = new qx.ui.menu.Menu;

            var newButton = new qx.ui.menu.Button("新建", "icon/16/actions/document-new.png");
            var openButton = new qx.ui.menu.Button("Open", "icon/16/actions/document-open.png");
            var closeButton = new qx.ui.menu.Button("Close");
            var saveButton = new qx.ui.menu.Button("Save", "icon/16/actions/document-save.png");
            var saveAsButton = new qx.ui.menu.Button("Save as...", "icon/16/actions/document-save-as.png");
            var printButton = new qx.ui.menu.Button("Print", "icon/16/actions/document-print.png");
            var exitButton = new qx.ui.menu.Button("Exit", "icon/16/actions/application-exit.png");

            newButton.addListener("execute", this.debugButton);
            openButton.addListener("execute", this.debugButton);
            closeButton.addListener("execute", this.debugButton);
            saveButton.addListener("execute", this.debugButton);
            saveAsButton.addListener("execute", this.debugButton);
            printButton.addListener("execute", this.debugButton);
            exitButton.addListener("execute", this.debugButton);

            menu.add(newButton);
            menu.add(openButton);
            menu.add(closeButton);
            menu.add(saveButton);
            menu.add(saveAsButton);
            menu.add(printButton);
            menu.add(exitButton);

            return menu;
        }

    }

});
