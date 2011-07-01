package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        CodeReview codeReview = new CodeReviewRepository().getRandomPieceOfCode();
		render(codeReview);
    }

}