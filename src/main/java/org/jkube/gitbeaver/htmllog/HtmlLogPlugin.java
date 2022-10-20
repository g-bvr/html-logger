    package org.jkube.gitbeaver.htmllog;

import org.jkube.gitbeaver.plugin.SimplePlugin;
import org.jkube.logging.Log;

public class HtmlLogPlugin extends SimplePlugin {

    public HtmlLogPlugin() {
        super();
    }

    @Override
    public void init() {
        Log.log("HtmlLogPlugin was initialized");
    }

}
