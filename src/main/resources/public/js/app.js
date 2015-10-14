var motherlan = angular.module('motherlan', []);
motherlan.controller('MainCtrl', function MainCtrl(loginSvc) {
  var main = this;

  main.account = {
    firstName: 'firstName',
    lastName: 'lastName',
    gender: 'M',
    age: 22,
    password: 'somePwd',
    email: 'a@b.com'
  };

  main.loginDetails = {}

  main.login = function() {
    loginSvc.login(main.loginDetails)
  }
});

motherlan.service('loginSvc', function LoginSvc($http) {
  var loginSvc = this;

  loginSvc.login = function (loginDetails) {
    $http({url: 'http://localhost:9090/login', method: 'POST', data: loginDetails});
  };
});

motherlan.service('signup', function SignUpSvc($http) {
  var signup = this;

  signup.signup = function (account) {
    $http({url: 'http://localhost:9090/accounts', method: 'POST', data: account});
  };
});
