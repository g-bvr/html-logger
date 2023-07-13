package org.jkube.gitbeaver.htmllog;

import org.jkube.gitbeaver.applicationlog.StepState;
import org.jkube.gitbeaver.htmllog.loggedtask.LogStep;
import org.jkube.gitbeaver.interfaces.ApplicationLogger;
import org.jkube.gitbeaver.interfaces.LogConsole;

import java.util.LinkedList;

public class HtmlLogger implements ApplicationLogger {

    private final String runId;
    private final LinkedList<LogStep> stepStack = new LinkedList<>();

    public HtmlLogger(String runId) {
        this.runId = runId;
        createStep(runId);
    }

    @Override
    public LogConsole createSubConsole() {
        return currentStep().addConsole();
    }

    private LogStep currentStep() {
        return stepStack.peek();
    }

    @Override
    public void createStep(String title) {
        LogStep step = new LogStep(title, stepStack.size());
        if (!stepStack.isEmpty()) {
            currentStep().addSubStep(step);
        }
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
        System.out.println("Step stack for logger for run="+runId);
        stepStack.forEach(System.out::println);
        return stepStack.getLast().createLog(true, "This is the log").toString();
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
