package org.jkube.gitbeaver.htmllog;

import org.jkube.gitbeaver.AbstractCommand;
import org.jkube.gitbeaver.GitBeaver;
import org.jkube.gitbeaver.WorkSpace;
import org.jkube.gitbeaver.util.FileUtil;
import org.jkube.logging.Log;

import java.util.List;
import java.util.Map;

public class LogsDumpHtmlCommand extends AbstractCommand {

    public LogsDumpHtmlCommand() {
        super(1, 1, "logs", "dump", "html", "to");
    }

    @Override
    public void execute(Map<String, String> variables, WorkSpace workSpace, List<String> arguments) {
        String logs = GitBeaver.getApplicationLogger(variables).getCollectedLogs(HtmlLogger.class.getName());
        FileUtil.store(workSpace.getAbsolutePath(arguments.get(0)), logs);
    }


}
