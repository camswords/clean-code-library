
describe("json", function() {

	it("should convert an object array to json", function() {
		var data = ["a", "b", "c"];
		
		var json = Json.createFrom(data);
		expect(json).toEqual('["a","b","c"]');	
	});
});