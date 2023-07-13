import org.jkube.gitbeaver.GitBeaver;
import org.jkube.gitbeaver.HtmlLogPlugin;
import org.jkube.gitbeaver.WorkSpace;
import org.jkube.gitbeaver.applicationlog.CombinedApplicationLoggers;
import org.jkube.gitbeaver.htmllog.WriteHtmlLogsCommand;
import org.jkube.gitbeaver.util.test.CreatePluginDocumentation;
import org.jkube.gitbeaver.util.test.TestUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class HtmlLogTest extends CreatePluginDocumentation {

    @BeforeAll
    static void beforeAllTests() {
        new HtmlLogPlugin().init();
        TestUtil.beforeTests();
    }

    @BeforeEach
    void beforeEachTest() { TestUtil.beforeEachTest(); }

    @Test
    void subStepTest() {
        String run = "test";
        GitBeaver.applicationLogHandler().createRun(run);
        Map<String, String> variables = Map.of("run", run);
        CombinedApplicationLoggers logger = GitBeaver.getApplicationLogger(variables);
        logger.createStep("Step");
        logger.log("Hello world");
        logger.createStep("SubStep");
        logger.log("Hello sub-world!");
        logger.closeStep();
        logger.closeStep();
        new WriteHtmlLogsCommand().execute(variables, new WorkSpace("."), Map.of("file", "log.html"));
    }

    @Test
    void writeLogsNotClosedTest() {
        String run = "test";
        GitBeaver.applicationLogHandler().createRun(run);
        Map<String, String> variables = Map.of("run", run);
        CombinedApplicationLoggers logger = GitBeaver.getApplicationLogger(variables);
        logger.createStep("Step");
        logger.log("Hello world");
        logger.createStep("SubStep");
        logger.log("Hello sub-world");
        new WriteHtmlLogsCommand().execute(variables, new WorkSpace("."), Map.of("file", "log.html"));
        logger.closeStep();
        logger.closeStep();
    }

    @AfterEach
    void afterEachTest() { TestUtil.assertNoFailures(); }


}
