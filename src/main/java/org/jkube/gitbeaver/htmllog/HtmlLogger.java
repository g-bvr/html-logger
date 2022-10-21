package org.jkube.gitbeaver.htmllog;

import org.jkube.gitbeaver.htmllog.loggedtask.LogStep;
import org.jkube.gitbeaver.interfaces.ApplicationLogger;
import org.jkube.gitbeaver.interfaces.LogConsole;
import org.jkube.gitbeaver.applicationlog.StepState;

import java.util.*;

public class HtmlLogger implements ApplicationLogger {

    private final LinkedList<LogStep> stepStack = new LinkedList<>();

    public HtmlLogger(String runId) {
        createStep(runId);
    }

    @Override
    public LogConsole createSubConsole() {
        return currentStep().addConsole();
    }

    private LogStep currentStep() {
        return stepStack.peekLast();
    }

    @Override
    public void createStep(String title) {
        LogStep step = new LogStep(title, stepStack.size());
        stepStack.push(step);
    }

    @Override
    public void setStepState(StepState state) {
        currentStep().combineState(state);
    }

    @Override
    public void closeStep() {
        stepStack.pop().closeStep();
    }

    @Override
    public String getCollectedLogs() {
        return stepStack.getFirst().createLog(true, "This is the log").toString();
    }

    @Override
    public void log(String line) {
        currentStep().log(line);
    }

    @Override
    public void warn(String line) {
        currentStep().warn(line);
    }

    @Override
    public void error(String line) {
        currentStep().error(line);
    }
}
