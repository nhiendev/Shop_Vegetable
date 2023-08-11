var host = "http://localhost:8081/api/product";

const app = angular.module("app", []);

app.controller("ctrl", function($scope, $http) {

	$scope.productHome = [];

	$scope.listImg = function() {
		let url = `${host}/best-seller`
		$http.get(url).then(resp => {
			$scope.productHome = resp.data;
			console.log('successfully listImg: ', resp)
		}).catch(error => {
			console.log('Error listImg: ', error)
		})
	}

	$scope.getOneProduct = function(id) {
		let url = `${host}/${id}`
		$http.get(url).then(resp => {
			$scope.productHome = resp.data;
			console.log('successfully getOneProduct: ', resp)
		}).catch(error => {
			console.log('Error getOneProduct: ', error)
		})
	}




	$scope.listImg();

});


app.controller("cart", function($scope, $http) {

	$scope.Product = [];

	$scope.AddLocalStore = function(id) {
		let url = `${host}/${id}`;
		$http.get(url).then(resp => {
			let item = resp.data;
			$scope.Product.push(item);
			localStorage.setItem("NameProduct", JSON.stringify($scope.Product));
			console.log('successfully Add LocalStore: ', resp)
		}).catch(error => {
			console.log('Error Add LocalStore: ', error)
		});
	};

	$scope.viewCart = function() {
		//		let ss = $scope.Product.findIndex(item => item.id == $scope.Product.id);
		$scope.listCart = JSON.parse(localStorage.getItem('NameProduct'));
		console.log('List Cart : ', $scope.listCart);
	}


	/*	$scope.countCart = function() {
			let url = `${host}/addtocart/count`;
			$http.get(url).then(resp => {
				$scope.numberProducts = resp.data;
				console.log('successfully countCart: ', resp)
			}).catch(error => {
				console.log('Error countCart: ', error)
			});
		}
	
		
	
		$scope.countCart();*/

	$scope.viewCart();
});