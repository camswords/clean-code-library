package controllers;

import models.CodeReview;
import models.CodeReviewRepository;
import play.mvc.Controller;

public class RandomCodeReviewPresenter extends Controller {

	public static void display() {
		CodeReview codeReview = new CodeReviewRepository().getRandomPieceOfCode();
		CodeReviewPresenter.display(codeReview.getName());
	}
}
