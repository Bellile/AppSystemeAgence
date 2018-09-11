//creation de mon service
appClient.factory("blPCProvider", function ($http){
	
	//fonction pour recuperer la liste
	function recupListe(callBack){
		$http({
			method: "GET",
			url:"http://localhost:8080/Projet_AppSystemeAgence/wsBl/liste"
		}).then(function successCallback(response){
			callBack(response.data);
		}, function errorCallback(response){
			console.log("erreur : "+response.statusText);
		});
	}
	

	
	//fonction pour rechercher par adresse
	function searchByAdresse(adresse, callBack){
		$http.get("http://localhost:8080/Projet_AppSystemeAgence/wsBl/listeRegion", {params: {pRegion: adresse}})
		.then(function successCallback(response){
			callBack(response.data);
		}, function errorCallback(response){
			console.log("erreur : "+response.statusText);
		});
	}
	
	return {
		getAll : recupListe,
		getAdresse : searchByAdresse
	}
	
	
	
});