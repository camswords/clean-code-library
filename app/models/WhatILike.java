package models;

public class WhatILike {

	private final String content;
	private final String lineNumber;

	public WhatILike(String lineNumber, String content) {
		this.lineNumber = lineNumber;
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getLineNumber() {
		return lineNumber;
	}

}
