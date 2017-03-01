(function() {
	'use strict';

	angular.module('app', [ 'ngRoute', 'ngCookies', 'ngResource', 'ui.bootstrap']).config(config).run(run);
	
	//angular.module('app').directive('modal', modal);

	config.$inject = [ '$routeProvider', '$locationProvider'  ];
	function config($routeProvider, $locationProvider) {
		$routeProvider.when('/', {
			controller : 'HomeController',
			templateUrl : 'partials/home.html',
			controllerAs : 'vm'
		})

		.when('/myaccount', {
			controller : 'AccountController',
			templateUrl : 'partials/myaccount.html',
			//controllerAs : 'vm'
		})
		
		.when('/logout', {
			controller : 'LogoutController'
		})

		.otherwise({
			redirectTo : '/'
		});
	}

	run.$inject = [ '$rootScope', '$location', '$cookieStore', '$http' ];
	function run($rootScope, $location, $cookieStore, $http) {
		// keep user logged in after page refresh
		$rootScope.globals = $cookieStore.get('globals') || {};
		if ($rootScope.globals.currentUser) {
			$http.defaults.headers.common['Authorization'] = 'Basic '
					+ $rootScope.globals.currentUser.authdata; // jshint
																// ignore:line
		}
		
		$rootScope.$on('$locationChangeStart', function(event, next, current) {
			// redirect to login page if not logged in and trying to access a
			// restricted page
			var restrictedPage = $.inArray($location.path(), [ '/login',
					'/register' ]) === -1;
			var loggedIn = $rootScope.globals.currentUser;
			if (restrictedPage && !loggedIn) {
				// $location.path('/login');
				console.log(loggedIn);
			}
			if(loggedIn){
				$rootScope.logouttab = true;
				$rootScope.logintab = false;
				$rootScope.myaccounttab = true;
				$rootScope.registertab = false;
			}else{
				$rootScope.logintab = true;
				$rootScope.registertab = true;
				console.log("logged out");
			}
			
		});
	}

/*	function modal() {	
		return {
			template: '<div class="modal fade">' + 
						'<div class="modial-dialog">' +
							'<div class="modal-content">' +
								'<div class="modal-header">' +
									'<button type="button" class="close" data-dismiss="modal">&times;</button>'+
									'<h4 class="modal-title">{{title}}</h4>' +
								'</div>' +
								'<div class="modal-body" ng-transclude></div>' +
							'</div>' +
						'</div>' +
					  '</div>',
			rescrict: 'E',
			transclude: true,
			replace: true,
			scope: true,
			link: function postLink(scope, element, attrs) {
				scope.title = title;
				
				scope.$watch(attrs.visible, function(value) {
					if(value == true) {
						$(element).modal('show');
					} else {
						$(element).modal('hide');
					}
				});
				
				$(element).on('shown.bs.modal', function () {
					scope.$apply(function() {
						scope.$parent[attrs.visible] = true;
					});
				});
				
				$(element).on('hidden.bs.modal', function () {
					scope.$apply(function() {
						scope.$parent[attrs.visible] = false;
					});
				});
			}
		};
	}*/
})();