var app = angular.module('myRegistration', []);
app.controller('FormCtrl', function ($scope, $http) {

    var formData = {
        Gender: "default",
        firstname: "default",
        lastname: "default",
        email: "default",
        mobile: "default",
        dateInput: "default",
        Idtype: "default",
        identitynumber: "default",
        IdAddress: "default",
        CorrespondenceAddress: "default",
        beneficiaries: "default"
    };

    $scope.save = function() {
        formData = $scope.form;
        console.log (formData);
    };

    $scope.submitForm = function() {
        console.log("posting data....");
        formData = $scope.form;
        console.log(formData);

        //uncomment below lines for posting the data
        $http.post('http://78.129.143.143:8080/FwdSample/user/register', JSON.stringify(formData)).success(function(){
            alert("success");
        }).error(function(error){
            //$scope.error = error;
            alert(error);
        });
    };

});