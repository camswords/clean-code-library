
var ServerMessage = {};

ServerMessage.create = function(uri, jsonData, onSuccess) {

	return {
		send: function() {
			$.ajax({ url: uri, data: {'json': jsonData }, type: "POST", dataType: "json" })
				.success(onSuccess)
   			    .error(function() { alert("error found"); });
		}
	};
};