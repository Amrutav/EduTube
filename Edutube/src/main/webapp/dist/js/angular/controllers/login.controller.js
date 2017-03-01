(function() {
	'use strict';

	angular.module('app').controller('LoginController', LoginController);

	LoginController.$inject = [ '$scope', '$uibModalInstance', '$location', 'AuthenticationService',
			'FlashService' ];
	function LoginController($scope, $uibModalInstance, $location, AuthenticationService, FlashService) {
		var vm = this;
		
		vm.login = login;

		/*
		 * (function initController() { // reset login status
		 * AuthenticationService.ClearCredentials(); })();
		 */

		function login() {
			console.log('login button clicked');
			vm.dataLoading = true;
			AuthenticationService.Login(vm.username, vm.password, function(
					response) {

				if (response.status === "SUCCESS") {
					AuthenticationService.SetCredentials(vm.username,
							vm.password, response.user.userFirstName,
							response.user.userLastName, response.user.userType,
							response.user.email, response.user.userId,
							response.user.userAccountFlag);

					$location.path('/');
					$uibModalInstance.close(true);

				} else {
					//FlashService.Error(response.status);
					vm.error = response.status;
					vm.dataLoading = false;

				}
			});
		};
			
		vm.closeLoginModal = function() {
			$uibModalInstance.dismiss('cancel');
		};
		
		vm.register = function() {
			$uibModalInstance.dismiss('register');
		};
	}
	
})();
