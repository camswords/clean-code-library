
var ReviewCommentRepository = {};

ReviewCommentRepository.create = function(elementSelector) {
	var all = [];

	return {
		all: function() { return all; },
		save: function(reviewComment) { 
			all.push(reviewComment); 
			
			$(elementSelector).append(reviewComment.content);
		}
	};
};