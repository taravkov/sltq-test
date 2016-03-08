'use strict';

angular.module('table', [ 'ngResource' ])

    .factory('TableService', [ '$resource',
        function ($resource) {
            var endpoint = '/employees';

            return $resource(endpoint, { }, {
                readAll: {
                    method: 'GET',
                    url: endpoint,
                    isArray: true
                }
            });
        }
    ])

    .controller('TableCtrl', ['$scope', 'TableService',
        function ($scope, TableService) {
            $scope.employees = { };

            $scope.search = function () {
                TableService.readAll({ },
                    function (employees) {
                        $scope.employees = employees;
                    },
                    function (error) {
                        // TODO handle errors
                    })
            };

            $scope.search();

            $scope.$watch('lastName', function(val, oldVal) {
                if(val && val != oldVal) {
                    $scope.search();
                }
            });

            $scope.$watch('firstName', function(val, oldVal) {
                if(val && val != oldVal) {
                    $scope.search();
                }
            });

            $scope.$watch('middleName', function(val, oldVal) {
                if(val && val != oldVal) {
                    $scope.search();
                }
            });
        }
    ]);