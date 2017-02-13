
//Controlleur de la page qui liste les formations
angular.module('app').controller('formationCtrl', ['$scope', '$routeParams', 'dataFactory',
    function ($scope, $routeParams, dataFactory) {
        $scope.status;
        $scope.formations;
        $scope.formation;
        $scope.codeFormation = $routeParams.codeFormation;
        $scope.error = false;
        $scope.success = false;

        
        function getFormations() {
            dataFactory.getFormations()
                .then(function (response) {
                    $scope.formations = response.data;
                    $scope.error = false;
                }, function (error) {
                    $scope.success = false;
                    $scope.error = true;
                    $scope.status = 'Erreur lors de la récupération de la liste des formations: ' + error.message;
                });
        }

        $scope.updateFormation = function () {
            dataFactory.updateFormation(formation)
                .then(function (response) {
                    $scope.status = 'Mise à jour de la formation effectuée!';
                    this.getFormations();
                    $scope.error = false;
                    $scope.success = true;
                    getFormations();
                }, function (error) {
                    $scope.success = false;
                    $scope.error = true;
                    $scope.status = 'Erreur lors de la mise à jour de la formation: ' + error.message;
                });
        };

        $scope.insertFormation = function () {
            dataFactory.insertCustomer(formation)
                .then(function (response) {
                    $scope.status = 'Insertion de la formation effectuée!';
                    this.getFormations();
                    $scope.error = false;
                    $scope.success = true;
                    getFormations();
                }, function (error) {
                    $scope.success = false;
                    $scope.error = true;
                    $scope.status = 'Erreur lors de l\'insertion de la formation: ' + error.message;
                });
        };

        $scope.deleteFormation = function (codeFormation) {
            dataFactory.deleteFormation(codeFormation)
                .then(function (response) {
                    $scope.status = 'Suppression de la formation effectuée!';
                    $scope.error = false;
                    $scope.success = true;
                    getFormations();
                }, function (error) {
                    $scope.success = false;
                    $scope.error = true;
                    $scope.status = 'Erreur lors de la suppression de la formation:' + error.message;
                });
        };

        $scope.getFormation = function (codeFormation) {
            dataFactory.getFormation(codeFormation)
                .then(function (response) {
                    $scope.formation = response.data;
                    $scope.error = false;
                }, function (error) {
                    $scope.success = false;
                    $scope.error = true;
                    $scope.status = 'Erreur lors de la récupération de la formation ' + error.message;
                });
        };

        $scope.closeAlert = function () {
            $scope.error = false;
            $scope.success = false;
        };

        if($scope.codeFormation)
            $scope.formation = $scope.getFormation($scope.codeFormation);
        else
            getFormations();
    }
]);

angular.module('app')
    .factory('dataFactory', ['$http', function ($http) {

        var urlBase = 'http://localhost:8090/formation';
        var dataFactory = {};

        dataFactory.getFormations = function () {
            return $http.get(urlBase);
        };

        dataFactory.getFormation = function (codeFormation) {
            return $http.get(urlBase + '/' + codeFormation);
        };

        dataFactory.insertFormation = function (formation) {
            return $http.post(urlBase, formation);
        };

        dataFactory.updateFormation = function (formation) {
            return $http.put(urlBase, formation)
        };

        dataFactory.deleteFormation = function (codeFormation) {
            return $http.delete(urlBase + '/' + codeFormation);
        };

        return dataFactory;
    }]);


