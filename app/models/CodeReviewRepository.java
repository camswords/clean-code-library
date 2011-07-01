package models;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Random;

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
		
		String whatILike = content.substring(whatILikeIndex, whatIDontLikeIndex).replace(">> the good", "");
		String whatIDontLike = content.substring(whatIDontLikeIndex, theCodeIndex).replace(">> the bad", "");
		String theCode = content.substring(theCodeIndex).replace(">> the code", "");
		
		List<WhatILike> thingsILike = Lists.create(new WhatILike(whatILike));
		return new CodeReview(theCode, thingsILike, whatIDontLike);
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
