angular.module("Login", [])
  .controller("LoginCtrl", LoginController);

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
