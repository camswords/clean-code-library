

var Form = {};

Form.create = function(formSelector) {
	return {
		onSubmit: function(callback) {
			$(formSelector).submit(function(event) {
				event.preventDefault();
				
				callback(event);
			});
		}
	};
};