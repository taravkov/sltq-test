'use strict';

var testApp = angular.module('testApp', [ 'ngRoute', 'table', '720kb.datepicker' ]);

testApp.config(function($routeProvider, $locationProvider) {

    $routeProvider
        .when('/table', {
            templateUrl : 'apps/table/table.html',
            controller : 'TableCtrl'
        })

        .when('/login', {
            templateUrl : 'apps/login/login.html'
        })

        .otherwise({redirectTo: '/table'});

    $locationProvider.html5Mode(true);
});