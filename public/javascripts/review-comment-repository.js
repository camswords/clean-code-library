
var ReviewCommentRepository = {};

ReviewCommentRepository.create = function() {
	var all = [];

	return {
		all: function() { return all; },
		save: function(reviewComment) { all.push(reviewComment); }
	};
};