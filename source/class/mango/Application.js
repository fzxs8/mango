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

            var container = new qx.ui.container.Composite(new qx.ui.layout.Flow()).set({
              //  padding : 200,
                width : 1000
            })
            // container.setHeight(1400);
            // container.setWidth(1400);
            scroll.add(container);
            // default layout, auto-sized
            var widget = new qx.ui.container.Composite(new qx.ui.layout.Dock()).set({
                decorator : "main",
                backgroundColor : "gray",
                allowGrowX : false
            });

            var w1 = new qx.ui.core.Widget().set({
                decorator : "main",
                backgroundColor : "red"
            });

            var splitpane = new qx.ui.splitpane.Pane("horizontal");
            // splitpane.setWidth(400);
            // splitpane.setHeight(60);
            splitpane.setDecorator("main");

            // Left
            var leftWidget = new qx.ui.form.TextArea("Flex:1");
            leftWidget.setDecorator(null);
            leftWidget.setWrap(true);
            splitpane.add(leftWidget, 1);

            // Right
            var rightWidget = new qx.ui.form.TextArea("Flex:2");
            rightWidget.setDecorator(null);
            rightWidget.setWrap(true);
            splitpane.add(rightWidget, 2);

            widget.add(w1, {
                edge : "north"
            });
            widget.add(splitpane, {
                edge : "west"
            });

            container.add(widget);
        }
    }

});
