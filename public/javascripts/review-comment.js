
var ReviewComment = {};

ReviewComment.create = function(content, lineNumber) {
	return {
		content: content,
		lineNumber: lineNumber
	};
};