(function(angular) {
  var AppController = function($scope, Item) {
    
	$scope.macDetail = new Item();
      
    $scope.getMacDetails = function(){
    	$scope.macDetail.$save(function(){
           alert('Data Saved successfully');
        }).success(function(data){
            alert(data);
            $scope.macDetail=data;
        });
    };
  };
  
  AppController.$inject = ['$scope', 'Item'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));