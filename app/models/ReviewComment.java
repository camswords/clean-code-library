package models;

public class ReviewComment {

	private final String content;
	private final String lineNumber;

	public ReviewComment(String lineNumber, String content) {
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
