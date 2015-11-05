(function () {
    'use strict';
    
    angular
        .module('motherlan.core')
        .factory('ForgotPasswordService', forgotPasswordService);
    
    function forgotPasswordService($http, BASE_URL) {
        
        return {
          submit: resetPassword  
        };
        
        function resetPassword(email) {
            $http.post(BASE_URL + '/reset', email)
        }
    }
})();