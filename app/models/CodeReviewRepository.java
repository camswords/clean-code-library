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
		
		List<WhatILike> thingsILike = Lists.create();
		StringTokenizer whatILikeTokenizer = new StringTokenizer(whatILike, ":");
		while(whatILikeTokenizer.hasMoreTokens()) {
			String lineNumber = whatILikeTokenizer.nextToken();
			
			if (!whatILikeTokenizer.hasMoreTokens()) {
				throw new RuntimeException("invalid format of what I likes, expected content to match a line number: " + whatILike);
			}
			
			String oneThingILike = whatILikeTokenizer.nextToken();
			thingsILike.add(new WhatILike(lineNumber, oneThingILike));
		}
		
		List<WhatIDontLike> thingsIDontLike = Lists.create();
		StringTokenizer whatIDontLikeTokenizer = new StringTokenizer(whatIDontLike, ":");
		while(whatIDontLikeTokenizer.hasMoreTokens()) {
			String lineNumber = whatIDontLikeTokenizer.nextToken();
		
			if (!whatIDontLikeTokenizer.hasMoreTokens()) {
				throw new RuntimeException("invalid format of what I dont likes, expected content to match a line number: " + whatIDontLike);
			}
			
			String oneThingIDontLike = whatIDontLikeTokenizer.nextToken();
			thingsIDontLike.add(new WhatIDontLike(lineNumber, oneThingIDontLike));
		}
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
}
