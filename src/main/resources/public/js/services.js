angular.module('app.services', []).factory('Asset', function($resource) {
  return $resource('/api/v1/assets/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
