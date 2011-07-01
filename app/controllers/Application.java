package controllers;

import java.io.File;

import models.CodeReview;
import models.CodeReviewRepository;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
        CodeReview codeReview = new CodeReviewRepository().getRandomPieceOfCode();
		render(codeReview);
    }
    
    public static void uploadCodeReview(String name, File codeReview) {
    	new CodeReviewRepository().save(name, codeReview);
    	index();
    }
}