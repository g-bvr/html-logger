    package org.jkube.gitbeaver.htmllog;

import org.jkube.gitbeaver.GitBeaver;
import org.jkube.gitbeaver.plugin.SimplePlugin;
import org.jkube.logging.Log;

public class HtmlLogPlugin extends SimplePlugin {

    public HtmlLogPlugin() {
        super(
                LogsDumpHtmlCommand.class
        );
    }

    @Override
    public void init() {
        GitBeaver.applicationLogHandler().addLogFactory(HtmlLogger::new);
        Log.log("HtmlLogPlugin was initialized");
    }

}
