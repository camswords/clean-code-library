package models;

import java.util.List;

public class CodeReview {

	private final String text;
	private final List<WhatILike> thingsILike;
	private final String whatIDontLike;
	
	public CodeReview(String text, List<WhatILike> thingsILike, String whatIDontLike) {
		this.text = text;
		this.thingsILike = thingsILike;
		this.whatIDontLike = whatIDontLike;
	}

	public String getText() {
		return text;
	}

	public List<WhatILike> getThingsILike() {
		return thingsILike;
	}

	public String getWhatIDontLike() {
		return whatIDontLike;
	}
}
