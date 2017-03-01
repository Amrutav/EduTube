(function() {
	'use strict';

	angular.module('app').controller('HomeController', HomeController);

	HomeController.$inject = [ 'UserService' ];
	function HomeController(UserService, $dialog) {
		var vm = this;
		console.log("home home");
	}
})();