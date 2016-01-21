(function(angular) {
  var AppController = function($scope, Item) {
	  
    $scope.cmtsips = Item.query(function() {});
      
    $scope.tableShow = false;
    $scope.disableTextBox = false;
	$scope.macDetail = new Item();
     
    $scope.getMacDetails = function(){
        $scope.messages=null;
    	$scope.macDetail.command = "ALL";
    	$scope.macDetail.$save(function(){
           
        }).then(function(res){
            $scope.tableShow = true;
            $scope.disableTextBox = true;
            console.log($scope.disableTextBox);
            console.log($scope.tableShow);
            
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
    	$scope.macDetail = new Item();
    	$scope.tableShow = false;
    	$scope.disableTextBox = false;
    	$scope.disableTextBox = false;
    	alert('Successfully Cleared');
    	
    };
    
  };

  AppController.$inject = ['$scope', 'Item'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));