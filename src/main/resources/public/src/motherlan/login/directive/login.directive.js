angular.module('motherlan.login')
    .directive('mlnLogin', function () {
        return {
            templateUrl: 'src/motherlan/login/directive/login-tpl.html',
            restrict: 'AEC',
            controller: 'LoginCtrl',
            controllerAs: 'main'
        } 
    });