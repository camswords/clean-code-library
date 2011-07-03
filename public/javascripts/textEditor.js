
var TextEditor = {};

TextEditor.create = function(elementId) {

		var editor = ace.edit("code-under-review");
		
		var JavaMode = require("ace/mode/java").Mode;
		editor.getSession().setMode(new JavaMode());
		editor.setReadOnly(false);
		editor.setShowPrintMargin(false);
		editor.setHighlightActiveLine(true);

	return {
		getLinesOfText: function() {
			return editor.env.document.getDocument().getAllLines();
		}
	};
};