(function () {
    'use strict';

    //Déclaration de l'application AngularJS
    angular.module(
        'app',
        ['ngRoute', 'ngAnimate', 'ui.bootstrap', 'easypiechart',
            'mgo-angular-wizard', 'textAngular', 'ui.tree',
            'ngTagsInput']).config(
        ['$routeProvider', function ($routeProvider, $urlRouterProvider) { }]
        );

    //Déclaration des routes
    angular.module('app').config(['$routeProvider',
        function ($routeProvider) {
            // Système de routage
            $routeProvider
                .when('/accueil', {
                    templateUrl: '/views/accueil.html',
                    controller: 'accueilCtrl'
                })
                .when('/formations', {
                    templateUrl: '/views/formations.html',
                    controller: 'formationCtrl'
                })
                .when('/formation/:codeFormation', {
                    templateUrl: '/views/formationDetails.html',
                    controller: 'formationCtrl'
                })
                .otherwise({
                    redirectTo: '/accueil'
                });
        }
    ]);

}).call(this);

