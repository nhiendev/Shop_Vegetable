
const app = angular.module("appCheckOut", []);

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


	$scope.order = {
		createDate: new Date(),
		address: "",

		get orderDetail() {
			return $scope.cart.Product.map(item => {
				return {
					product: { id: item.id },
					price: item.price,
					quantity: item.qty
				}
			})
		},
		purchase() {


			var order = angular.copy(this)
			// dat hang
			/*$http.post('/api/orders', order).then(res => {
				alert('dat hang thanh cong')
			})*/
			console.clear()
			console.log(order)
		},


		orderEx() {
			console.clear();
			var ListProducts = [];
			for (var i = 0; i < $scope.cart.Product.length; i++) {
				var product = $scope.cart.Product[i];
				var productInfo = {
					product: product.id,
					price: product.price,
					quantity: product.qty
				};

				ListProducts.push(productInfo);
			}

			var orr = {
				address: document.getElementById('address').value,
				createdate: new Date(),
				orderdetails: ListProducts
			};


			$http.post('/api/orders', orr).then(res => {
				alert('dat hang thanh cong')
					$scope.cart.clearCart();
					location.href="/order-user"
			})

			console.log(orr)
		}

	}


	$scope.orderEx = function() {




		console.log(orr)

	}

});