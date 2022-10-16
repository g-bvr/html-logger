package org.jkube.gitbeaver.htmllog.loggedtask.items;

import org.jkube.gitbeaver.htmllog.html.HTMLSection;
import org.jkube.gitbeaver.htmllog.loggedtask.LogItem;
import org.jkube.gitbeaver.htmllog.loggedtask.LoggedTask;

public class SubTaskItem implements LogItem {

	private final LoggedTask subTask;

	public SubTaskItem(LoggedTask subTask) {
		this.subTask = subTask;
	}

	@Override
	public void log(String user, HTMLSection section) {
		subTask.putItems(user, section.addSubSection(subTask.getTitle(), subTask.getColor()));
	}

}
