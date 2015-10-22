angular.module("motherlan", ["ngRoute", "Login"])
    .config(function config($routeProvider) {
      $routeProvider
        .when('/', {
          templateUrl: 'src/motherlan/login/tmpl/login.html',
          controller: 'LoginCtrl',
          controllerAs: 'main'
        })
          .when('/signup', {
              templateUrl: 'src/motherlan/signup/tmpl/signup.html',
              controller: 'LoginCtrl',
              controllerAs: 'main'
          })

    })
    .service('LoginService', function LoginSvc($http) {
      var loginSvc = this;

      loginSvc.login = function (loginDetails) {
        $http({url: 'http://localhost:9090/auth', method: 'POST', data: loginDetails});
      };
    })
    .service('SignUpService', function SignUpSvc($http) {
      var signup = this;

      signup.signup = function (account) {
        $http({url: 'http://localhost:9090/accounts', method: 'POST', data: account});
      };
    });
