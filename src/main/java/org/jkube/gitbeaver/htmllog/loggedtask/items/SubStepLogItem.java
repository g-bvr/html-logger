package org.jkube.gitbeaver.htmllog.loggedtask.items;

import org.jkube.gitbeaver.htmllog.html.HTMLSection;
import org.jkube.gitbeaver.htmllog.loggedtask.LogItem;
import org.jkube.gitbeaver.htmllog.loggedtask.LogStep;

public class SubStepLogItem implements LogItem {

    private final LogStep subStep;
    public SubStepLogItem(LogStep subStep) {
        this.subStep = subStep;
    }

    @Override
    public void log(boolean adminUser, HTMLSection section) {
        HTMLSection subSection = section.addSubSection(subStep.getTitle(), subStep.getColor());
        subStep.putItems(adminUser, subSection);
    }
}
