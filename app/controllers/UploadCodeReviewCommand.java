package controllers;

import java.lang.reflect.Type;
import java.util.Iterator;
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

	 public static void upload(String name, String json, String thingsILike, String thingsIDontLike) {
		 	validation.required(name);
		 	validation.max("name", name.length(), 20);
		 
	    	JsonElement jsonObject = new JsonParser().parse(json);
	    	Type type = new TypeToken<List<String>>(){}.getType();
	    	List<String> lines = new Gson().fromJson(jsonObject, type);
	    	validation.minSize("code", lines.size(), 1);
	    	validation.isTrue("code", StringUtils.isNotBlank(StringUtils.join(lines, ""))).message("you must have some code");
	    	
	    	Type anotherType = new TypeToken<List<ReviewComment>>() {}.getType();
	    	JsonElement anotherJsonObject = new JsonParser().parse(thingsILike);
	    	List<ReviewComment> yeahThingsILike = new Gson().fromJson(anotherJsonObject, anotherType);

	    	Type yetAnotherType = new TypeToken<List<ReviewComment>>() {}.getType();
	    	JsonElement yetAnotherJsonObject = new JsonParser().parse(thingsIDontLike);
	    	List<ReviewComment> yeahThingsIDontLike = new Gson().fromJson(yetAnotherJsonObject, yetAnotherType);
	    	validation.isTrue("reviewComments", !yeahThingsILike.isEmpty() || !yeahThingsIDontLike.isEmpty()).message("you must have a least one review comment");
	    	
	    	if (validation.hasErrors()) {
	    		params.flash();
	    		validation.keep();
	    		renderTemplate("UploadCodeReviewCommand/redirect-to-upload-form.json");
	    	}

    		CodeReview codeReview = new CodeReview(name, StringUtils.join(lines, "\n"), yeahThingsILike, yeahThingsIDontLike);
    		new CodeReviewRepository().save(codeReview);
	    	
    		renderTemplate("UploadCodeReviewCommand/redirect-to-code-review.json", codeReview.getName());
		}
}
