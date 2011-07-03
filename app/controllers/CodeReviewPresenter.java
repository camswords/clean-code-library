package controllers;

import models.CodeReview;
import models.CodeReviewRepository;
import play.mvc.Controller;

public class CodeReviewPresenter extends Controller {

	public static void display(String name) {
		 CodeReview codeReview = new CodeReviewRepository().load(name);
		 render(codeReview);
	}
}
