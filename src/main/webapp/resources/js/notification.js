/**
 * Created with IntelliJ IDEA.
 * User: Nguyen
 * Date: 9/20/14
 * Time: 12:25 PM
 * To change this template use File | Settings | File Templates.
 */
cruiseApp.controller('UserGroupCtrl', function ($scope, $modal, $log) {
    $scope.open = function (size, userForm) {
        var modalInstance = $modal.open({
            templateUrl: 'listUser.html',
            controller: ModalInstanceCtrl,
            size: size,
            backdrop: 'static',
            windowClass: 'modal-top',
            resolve: {
                userForm: function () {
                    return userForm;
                }
            }
        });
    };
    $scope.message = {};
    $scope.selectUser = function($event, id, name){
        $scope.message.selectedUserId = id;
        $scope.message.ids = null;
        $($event.target).parents('.btn-group').find('.dropdown-toggle').html(name+' <span class="caret"></span>');
    }

    $scope.addSelectedUser = function(ids){
        $scope.message.ids = ids;
        /*$.each(ids, function(idx, row){
        });*/
        $("#myTags").tagit("fill", ids);
    }

    $scope.delete = function () {
        var selected = $('#userGroupTable').bootstrapTable('getSelections');
        var ids = [];
        if(selected && selected.length >0) {
            $.each(selected, function(idx, row){
                if(row.role != 'ADMIN'){
                    ids.push(row.id);
                }
            })
        }
        if(ids.length > 0) {
            bootbox.confirm("Are  you sure you want to remove it", function(result) {
                if(result) {
                    $.ajax({
                        type: "GET",
                        url: 'deleteUser.json',
                        data: {
                            ids: ids.join(',')
                        },
                        dataType: 'json'
                    })
                    .done(function(data) {
                        $('#userGroupTable').bootstrapTable('refresh');
                    })
                    .fail(function() {

                    });
                }
            });
        }
    };

    $("#myTags").tagit({
        triggerKeys: ['enter', 'tab']
    });
});

var ModalInstanceCtrl = function ($scope, $modalInstance, $http, userForm) {
    //attach reference here
    var prSscope = angular.element('[ng-controller=UserGroupCtrl]').scope();
    prSscope.modalInstanceCtrlScope = $scope;
    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };

    $scope.addUser = function () {
        var selected = $('#userTable').bootstrapTable('getSelections');
        var ids = [];
        if(selected && selected.length >0) {
            $.each(selected, function(idx, row){
                ids.push({label: row.userName, value:row.id});
            });
            prSscope.addSelectedUser(ids);
            $scope.cancel();
        } else {
            bootbox.alert("Please select user");
        }

    };

    $scope.filterItemSelect = function($event, id, name){
        $scope.filterId = id;
        $($event.target).parents('.btn-group').find('.dropdown-toggle').html(name+' <span class="caret"></span>');
        //trigger refesh table
        $('#userTable').bootstrapTable('refresh');
    }

    //init table
    setTimeout(function(){$('#userTable').bootstrapTable({
        url: 'listUser.json'
    })}, 100);


};

function operateFormatter(value, row, index) {
    if(row.role === 'ADMIN'){
        return [
            '<a class="edit pdr-10" href="javascript:void(0)" title="Edit">',
            '<i class="glyphicon glyphicon-edit" ></i>',
            '</a>'
        ].join('');
    } else {
        return [
            '<a class="edit pdr-10" href="javascript:void(0)" title="Edit">',
            '<i class="glyphicon glyphicon-edit" ></i>',
            '</a>',
            '<a class="remove ml10" href="javascript:void(0)" title="Remove">',
            '<i class="glyphicon glyphicon-remove"></i>',
            '</a>'
        ].join('');
    }
}

window.operateEvents = {
    'click .edit': function (e, value, row, index) {
        console.log(value, row, index);
        var scope = angular.element('[ng-controller=UserGroupCtrl]').scope();
        delete row.regDate;
        delete row.modDate;
        scope.open(null, row);
    },
    'click .remove': function (e, value, row, index) {
        bootbox.confirm("Are  you sure you want to remove it", function(result) {
            if(result) {
                $.ajax({
                    type: "GET",
                    url: 'deleteUser.json',
                    data: {
                        ids: row.id
                    },
                    dataType: 'json'
                })
                .done(function(data) {
                    $('#userGroupTable').bootstrapTable('refresh');
                })
                .fail(function() {

                });
            }
        });
    }
};

function queryParams(params) {
    var scope = angular.element('[ng-controller=UserGroupCtrl]').scope();
    return {
        limit: params.pageSize,
        offset: params.pageSize * (params.pageNumber - 1),
        search: params.searchText,
        name: params.sortName,
        order: params.sortOrder,
        filterId: scope.filterId
    };
}

function queryUserParams(params) {
    var scope = angular.element('[ng-controller=UserGroupCtrl]').scope().modalInstanceCtrlScope;
    return {
        limit: params.pageSize,
        offset: params.pageSize * (params.pageNumber - 1),
        search: params.searchText,
        name: params.sortName,
        order: params.sortOrder,
        filterId: scope.filterId
    };
}

function rowStyle(row, index) {
    if(row.role === 'ADMIN') {
        return {
            classes: 'danger'
        };
    }
    if (index % 2 === 0) {
        return {
            classes: 'active'
        };
    }
    return {};
}

$(function () {
    setTimeout(function(){$('#userGroupTable').bootstrapTable({
        url: 'listUser.json'
    })}, 100);
});
