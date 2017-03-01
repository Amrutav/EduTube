(function() {
	'use strict';
	angular.module('app').controller('LogoutController', LogoutController);
	LogoutController.$inject = [ '$scope', '$uibModal', 'UserService',
			'$location', '$rootScope', 'FlashService', '$resource', '$http',
			'$cookieStore' ];
	function LogoutController($scope, $uibModal, UserService, $location,
			$rootScope, FlashService, $resource, $http, $cookieStore) {

		$scope.launchLoginModal = function() {
			var modalInstance = $uibModal.open({
				size : 'lg',
				templateUrl : 'partials/login.html',
				controller : 'LoginController',
				controllerAs : 'vm'
			});
			modalInstance.result.then(function(isLoginSuccess) {
				$scope.logouttab = true;
				$scope.logintab = false;
				$rootScope.myaccounttab = true;
				$rootScope.registertab = false;
			}, function(reason) {
				if (reason == 'register') {
					$scope.launchRegisterModal();
				}
			});
		};

		$scope.launchRegisterModal = function() {
			var modalInstance = $uibModal.open({
				size : 'lg',
				templateUrl : 'partials/register.html',
				controller : 'RegisterController',
				controllerAs : 'vm'
			});
			modalInstance.result.then(function(isLoginSuccess) {

			}, function(reason) {
				if (reason == 'login') {
					$scope.launchLoginModal();
				}
			});
		};

		$scope.logout = function() {
			console.log('logout called');

			var obj = $cookieStore.get('globals');
			console.log(obj.currentUser.userId);

			$http({
				url : "/Edutube/user/logout",
				method : 'POST',
				data : {
					userId : obj.currentUser.userId
				},
				headers : {
					'Content-Type' : 'application/json'
				},

			}).success(function(response) {
				console.log(response.status);
				if (response.status === "SUCCESS") {
					$rootScope.globals = {};
					$cookieStore.remove('globals');
					$http.defaults.headers.common.Authorization = 'Basic ';

					$scope.logouttab = false;
					$scope.logintab = true;
					$rootScope.myaccounttab = false;
					$rootScope.registertab = true;

					$location.path('/');
				} else {
					alert("oops!! something went wrong, please try agin!!");
				}

			}).error(function(error) {
				// $scope.error = error;
				alert("oops!! something went wrong, please try agin!!");
			});
		}

	}

})();
