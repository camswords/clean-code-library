package models;

import java.util.List;

public class CodeReview {

	private final String text;
	private final List<ReviewComment> thingsILike;
	private final List<ReviewComment> thingsIDontLike;
	
	public CodeReview(String text, List<ReviewComment> thingsILike, List<ReviewComment> thingsIDontLike) {
		this.text = text;
		this.thingsILike = thingsILike;
		this.thingsIDontLike = thingsIDontLike;
	}

	public String getText() {
		return text;
	}

	public List<ReviewComment> getThingsILike() {
		return thingsILike;
	}

	public List<ReviewComment> getThingsIDontLike() {
		return thingsIDontLike;
	}
}
