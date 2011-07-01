package models;

public class CodeReview {

	private final String text;
	private final String whatILike;
	private final String whatIDontLike;
	
	public CodeReview(String text, String whatILike, String whatIDontLike) {
		this.text = text;
		this.whatILike = whatILike;
		this.whatIDontLike = whatIDontLike;
	}

	public String getText() {
		return text;
	}

	public String getWhatILike() {
		return whatILike;
	}

	public String getWhatIDontLike() {
		return whatIDontLike;
	}
	
	
}
