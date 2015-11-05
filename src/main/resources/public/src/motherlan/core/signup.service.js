(function () {
    'use strict';
    
    angular
        .module('motherlan.core')
        .factory('SignUpService', SignUpSvc);

    function SignUpSvc($http, BASE_URL) {
        var svc = this;

        return {
          signUp: createNewAccount  
        };
        
        function createNewAccount(account) {
            $http.post(BASE_URL + '/accounts', account);
        }
    } 
})();