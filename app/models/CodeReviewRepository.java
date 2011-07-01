package models;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

import util.Lists;

public class CodeReviewRepository {

	public CodeReview getRandomPieceOfCode() {
		String codeReview = new Random().nextBoolean() ? "cam" : "another";
		return load(codeReview);
	}
	
	public CodeReview load(String codeReviewId) {
		String content = loadContentForCodeReview(codeReviewId);
		
		int whatILikeIndex = content.indexOf(">> the good");
		int whatIDontLikeIndex = content.indexOf(">> the bad");
		int theCodeIndex = content.indexOf(">> the code");
		
		String whatILike = content.substring(whatILikeIndex, whatIDontLikeIndex).replace(">> the good\n", "");
		String whatIDontLike = content.substring(whatIDontLikeIndex, theCodeIndex).replace(">> the bad\n", "");
		String theCode = content.substring(theCodeIndex).replace(">> the code\n", "");
		
		List<ReviewComment> thingsILike = parseReviewComments(whatILike);
		List<ReviewComment> thingsIDontLike = parseReviewComments(whatIDontLike);
		return new CodeReview(theCode, thingsILike, thingsIDontLike);
	}
	
	private String loadContentForCodeReview(String codeReviewId) {
		File file = new File("data/" + codeReviewId + ".txt");
		try {
			return IOUtils.toString(new FileReader(file));
		} catch (Exception e) {
			throw new RuntimeException("cant load file " + file.getAbsolutePath());
		}
	}
	
	private List<ReviewComment> parseReviewComments(String text) {
		List<ReviewComment> reviewComments = Lists.create();
		StringTokenizer tokenizer = new StringTokenizer(text, ":");
		while(tokenizer.hasMoreTokens()) {
			String lineNumber = tokenizer.nextToken();
			
			if (!tokenizer.hasMoreTokens()) {
				throw new RuntimeException("invalid format of review comments, expected content to match a line number: " + text);
			}
			
			String content = tokenizer.nextToken();
			reviewComments.add(new ReviewComment(lineNumber, content));
		}
		return reviewComments;
	}
}
