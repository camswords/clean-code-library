package models;

import java.io.File;
import java.io.FileReader;
import java.util.Random;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

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
		
		String whatILike = content.substring(whatILikeIndex, whatIDontLikeIndex).replace(">> the good", "");
		String whatIDontLike = content.substring(whatIDontLikeIndex, theCodeIndex).replace(">> the bad", "");
		String theCode = content.substring(theCodeIndex).replace(">> the code", "");
		
		return new CodeReview(theCode, whatILike, whatIDontLike);
	}
	
	private String loadContentForCodeReview(String codeReviewId) {
		File file = new File("data/" + codeReviewId + ".txt");
		try {
			return IOUtils.toString(new FileReader(file));
		} catch (Exception e) {
			throw new RuntimeException("cant load file " + file.getAbsolutePath());
		}
	}
}
