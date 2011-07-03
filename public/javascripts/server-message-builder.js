
var ServerMessageBuilder = {};

ServerMessageBuilder.create = function() {
	var _uri = 'no.uri.specified';
	var _jsonData = 'no.data.specified';
	var _onSuccess = 'no.onSuccess.specified';
	
	var self = {
		postTo: function(uri) {
			_uri = uri;
			return self;
		},
		jsonData: function(jsonData) {
			_jsonData = $.toJSON(jsonData);
			return self;
		},
		onSuccess: function(onSuccess) {
			_onSuccess = onSuccess;
			return self;
		},
		build: function() {
			return ServerMessage.create(_uri, _jsonData, _onSuccess);
		}
	};
	return self;
};
