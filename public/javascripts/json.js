

var Json = {};

Json.createFrom = function(data) {
	return $.toJSON(data);
};

Json.toObject = function(json) {
	return $.evalJSON(json);
};