angular.module('app.controllers', []).controller('AssetListController', function($scope, $state, popupService, $window, Asset) {
  $scope.assets = Asset.query(); //fetch all assets. Issues a GET to /api/vi/assets

  $scope.deleteAsset = function(asset) { // Delete a Asset. Issues a DELETE to /api/v1/assets/:id
    if (popupService.showPopup('Really delete this?')) {
      asset.$delete(function() {
        $scope.assets = Asset.query(); 
        $state.go('assets');
      });
    }
  };
}).controller('AssetViewController', function($scope, $stateParams, Asset) {
  $scope.asset = Asset.get({ id: $stateParams.id }); //Get a single asset.Issues a GET to /api/v1/assets/:id
}).controller('AssetCreateController', function($scope, $state, $stateParams, Asset) {
  $scope.asset = new Asset();  //create new asset instance. Properties will be set via ng-model on UI

  $scope.addAsset = function() { //create a new asset. Issues a POST to /api/v1/assets
    $scope.asset.$save(function() {
      $state.go('assets'); // on success go back to the list i.e. assets state.
    });
  };
}).controller('AssetEditController', function($scope, $state, $stateParams, Asset) {
  $scope.updateAsset = function() { //Update the edited asset. Issues a PUT to /api/v1/assets/:id
    $scope.asset.$update(function() {
      $state.go('assets'); // on success go back to the list i.e. assets state.
    });
  };

  $scope.loadAsset = function() { //Issues a GET request to /api/v1/assets/:id to get a asset to update
    $scope.asset = Asset.get({ id: $stateParams.id });
  };

  $scope.loadAsset(); // Load a asset which can be edited on UI
});
