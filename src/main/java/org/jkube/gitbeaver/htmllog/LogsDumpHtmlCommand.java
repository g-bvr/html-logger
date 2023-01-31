package org.jkube.gitbeaver.htmllog;

import org.jkube.gitbeaver.AbstractCommand;
import org.jkube.gitbeaver.GitBeaver;
import org.jkube.gitbeaver.WorkSpace;
import org.jkube.gitbeaver.util.FileUtil;

import java.util.Map;

public class LogsDumpHtmlCommand extends AbstractCommand {

    private static final String FILE = "file";

    public LogsDumpHtmlCommand() {
        super("Store logs into a html file");
        commandline("WRITE HTML LOGS INTO "+FILE);
        argument(FILE, "the path (relative to current workspace) of the file into which the logs shall be written");
    }

    @Override
    public void execute(Map<String, String> variables, WorkSpace workSpace, Map<String, String> arguments) {
        String logs = GitBeaver.getApplicationLogger(variables).getCollectedLogs(HtmlLogger.class.getName());
        FileUtil.store(workSpace.getAbsolutePath(arguments.get(FILE)), logs);
    }


}
