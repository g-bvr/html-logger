package org.jkube.gitbeaver.htmllog.loggedtask;


import org.jkube.gitbeaver.htmllog.html.HTMLSection;


public interface LogItem {

	void log(boolean adminUser, HTMLSection section);

}
