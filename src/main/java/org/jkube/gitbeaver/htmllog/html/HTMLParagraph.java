package org.jkube.gitbeaver.htmllog.html;

public class HTMLParagraph extends HTMLElement {

	private final HTMLText text;

	public HTMLParagraph() {
		text = new HTMLText();
	}

	public HTMLParagraph(String content) {
		text = new HTMLText(content);
	}
	
	public HTMLParagraph(String content, String color) {
		text = new HTMLText(content, color);
	}

	public HTMLText getText() {
		return text;		
	}
	
	public String toString() {
		return HTMLConst.PARAGRAPH_START + "\n" +
				text +
				HTMLConst.PARAGRAPH_END + "\n";
	}
	
}
