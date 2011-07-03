
describe("json", function() {

	it("should convert an object array to json", function() {
		var data = ["a", "b", "c"];
		
		var json = Json.createFrom(data);
		expect(json).toEqual('["a","b","c"]');	
	});
	
	it("should convert json to javascript object", function() {
		var object = Json.toObject('{ "value":"56" }');
		expect(object.value).toEqual("56");
	});
});