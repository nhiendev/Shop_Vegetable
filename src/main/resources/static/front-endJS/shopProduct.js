var hostProductCate = "http://localhost:8081/api/product/category";
var hostCategory = "http://localhost:8081/api/category";
var hostProduct = "http://localhost:8081/api/product";

const app = angular.module("app", []);

app.controller("ctrl", function($scope, $http) {

	$scope.productByCate = [];

	$scope.category = [];

	$scope.listAllProduct = function() {
		let url = `${hostProduct}`
		$http.get(url).then(resp => {
			$scope.productByCate = resp.data;
			console.log('successfully listAllProduct: ', resp)
		}).catch(error => {
			console.log('Error listAllProduct: ', error)
		})
	}

	$scope.listProductByCategory = function(category) {
		let url = `${hostProductCate}/${category}`
		$http.get(url).then(resp => {
			$scope.productByCate = resp.data;
			console.log('successfully listProductByCategory: ', resp)
		}).catch(error => {
			console.log('Error listProductByCategory: ', error)
		})
	}
	$scope.listCategory = function() {
		let url = `${hostCategory}`;
		$http.get(url).then(resp => {
			$scope.category = resp.data;
			console.log('successfully listCategory: ', resp)
		}).catch(error => {
			console.log('Error category listCategory: ', error)
		})
	}

	$scope.listAllProduct();
	$scope.listCategory();
})

app.controller("cart", function($scope, $http) {

	$scope.cart = {
		Product: [],

		// Đẩy dữ liệu vào LocalStore
		AddLocalStore(id) {
			let url = `${hostProduct}/${id}`;
			let item = this.Product.find(item => item.id == id);
			if (item) {
				item.qty++;
				this.saveLocalStore();
			} else {
				$http.get(url).then(resp => {
					resp.data.qty = 1;
					this.Product.push(resp.data);
					this.saveLocalStore();
					console.log('successfully Add LocalStore: ', resp)
				}).catch(error => {
					console.log('Error Add LocalStore: ', error)
				});
			}
		},


		// luu vao localStore
		saveLocalStore() {
			var json = JSON.stringify(angular.copy(this.Product));
			localStorage.setItem("NameProduct", json);
		},


		// Đếm số phần tử trong cart
		get getCount() {
			return this.Product.map(item => item.qty).reduce((total, qty) => total += qty, 0);
		},

		get getCountCart() {
			return this.Product.map(item => item.qty).reduce((total, qty) => total += qty, 0);
		},

		// Tổng tiền số phần tử trong cart
		get amount() {
			return this.Product
				.map(item => item.qty * item.price)
				.reduce((total, qty) => total += qty, 0);
		},

		// Load len lai cart
		loadFormLocalStorage() {
			var json = localStorage.getItem('NameProduct');
			this.Product = json ? JSON.parse(json) : [];
		},

		// xoa sp ra gio hang
		removeProduct(id) {
			let productIndex = this.Product.findIndex(item => item.id == id);
			this.Product.splice(productIndex, 1);
			this.saveLocalStore();
		},
		clearCart() {
			this.Product = []
			this.saveLocalStore();
		}
	};
	$scope.cart.loadFormLocalStorage();

	

});