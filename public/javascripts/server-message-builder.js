
var ServerMessageBuilder = {};

ServerMessageBuilder.create = function() {
	var _uri = 'no.uri.specified';
	var _data = 'no.data.specified';
	var _onSuccess = 'no.onSuccess.specified';
	
	var self = {
		postTo: function(uri) {
			_uri = uri;
			return self;
		},
		data: function(data) {
			_data = data;
			return self;
		},
		onSuccess: function(onSuccess) {
			_onSuccess = onSuccess;
			return self;
		},
		build: function() {
			return ServerMessage.create(_uri, _data, _onSuccess);
		}
	};
	return self;
};
