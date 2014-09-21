/**
 * Created with IntelliJ IDEA.
 * User: Nguyen
 * Date: 9/20/14
 * Time: 12:25 PM
 * To change this template use File | Settings | File Templates.
 */
angular.module('cruiseApp', []).controller('LoginCtrl', function ($scope) {




    $scope.showLogin = function(){
        $scope.logForm = false;
        $scope.regForm = true;
    }

    $scope.showRegister = function(){
        $scope.logForm = true;
        $scope.regForm = false;
    }

    $scope.showLogin();
});

