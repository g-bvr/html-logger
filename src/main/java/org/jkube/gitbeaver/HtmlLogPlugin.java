    package org.jkube.gitbeaver;

    import org.jkube.gitbeaver.htmllog.HtmlLogger;
    import org.jkube.gitbeaver.htmllog.LogsDumpHtmlCommand;
    import org.jkube.gitbeaver.plugin.SimplePlugin;
    import org.jkube.logging.Log;

public class HtmlLogPlugin extends SimplePlugin {

    public HtmlLogPlugin() {
        super("""
                        Allows collection of logs and providing collected logs as hierarchically organised html file
                        """,
                LogsDumpHtmlCommand.class
        );
    }

    @Override
    public void init() {
        GitBeaver.applicationLogHandler().addLogFactory(HtmlLogger::new);
        Log.log("HtmlLogPlugin was initialized");
    }

}
