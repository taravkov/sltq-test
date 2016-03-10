'use strict';

angular.module('table', [ 'ngResource' ])

    .factory('TableService', [ '$resource',
        function ($resource) {
            var endpoint = '/employees';

            return $resource(endpoint, { }, {
                readAll: {
                    method: 'GET',
                    url: endpoint + '?lastName=:lastName&firstName=:firstName&middleName=:middleName' +
                    '&position=:position&birthdayFrom=:birthdayFrom&birthdayTo=:birthdayTo',
                    isArray: true
                }
            });
        }
    ])

    .controller('TableCtrl', ['$scope', 'TableService', 'Flash',
        function ($scope, TableService, Flash) {
            $scope.employees = { };

            $scope.search = function () {
                TableService.readAll({
                        lastName: $scope.lastName,
                        firstName: $scope.firstName,
                        middleName: $scope.middleName,
                        position: $scope.position,
                        birthdayFrom: $scope.birthdayFrom,
                        birthdayTo: $scope.birthdayTo
                    },
                    function (employees) {
                        $scope.employees = employees;
                    },
                    function (error) {
                        Flash.create('danger', error.data.message);
                    })
            };

            $scope.search();
            $scope.birthdayFrom = '01.01.1970';
            $scope.birthdayTo = '01.01.2000';

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

            $scope.$watch('birthdayFrom', function(val, oldVal) {
                if(val != oldVal) {
                    $scope.search();
                }
            });

            $scope.$watch('birthdayTo', function(val, oldVal) {
                if(val != oldVal) {
                    $scope.search();
                }
            });
        }
    ]);