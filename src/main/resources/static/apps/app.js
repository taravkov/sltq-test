'use strict';

var testApp = angular.module('testApp', [ 'ngRoute' ]);

testApp.config(function($routeProvider, $locationProvider) {

    $routeProvider
        //.when('/issues', {
        //    templateUrl : 'apps/issues/issues.html',
        //    controller : 'IssuesCtrl'
        //})
        .when('/login', {
            templateUrl : 'apps/login/login.html'
        })

        .otherwise({redirectTo: '/table'});

    $locationProvider.html5Mode(true);
});