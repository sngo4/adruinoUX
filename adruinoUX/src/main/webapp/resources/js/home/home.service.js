angular.module('myApp').factory('homeService',homeService);

function homeService($http) {
	
	function getAllSensorsInfo() {
		var request = $http.get('/adruinoUX/getAllSensorsInfo');
		return request.then(function(response) {
			return response.data;
			}, function(err) {
				console.log(err);
		});
	}
	
	return {
		getAllSensorsInfo: getAllSensorsInfo
	};
}