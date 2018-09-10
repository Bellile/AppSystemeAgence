//Création du service
appClient.factory("mapProvider", function($http) {
	
	var geoURL = 'https://maps.googleapis.com/maps/api/geocode/json?address=';

	//Methode récupération de la liste
	function getListe (callBack) {
		$http({
			method: "GET",
			url: "http://localhost:8080/Projet_AppSystemeAgence/wsBl/liste"
		}).then(function successCallback(response) {
			callBack(response.data);
		  }, function errorCallback(response) {
			console.log("Erreur : " + response.statusText);
		});
	}
	function getLatitudeLongitude(address, callBack) {
		$http({
			method: "GET",
			url: "http://maps.google.com/maps/api/geocode/json?address=" + address + "&sensor=false"
			
		}).then(function successCallback(response) {
			callBack(response.data);
		  }, function errorCallback(response) {
			console.log("Erreur : " + response.statusText);
		});
	}
	
	function localiserAdresse(rue, codePostal, ville, calback) {
		$http(
				{
					method : 'GET',
					url : geoURL
							+ rue
							+ ', '
							+ codePostal
							+ ' '
							+ ville
							+ '&key=AIzaSyDy1ZKI7FhtHYJx8VEB0GQyjcUoxc2nwy4'
				}).then(
				function successCalback(response) {
					console.log(response.data);
					calback(response.data);
				},
				function echecCalback(response) {
					console.log("erreur : " + response.status
							+ " " + response.statusText);
				});
	}
	//Le retour de ma fonction factory
	return {
		getAll:getListe,
		getCoord: getLatitudeLongitude
	}
})