(function () {
    'use strict';
    
    angular
        .module('motherlan.core')
        .factory('ReqResInterceptor', ReqResInterceptor);

    function ReqResInterceptor($log) {
        var interceptor = {
            request: function (config) {
                $log.info("Sending request");
                console.log("sending request " + config);
                return config;
            },
            response: function(response) {
                $log.info("Sending response " + response);
                console.log("Sending response " + response);
                return response;
            }
        };

        return interceptor;
    }
})();