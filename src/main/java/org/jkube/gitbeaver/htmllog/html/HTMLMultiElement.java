package org.jkube.gitbeaver.htmllog.html;

import java.util.ArrayList;
import java.util.List;

public class HTMLMultiElement extends HTMLElement {

	private final List<HTMLElement> elements = new ArrayList<>();

	public HTMLMultiElement() {
	}

	public void add(HTMLElement subElement) {
		elements.add(subElement);		
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (HTMLElement e : elements) {
			sb.append(e);
			sb.append("\n");				
		}
		return sb.toString();
	}
	
}
