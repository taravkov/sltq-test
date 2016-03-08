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

            $scope.init = function () {
                TableService.readAll({ },
                    function (employees) {
                        $scope.employees = employees;
                    },
                    function (error) {
                        // TODO handle errors
                    })
            };

            $scope.init();
        }
    ]);