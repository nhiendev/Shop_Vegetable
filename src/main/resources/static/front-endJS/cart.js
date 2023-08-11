var host = "http://localhost:8081/api/product";

const app = angular.module("appCart", []);

app.controller("cart", function($scope, $http) {

	$scope.Product = [];

	$scope.AddLocalStore = function(id) {
		let url = `${host}/${id}`;
		let item = $scope.Product.find(item => item.id == id);
		if (item) {
			item.qty++;
			$scope.saveLocalStore();
		} else {
			$http.get(url).then(resp => {
				resp.data.qty = 1;
				$scope.Product.push(resp.data);
				$scope.saveLocalStore();
				console.log('successfully Add LocalStore: ', resp)
			}).catch(error => {
				console.log('Error Add LocalStore: ', error)
			});
		}

	};

	$scope.saveLocalStore = function() {
		localStorage.setItem("NameProduct", JSON.stringify(angular.copy($scope.Product)));
	}
	
	$scope.count = function(){
		$scope.count =  $scope.Product.maps(item => item.qty).reduce((total,qty) => total += qty,0); 
		return $scope.count;
	}
	

});