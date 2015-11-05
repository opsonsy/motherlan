(function () {
    'use strict';
    
    angular
        .module('motherlan.core')
        .factory('AccountsModel', AccountsSvc);

    function AccountsSvc($http, BASE_URL) {
        var service = this;

        return {
            all: all    
        };
        
        function all() {
            return $http.get(BASE_URL + '/accounts')
                        .then(function (result) {
                            return result;
                        });
        }
    }
})();