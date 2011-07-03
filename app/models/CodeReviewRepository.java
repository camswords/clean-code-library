package models;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

import util.Lists;

public class CodeReviewRepository {

	public CodeReview getRandomPieceOfCode() {
		File[] codeReviews = new File("data/").listFiles();
		File codeReview = codeReviews[new Random().nextInt(codeReviews.length)];
		return load(codeReview);
	}

	public CodeReview load(String name) {
		return load(new File("data/" + name + ".txt"));
	}

	public CodeReview load(File codeReviewFile) {
		String content = loadContentForCodeReview(codeReviewFile);
		
		int whatILikeIndex = content.indexOf(">> the good");
		int whatIDontLikeIndex = content.indexOf(">> the bad");
		int theCodeIndex = content.indexOf(">> the code");
		
		try {
			String whatILike = content.substring(whatILikeIndex, whatIDontLikeIndex).replace(">> the good\n", "");
			String whatIDontLike = content.substring(whatIDontLikeIndex, theCodeIndex).replace(">> the bad\n", "");
			String theCode = content.substring(theCodeIndex).replace(">> the code\n", "").replace(">> the code\r", "");
			
			List<ReviewComment> thingsILike = parseReviewComments(whatILike);
			List<ReviewComment> thingsIDontLike = parseReviewComments(whatIDontLike);
			String name = codeReviewFile.getName().replace(".txt", "");
			return new CodeReview(name, theCode, thingsILike, thingsIDontLike);			
		} catch(RuntimeException e) {
			throw new RuntimeException("failed to load code review, content is " + content, e);
		}
	}
	
	private String loadContentForCodeReview(File codeReviewFile) {
		try {
			return IOUtils.toString(new FileReader(codeReviewFile));
		} catch (Exception e) {
			throw new RuntimeException("cant load file " + codeReviewFile.getAbsolutePath());
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

	public void save(File codeReview) {
		try {
			FileWriter fileWriter = new FileWriter(new File("data/" + codeReview.getName() + ".txt"), false);
			FileReader fileReader = new FileReader(codeReview);
			IOUtils.copy(fileReader, fileWriter);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			throw new RuntimeException("failed to save code review", e);
		}
	}

	public void save(CodeReview codeReview) {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter("data/" + codeReview.getName() + ".txt", false));
			writer.println(">> the good");
			for(ReviewComment reviewComment : codeReview.getThingsILike()) {
				writer.println(reviewComment.getLineNumber() + ":" + reviewComment.getContent());
			}
			writer.println(">> the bad");
			writer.println(">> the code");
			writer.println(codeReview.getText());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException("failed to save code review with name " + codeReview.getName());
		}
	}
}
