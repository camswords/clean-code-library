package models;

public class WhatIDontLike {

	private final String lineNumber;
	private final String content;

	public WhatIDontLike(String lineNumber, String content) {
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
