package org.jkube.gitbeaver.htmllog.loggedtask.items;

import org.jkube.gitbeaver.htmllog.html.HTMLColor;
import org.jkube.gitbeaver.htmllog.html.HTMLSection;
import org.jkube.gitbeaver.htmllog.loggedtask.LogItem;

public class LogMessage implements LogItem {

	private final HTMLColor color;
	private final String text;

	public LogMessage() {
		this.text = "";
		this.color = HTMLColor.GRAY;
	}

	public LogMessage(String text, HTMLColor color) {
		this.text = text;
		this.color = color;
	}

	public HTMLColor getColor() {
		return color;
	}

	public String getText() {
		return text;
	}

	@Override
	public void log(boolean adminUser, HTMLSection section) {
		section.addParagraph(text, color);
	}

}
