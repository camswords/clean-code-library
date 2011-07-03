
var TextEditor = {};

TextEditor.create = function(elementId, isReadOnly) {

		var editor = ace.edit("code-under-review");
		
		var JavaMode = require("ace/mode/java").Mode;
		editor.getSession().setMode(new JavaMode());
		editor.setReadOnly(isReadOnly);
		editor.setShowPrintMargin(false);
		editor.setHighlightActiveLine(true);

	return {
		getLinesOfText: function() {
			return editor.env.document.getDocument().getAllLines();
		},
		highlightLine: function(lineNumber) {
			editor.gotoLine(lineNumber);
			editor.scrollToLine(lineNumber);
			editor.setHighlightActiveLine(true);
		},
		getSelection: function() {
			return editor.selection.getCursor().row + 1;
		},
		getEditor: function() {
			return editor;
		}
	};
};