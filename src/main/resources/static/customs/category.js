let host = "http://localhost:8081/api";

const app = angular.module("app", []);

app.controller("ctrl", function($scope, $http) {

	$scope.form = {};

	$scope.items = [];
	$scope.reset = function() {
		$scope.form = {};
		$scope.key = null;
	}
	$scope.load_all = function() {
		var url = `${host}/category`;
		$http.get(url).then(resp => {
			$scope.items = resp.data;

		}).catch(error => {

			console.log("Error", error)
		});
	}

	$scope.edit = function(key) {
		var url = `${host}/category/${key}`;
		$http.get(url).then(resp => {
			$scope.form = resp.data;
			$scope.key = key;
			console.log("Success", resp)
		}).catch(error => {
			console.log("Error", error)
		});
	}

	$scope.create = function() {
		var item = angular.copy($scope.form);
		var url = `${host}/category`;
		$http.post(url, item).then(resp => {

			$scope.items.push(item);
			$scope.load_all();
			$scope.reset();
			console.log("Success", resp)
		}).catch(error => {
			console.log("Error", error)
		});
	}

	$scope.update = function() {
		var item = angular.copy($scope.form);
		var url = `${host}/category/${$scope.form.id}`;

		$http.put(url, item).then(resp => {
			var index = $scope.items.findIndex(item => item.id == $scope.form.id);
			$scope.items[index] = resp.data;
			$scope.load_all();
			console.log("Success", resp)
		}).catch(error => {
			console.log("Error", error)
		});
	}

	$scope.delete = function(key) {
		var url = `${host}/category/${key}`;
		$http.delete(url).then(resp => {
			var index = $scope.items.findIndex(item => item.id == key);
			$scope.items.splice(index, 1);
			$scope.load_all();
			$scope.reset();
			console.log("Success", resp)
		}).catch(error => {
			console.log("Error", error)
		});
	}

	// Thực hiện tải toàn bộ students
	$scope.load_all();
	$scope.reset();


})