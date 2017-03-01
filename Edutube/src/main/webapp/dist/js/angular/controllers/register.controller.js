(function() {
	'use strict';
	angular.module('app').controller('RegisterController', RegisterController);
	RegisterController.$inject = [ 'UserService', '$location', '$rootScope',
			'FlashService', '$resource', '$http', '$scope', '$uibModalInstance' ];
	function RegisterController(UserService, $location, $rootScope,
			FlashService, $resource, $http, $scope, $uibModalInstance) {
		var vm = this;
		vm.register = register;

		function register() {
			vm.dataLoading = true;

			var user = $resource('/Edutube/user/register');

			user.save({
				'userFirstName' : vm.user.userFirstName,
				'userLastName' : vm.user.userLastName,
				'email' : vm.user.email,
				// 'mobile' : vm.user.mobile,
				'username' : vm.user.username,
				'password' : vm.user.password
			}, function(response) {
				if (response.status === "SUCCESS") {
					vm.success = response.status;
				} else {
					vm.error.msg = response.status;
				}
			});

			vm.dataLoading = false;
		}

		$scope.checkAvailability = function(vm) {

			if ($scope.vm.user.username != undefined) {
				var postData = {
					username : $scope.vm.user.username
				};

				// $scope.vm.user.username;

				$http({
					url : "/Edutube/user/validateUsername",
					method : 'GET',
					params : postData,
					headers : {
						'Content-Type' : 'application/json'
					},

				}).success(function(response) {

					if (response.status === "EXIST") {
						$scope.usernamecheck = true;
						$scope.usernamecheckmsg = response.status;
					} else {
						$scope.usernamecheck = false;
					}

				}).error(function(error) {
					// $scope.error = error;
				});
			}
		}
		
		$scope.checkEmailAvailability = function(vm) {

			if ($scope.vm.user.email != undefined) {
				var postData = {
					email : $scope.vm.user.email
				};

				$http({
					url : "/Edutube/user/validateEmail",
					method : 'GET',
					params : postData,
					headers : {
						'Content-Type' : 'application/json'
					},

				}).success(function(response) {

					if (response.status === "EXIST") {
						$scope.emailcheck = true;
						$scope.emailcheckmsg = response.status;
					} else {
						$scope.emailcheck = false;
					}

				}).error(function(error) {
					// $scope.error = error;
				});
			}
		}

		vm.closeRegisterModal = function() {
			$uibModalInstance.dismiss('cancel');
		};

		vm.login = function() {
			$uibModalInstance.dismiss('login');
		};

	}

})();
