/**
 * Created with IntelliJ IDEA.
 * User: Nguyen
 * Date: 9/20/14
 * Time: 12:25 PM
 * To change this template use File | Settings | File Templates.
 */
var cruiseApp = angular.module('cruiseApp', ['ui.bootstrap']);
function AccordionDemoCtrl($scope) {
    $scope.oneAtATime = false;

    $scope.groups = [
        {
            title: 'Dynamic Group Header - 1',
            content: 'Dynamic Group Body - 1'
        },
        {
            title: 'Dynamic Group Header - 2',
            content: 'Dynamic Group Body - 2'
        }
    ];

    $scope.items = ['Item 1', 'Item 2', 'Item 3'];

    $scope.addItem = function() {
        var newItemNo = $scope.items.length + 1;
        $scope.items.push('Item ' + newItemNo);
    };

    $scope.status = {
        isFirstOpen: true,
        isFirstDisabled: false
    };
}

