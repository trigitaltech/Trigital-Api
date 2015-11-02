(function(angular) {
  var AppController = function($scope, Item) {
    $scope.events  = [
                        {name:'Kamla_cmts01',ip_Address:'125.99.127.30',cmts_make:'Cisco10K'},
                        {name:'Kamla_cmts02',ip_Address:'125.99.127.31',cmts_make:'CASA'}
                     ];
    
	$scope.macDetail = new Item();
      
    $scope.getMacDetails = function(){
    	$scope.macDetail.command = "ALL";
    	$scope.macDetail.$save(function(){
           alert('Data Saved successfully');
        }).success(function(data){
            $scope.macDetail=data;
        });
    };
      
      $scope.reset= function(){
    	$scope.macDetail.command = "RESET";
    	$scope.macDetail.$save(function(){
           alert('Data Saved successfully');
        }).success(function(data){
            $scope.macDetail=data;
        });
    };
  };

  AppController.$inject = ['$scope', 'Item'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));