angular.module('myApp',[]).controller('sensorsInfoView', ['$scope', 'homeService','$interval', function($scope, homeService, $interval) {
	$scope.data =[];
	
	$scope.init = function (){
		homeService.getAllSensorsInfo().then(function(response) {
			if(response != null) {
				$scope.data = response.sensorsList;
				var dateTime = response.sensorsList[0].dateTime;
				$scope.dateTime = dateTime.dayOfMonth+'/'+dateTime.monthOfYear+'/'+dateTime.year+' '+dateTime.hourOfDay+'h:'+dateTime.minuteOfHour+'p';
			}
		});
	};
	$scope.init();
	$interval(function() {
		$scope.init();
	},10000);
}]);