package org.jkube.gitbeaver.htmllog.loggedtask;

import org.jkube.gitbeaver.htmllog.html.*;
import org.jkube.gitbeaver.htmllog.loggedtask.items.HtmlLogConsole;
import org.jkube.gitbeaver.htmllog.loggedtask.items.LogMessage;
import org.jkube.gitbeaver.applicationlog.StepState;
import org.jkube.gitbeaver.interfaces.LogConsole;

import java.util.ArrayList;
import java.util.List;

public class LogStep {

	private final String title;
	private final int level;
	private final List<LogItem> items = new ArrayList<>();

	private StepState state;

	public LogStep(String title, int level) {
		this.title = title;
		this.level = level;
		this.state = StepState.RUNNING;
	}

	public int getLevel() { 	
		return level;
	}

	public String getTitle() {
		return title;
	}

	public StepState getState() {
		return state;
	}

	public void addItem(LogItem item) {
		items.add(item);
	}

	public void log(String text) {
		addItem(new LogMessage(text, null));
	}

	public void warn(String text) {
		addItem(new LogMessage(text, HTMLColor.YELLOW));
		combineState(StepState.WARNING);
	}

	public void error(String text) {
		addItem(new LogMessage(text, HTMLColor.RED));
		state = state.combine(StepState.ERROR);
	}

	public HtmlLogConsole addConsole() {
		HtmlLogConsole res = new HtmlLogConsole();
		addItem(res);
		return res;
	}
	public List<String> getFailedLeaves(String user) {
		List<String> res = new ArrayList<>();
		if (StepState.ERROR.equals(state)) {
			res.add(title);
		}
		return res;
	}

	public HTMLColor getColor() {
		return switch (state) {
			case DIDNOTHING -> HTMLColor.GRAY;
			case DIDSOMETHING -> HTMLColor.GREEN;
			case ERROR -> HTMLColor.RED;
			case WARNING -> HTMLColor.YELLOW;
			case SUCCESS -> HTMLColor.GREEN;
			case RUNNING -> HTMLColor.BLUE;
		};
	}

	public void putItems(boolean adminUser, HTMLSection section) {
		items.forEach(item -> item.log(adminUser, section));
	}

	public HTMLDocument createLog(boolean adminUser, String... rootParagraphs) {
		HTMLDocument res = HTML.createDocument(title);
		for (String text : rootParagraphs) {
			res.addParagraph(text);
		}
		putItems(adminUser, res.addSection(title, getColor()));
		return res;
	}

	public void addExceptionTrace(HTMLSection section, Exception e) {
		section.addParagraph("An exception occurred: "+e);
		HTMLConsole console = section.addConsole();
		Throwable cause = e;
		while (cause != null) {
			console.addLine(cause.toString(), HTMLColor.RED);
			for (StackTraceElement st : cause.getStackTrace()) {
				console.addLine(st.toString());
			}
			cause = cause.getCause();
		}
	}

	public void closeStep() {
		combineState(StepState.DIDNOTHING);
	}

	public void combineState(StepState state) {
		this.state = this.state.combine(state);
	}
}
