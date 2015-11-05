(function () {
    'use strict';

    angular
        .module('motherlan.login')
        .controller("LoginCtrl", LoginController);

    LoginController.$inject = ['LoginService'];
    
    function LoginController(LoginService) {
        var main = this;

        main.account = {
            firstName: 'firstName',
            lastName: 'lastName',
            gender: 'M',
            age: 22,
            password: 'somePwd',
            email: 'a@b.com'
        };

        main.loginDetails = {};

        main.login = function() {
            LoginService.login(main.loginDetails)
        };

    }
})();