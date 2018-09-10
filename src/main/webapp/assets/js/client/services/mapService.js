//Création du service
appClient.factory("mapProvider", function($http) {
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
	function getLatitudeLongitude(address, callback) {
		$http({
			method: "GET",
			url: "http://maps.google.com/maps/api/geocode/json?address=" + address + "&sensor=false"
		}).then(function successCallback(response) {
			callBack(response.data);
		  }, function errorCallback(response) {
			console.log("Erreur : " + response.statusText);
		});
	}
	//Le retour de ma fonction factory
	return {
		getAll:getListe,
		getCoord: getLatitudeLongitude
	}
})