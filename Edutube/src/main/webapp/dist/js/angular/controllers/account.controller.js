'use strict';
angular.module('app').controller('AccountController', AccountController);
AccountController.$inject = [ 'UserService', '$location', '$rootScope',
		'FlashService', '$resource', '$http', '$scope', '$cookieStore', '$uibModal' ];
function AccountController(UserService, $location, $rootScope, FlashService,
		$resource, $http, $scope, $cookieStore, $uibModal) {
	var obj = $cookieStore.get('globals');
	
	$scope.message = "hello"
	
	$http({
		url : "/Edutube/user/viewUserContact",
		method : 'GET',
		params : {
			userId : obj.currentUser.userId
		},
		headers : {
			'Content-Type' : 'application/json'
		},

	}).success(function(response) {
		console.log(response);
		
		$scope.userData = response;
		
	}).error(function(error) {
		alert("oops!! something went wrong, please try agin!!");
	});
	
	$scope.showChangeProfilePicModal = function () {
		var modalInstance = $uibModal.open({
			size : 'sm',
			templateUrl : '/change-profile-picture-modal'
		});
	}
	
	$scope.showChangeLocationModal = function () {
		var modalInstance = $uibModal.open({
			size : 'sm',
			templateUrl : '/change-location-modal.html'
		});
	}
	
	$scope.showChangeAddressModal = function () {
		var modalInstance = $uibModal.open({
			size : 'sm',
			templateUrl : '/change-address-modal.html'
		});
	}
	
	$scope.showChangeAboutModal = function () {
		var modalInstance = $uibModal.open({
			size : 'sm',
			templateUrl : '/change-about-modal.html'
		});
	}
	
	$scope.showChangeSubjectDetailsModal = function () {
		var modalInstance = $uibModal.open({
			size : 'sm',
			templateUrl : '/change-subject-details-modal.html'
		});
	}
	
	$scope.showChangeEducationDetailsModal = function () {
		var modalInstance = $uibModal.open({
			size : 'sm',
			templateUrl : '/change-education-details-modal.html'
		});
	}
	
	$scope.showChangeWorkExperienceModal = function () {
		var modalInstance = $uibModal.open({
			size : 'sm',
			templateUrl : '/change-work-exp-modal.html'
		});
	}
	
	

}
