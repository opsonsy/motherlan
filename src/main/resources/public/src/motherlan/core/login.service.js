(function () {
    'use strict';
    
    angular
        .module('motherlan.core')
        .factory('LoginService', LoginSvc);

    function LoginSvc($http, BASE_URL) {
        var loginSvc = this;

        return {
            login: Login
        };

        function Login(loginDetails) {
            $http.post(BASE_URL + '/auth', loginDetails);
        }
    }
})();