var host = "http://localhost:8081/api";

const app = angular.module("app", []);

app.controller("ctrl", function($scope, $http) {
	
	$scope.items = {}
	
		$scope.load_all = function() {
		var url = `${host}/order`;
		$http.get(url).then(resp => {
			$scope.items = resp.data;
	
		}).catch(error => {

			console.log("Error", error)
		});
	}
	
	$scope.load_all();
});