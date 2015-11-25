(function(angular) {
  var AppController = function($scope, Item) {
	  
    $scope.cmtsips = Item.query(function() {});
      
    $scope.tableShow = false;
      
	$scope.macDetail = new Item();
     
    $scope.getMacDetails = function(){
        $scope.messages=null;
    	$scope.macDetail.command = "ALL";
    	$scope.macDetail.$save(function(){
           alert('Data Processing');
        }).then(function(res){
            $scope.tableShow = true;
        }).catch(function(data,status){
             $scope.messages = data;
             $scope.status = status;
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
      
    $scope.clearMacDetails = function(){
    	$scope.macDetail = null;
    	
    };
    
  };

  AppController.$inject = ['$scope', 'Item'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));