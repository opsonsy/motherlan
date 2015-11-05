(function () {
    'use strict';
    
    angular
        .module('motherlan.core')
        .config(configure);
    
    configure.$inject = ['$routeProvider', '$httpProvider', '$provide'];

    function configure($routeProvider, $httpProvider, $provide) {
        $routeProvider
            .when('/login', {
                templateUrl: 'src/motherlan/login/login.html'
            })
            .when('/signup', {
                templateUrl: 'src/motherlan/signup/signup.html',
                controller: 'SignUpCtrl',
                controllerAs: 'vm'
            })
            .when('/', {
                templateUrl: 'src/motherlan/home/default.html'
            })
            .otherwise({redirectTo: '/'});

        $httpProvider.interceptors.push('ReqResInterceptor');

        $provide.decorator('$log', function ($delegate) {
            var infoFn = $delegate.info;

            $delegate.info = function () {
                arguments[arguments.length - 1] = arguments[arguments.length - 1] + " - Decorated log";
                infoFn.apply(null, arguments);
            };

            return $delegate;
        });
    }
})();