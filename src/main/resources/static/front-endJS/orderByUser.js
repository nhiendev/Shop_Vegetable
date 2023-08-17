const host = "http://localhost:8081/api/order/user";


app.controller("orderUser", function($scope, $http) {


	$scope.orderByUser = [];


	$scope.getUsername = function() {
		let cookie = {};
		document.cookie.split(';').forEach(function(el) {
			let [key, value] = el.split('=');
			cookie[key.trim()] = value;
		})
		return cookie["uName"];
	}

	$scope.listOrderByUser = function() {
		let url = `${host}/${$scope.getUsername()}`
		$http.get(url).then(resp => {
			$scope.orderByUser = resp.data;
			console.log('successfully listOrderByUser: ', resp)
		}).catch(error => {
			console.log('Error listOrderByUser: ', error)
		})
	}
	
		$scope.deleteOrder = function(key) {
		var url = `${host}/${key}`;
		$http.delete(url).then(resp => {
			var index = $scope.orderByUser.findIndex(item => item.id == key);
			$scope.orderByUser.splice(index, 1);
			$scope.listOrderByUser();
			console.log("Success deleteOrder", resp)
		}).catch(error => {
			console.log("Error deleteOrder", error)
		});
	}
	

	$scope.listOrderByUser();
});