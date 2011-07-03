
var ReviewComment = {};

ReviewComment.like = function(content, lineNumber) {
	return {
		content: content,
		lineNumber: lineNumber
	};
};