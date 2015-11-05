(function () {
    'use strict';

    angular
        .module('motherlan.signUp')
        .controller("SignUpCtrl", SignUpController);
    
    SignUpController.$inject = ['SignUpService', '$log'];


    function SignUpController(SignUpService, $log) {
        var vm = this;

        vm.account = {};

        vm.signUp = function() {
            SignUpService.signUp(vm.account);
            vm.account = {};
        };

        $log.info('do I load?', vm);
    }
})();