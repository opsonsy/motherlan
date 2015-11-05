(function () {
    'use strict';
    
    angular
        .module('motherlan', [
            'ngRoute',
            'motherlan.core',
            'motherlan.login',
            'motherlan.signUp',
            'motherlan.forgotpassword'
        ]);
})();   
