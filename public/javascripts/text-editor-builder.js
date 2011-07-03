

var TextEditorBuilder = {};

TextEditorBuilder.create = function() {
	var _elementSelector = 'no.element.specified';
	var _isReadOnly = true;

	var self = {
		isReadOnly: function() {
			_isReadOnly = true; 
			return self;
		},
		isEditable: function() {
			_isReadOnly = false;
			return self;
		},
		atElement: function(elementSelector) {
			_elementSelector = elementSelector;
			return self;
		},
		build: function() {
			return TextEditor.create(_elementSelector, _isReadOnly);
		}
	};
	return self;
};