angular.module('app')
    .factory('signinFactory', ['$http', function ($http) {

        var urlBase = 'http://localhost:8090/';
        var signinFactory = {};

        signinFactory.login = function (user) {
            return $http.post(urlBase + 'auth', user);
        };

        signinFactory.getUser = function (user) {
            return $http.get(urlBase + 'user' , user);
        };

        signinFactory.disconnect = function (user) {
            return $http.get(urlBase + 'disconnect' , user);
        };

        return signinFactory;
    }]);
