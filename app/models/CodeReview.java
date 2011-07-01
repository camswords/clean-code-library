package models;

import java.util.List;

public class CodeReview {

	private final String text;
	private final List<WhatILike> thingsILike;
	private final List<WhatIDontLike> thingsIDontLike;
	
	public CodeReview(String text, List<WhatILike> thingsILike, List<WhatIDontLike> thingsIDontLike) {
		this.text = text;
		this.thingsILike = thingsILike;
		this.thingsIDontLike = thingsIDontLike;
	}

	public String getText() {
		return text;
	}

	public List<WhatILike> getThingsILike() {
		return thingsILike;
	}

	public List<WhatIDontLike> getThingsIDontLike() {
		return thingsIDontLike;
	}
}
