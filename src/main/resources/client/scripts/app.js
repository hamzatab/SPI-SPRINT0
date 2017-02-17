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
                    templateUrl: '/views/accueil.html'
                })
                .when('/formations', {
                    templateUrl: '/views/formations.html',
                    controller: 'formationCtrl'
                })
                .when('/formation/:codeFormation', {
                    templateUrl: '/views/formationDetails.html',
                    controller: 'formationCtrl'
                })
                .when('/edit/:codeFormation', {
                    templateUrl: '/views/edit.html',
                    controller: 'formationCtrl'
                })
                .when('/addformation', {
                templateUrl: '/views/addformation.html',
                controller: 'formationCtrl'
                }).when('/signin',{
                templateUrl: '/views/signin.html',
                notLoggedNeeded : true
                }).when('/signup',{
                templateUrl: '/views/signup.html',
                notLoggedNeeded : true
                }).otherwise({
                    redirectTo: '/accueil'
                });
        }
    ]).run(function ($rootScope, $route, $location, signinFactory) {
        $rootScope.$on("$routeChangeStart", function (event, to) {
            if (to.notLoggedNeeded) {
                console.log("NOT LOGGED");
                return;
            }
            else {
                signinFactory.getUser().success(function (data) {
                    if (data) {
                        event.preventDefault();
                    } else {
                        $location.path("/signin");
                    }
                });
            }
        });
    });

}).call(this);

