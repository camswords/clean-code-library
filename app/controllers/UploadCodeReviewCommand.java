package controllers;

import java.lang.reflect.Type;
import java.util.List;

import models.CodeReview;
import models.CodeReviewRepository;
import models.ReviewComment;

import org.apache.commons.lang.StringUtils;

import play.mvc.Controller;
import util.Lists;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class UploadCodeReviewCommand extends Controller {

	 public static void upload(String name, String json) {
	    	JsonElement jsonObject = new JsonParser().parse(json);
	    	Type type = new TypeToken<List<String>>(){}.getType();
	    	List<String> lines = new Gson().fromJson(jsonObject, type);
	    	
	    	CodeReview codeReview = new CodeReview(name, StringUtils.join(lines, "\n"), Lists.<ReviewComment>create(), Lists.<ReviewComment>create());
	    	new CodeReviewRepository().save(codeReview);

	    	render(codeReview.getName());
	    }
}
