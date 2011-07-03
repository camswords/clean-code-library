
var ServerMessage = {};

ServerMessage.create = function(uri, data, onSuccess) {

	return {
		send: function() {
			$.ajax({ url: uri, data: data, type: "POST", dataType: "text" })
				.success(onSuccess)
   			    .error(function(jqXHR, textStatus, errorThrown) { alert("error found:" + textStatus + ", " + errorThrown); });
		}
	};
};