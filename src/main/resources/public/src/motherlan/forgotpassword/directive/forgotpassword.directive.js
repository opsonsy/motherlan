(function () {
    'use strict';

    
    angular
        .module('motherlan.forgotpassword')
        .directive('mlnForgotPassword', mlnForgotPassword);

    function mlnForgotPassword() {
        return {
            templateUrl: 'src/motherlan/forgotpassword/directive/forgotpassword-tpl.html',
            restrict: 'AEC',
            controller: ForgotPasswordCtrl,
            controllerAs: 'vm'
        }
    }

    ForgotPasswordCtrl.$inject = ['ForgotPasswordService'];

    function ForgotPasswordCtrl(ForgotPasswordService) {
        var vm = this;
        vm.message = "";

        vm.submit = function () {
            ForgotPasswordService.submit(vm.email);
            vm.email = "";
            vm.message = "Successful";
        };

    }
    
})();