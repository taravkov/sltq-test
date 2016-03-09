'use strict';

angular.module('table', [ 'ngResource' ])

    .factory('TableService', [ '$resource',
        function ($resource) {
            var endpoint = '/employees';

            return $resource(endpoint, { }, {
                readAll: {
                    method: 'GET',
                    url: endpoint + '?lastName=:lastName&firstName=:firstName&middleName=:middleName&position=:position',
                    isArray: true
                }
            });
        }
    ])

    .controller('TableCtrl', ['$scope', 'TableService',
        function ($scope, TableService) {
            $scope.employees = { };

            $scope.search = function () {
                TableService.readAll({
                        lastName: $scope.lastName,
                        firstName: $scope.firstName,
                        middleName: $scope.middleName,
                        position: $scope.position
                    },
                    function (employees) {
                        $scope.employees = employees;
                    },
                    function (error) {
                        // TODO handle errors
                    })
            };

            $scope.search();

            $scope.$watch('lastName', function(val, oldVal) {
                if(val != oldVal) {
                    $scope.search();
                }
            });

            $scope.$watch('firstName', function(val, oldVal) {
                if(val != oldVal) {
                    $scope.search();
                }
            });

            $scope.$watch('middleName', function(val, oldVal) {
                if(val != oldVal) {
                    $scope.search();
                }
            });

            $scope.$watch('position', function(val, oldVal) {
                if(val != oldVal) {
                    $scope.search();
                }
            });

            //$scope.$watch('middleName', function(val, oldVal) {
            //    if(val != oldVal) {
            //        $scope.search();
            //    }
            //});
        }
    ]);