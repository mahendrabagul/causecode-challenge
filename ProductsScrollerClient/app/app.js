var infiniteScrollApp = angular.module('infiniteScrollApp', ['infinite-scroll']);
angular.module('infinite-scroll').value('THROTTLE_MILLISECONDS', 250);
infiniteScrollApp.controller('ScrollingController', function($scope, ProductsScrollServer) {
	$scope.productsScrollServer = new ProductsScrollServer();
});
// ProductsScrollServer constructor function to encapsulate HTTP and pagination logic
infiniteScrollApp.factory('ProductsScrollServer', function($http) {
	var ProductsScrollServer = function() {
		this.products = [];
		this.busy = false;
		this.after = '0';
	};
	
	ProductsScrollServer.prototype.nextPage = function() {
		if (this.busy) return;
		this.busy = true;
		var url = "http://localhost:8181/ProductsScrollerServer/products?after=" + this.after + "&callback=JSON_CALLBACK";
		$http.jsonp(url).success(function(data) {
			console.log(data.children);
			var products = data.children;
			for (var i = 0; i < products.length; i++) {
				this.products.push(products[i]);
			}
			this.after = this.products[this.products.length - 1].id;
			this.busy = false;
		}.bind(this));
	};
	return ProductsScrollServer;
});