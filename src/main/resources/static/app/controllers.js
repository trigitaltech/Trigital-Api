(function(angular) {
  var AppController = function($scope, Item) {
    $scope.events  = [
                        {name:'Kamla_cmts01',ip_Address:'125.99.127.30',cmts_make:'Cisco10K'},
                        {name:'Kamla_cmts02',ip_Address:'125.99.127.31',cmts_make:'CASA'}
                     ];
      
    $scope.cmtsips = Item.query(function() {
        alert('Get is being call First')
    });
      
    $scope.tableShow = false;
      
	$scope.macDetail = new Item();
     
    $scope.getMacDetails = function(){
    	$scope.macDetail.command = "ALL";
    	$scope.macDetail.$save(function(){
           alert('Data Processing');
        }).then(function(res){
            $scope.tableShow = true;
        });
    	
    };
      
      $scope.reset= function(){
    	$scope.macDetail.command = "RESET";
    	$scope.macDetail.$save(function(){
           alert('Data Processing');
        }).success(function(data){
            $scope.macDetail=data;
        });
    };
    
  };

  AppController.$inject = ['$scope', 'Item'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));