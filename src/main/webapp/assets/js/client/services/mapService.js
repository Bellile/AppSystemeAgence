//Création du service
appClient.factory("mapProvider", function($http) {

	//Methode récupération de la liste
	function getListeBl (callBack) {
		$http({
			method: "GET",
			url: "http://localhost:8080/Projet_AppSystemeAgence/wsBl/liste"
		}).then(function successCallback(response) {
			callBack(response.data);
		  }, function errorCallback(response) {
			console.log("Erreur : " + response.statusText);
		});
	}
	
	function getListeBv(callBack){
		$http({
			method: "GET",
			url:"http://localhost:8080/Projet_AppSystemeAgence/wsBv/liste"
		}).then(function successCallback(response){
			callBack(response.data);
		}, function errorCallback(response){
			console.log("erreur : "+response.statusText);
		});
	}
	

	//Le retour de ma fonction factory
	return {
		getAllBl: getListeBl,
		getAllBv: getListeBv
	}
})