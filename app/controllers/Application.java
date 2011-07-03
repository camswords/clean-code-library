package controllers;

import java.io.File;

import models.CodeReview;
import models.CodeReviewRepository;
import models.ReviewComment;
import play.mvc.Controller;
import util.Lists;

import com.google.gson.JsonObject;

public class Application extends Controller {

    public static void index() {
        CodeReview codeReview = new CodeReviewRepository().getRandomPieceOfCode();
		render(codeReview);
    }
    
    public static void uploadCodeReview(String name, File codeReview) {
    	new CodeReviewRepository().save(name, codeReview);
    	index();
    }
    
    public static void add() {
    	render();
    }
    
    public static void someMethod(String json) {
    	System.out.println("json:" + json);
    }
    
    public static void uploadSomeCode(String name, String code) {
    	CodeReview codeReview = new CodeReview(code, Lists.<ReviewComment>create(), Lists.<ReviewComment>create());
    	new CodeReviewRepository().save(name, codeReview);
    	index();
    }
}