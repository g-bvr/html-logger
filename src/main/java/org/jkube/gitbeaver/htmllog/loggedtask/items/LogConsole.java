package org.jkube.gitbeaver.htmllog.loggedtask.items;

import org.jkube.gitbeaver.htmllog.html.HTMLColor;
import org.jkube.gitbeaver.htmllog.html.HTMLConsole;
import org.jkube.gitbeaver.htmllog.html.HTMLSection;
import org.jkube.gitbeaver.htmllog.loggedtask.ConsoleLine;
import org.jkube.gitbeaver.htmllog.loggedtask.LogItem;
import org.jkube.gitbeaver.htmllog.loggedtask.LoggedTask;

import java.util.ArrayList;
import java.util.List;

public class LogConsole implements LogItem {

	public static final HTMLColor COMMAND_COLOR = HTMLColor.CYAN;

	private final List<ConsoleLine> lines;

	public LogConsole() {
		this.lines = new ArrayList<>();
	}

	public LogConsole(List<ConsoleLine> lines) {
		this.lines = lines;
	}

	public List<ConsoleLine> getLines() {
		return lines;
	}

	@Override
	public void log(String user, HTMLSection section) {
		HTMLConsole console = section.addConsole();
		lines.forEach(l -> {
			if (user.equals(LoggedTask.ADMIN) || !l.adminOnly()) {
				console.addLine(l.getText(), l.getColor());
			}
		});
	}

	public void add(String line, HTMLColor color) {
		lines.add(new ConsoleLine(line, color, false));
	}

	public void addAdminOnly(String line, HTMLColor color) {
		lines.add(new ConsoleLine(line, color, true));
	}

	public void add(String line) {
		add(line, null);
	}

	public void error(String line) {
		add(line, HTMLColor.RED);
	}

	public void warn(String line) {
		add(line, HTMLColor.YELLOW);
	}
	
	public void ignore(String line) {
		add(line, HTMLColor.GRAY);
	}
	
	public void success(String line) {
		add(line, HTMLColor.GREEN);
	}

	public void command(String line) {
		addAdminOnly(line, COMMAND_COLOR);
	}

	public void adminOnly(String line) {
		addAdminOnly(line, HTMLColor.WHITE);
	}

}
