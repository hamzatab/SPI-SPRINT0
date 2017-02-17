/**
 * Created by DOSI on 16/02/2017.
 */
angular.module('app').controller('signinCtrl', ['$scope', '$location', 'signinFactory',
    function ($scope, $location, signinFactory) {
        $scope.error = false;
        $scope.success = false;

        $scope.login = function(){
            signinFactory.login($scope.user)
                .then(function (response) {
                    $location.path('/accueil');
                    $scope.error = false;
                    $scope.success = true;
                }, function(error){
                    $scope.success = false;
                    $scope.error = true;
                    $scope.status = 'Erreur lors de l\'authentification:' + error.message;
                });
        };

        $scope.disconnect = function(){
            signinFactory.disconnect($scope.user)
                .then(function (response) {
                    console.log("sdfsf");
                    $location.path('/signin');
                    $scope.error = false;
                    $scope.success = true;
                }, function(error){
                    $scope.success = false;
                    $scope.error = true;

                });
        };

        $scope.closeAlert = function () {
            $scope.error = false;
            $scope.success = false;
        };
    }
]);
