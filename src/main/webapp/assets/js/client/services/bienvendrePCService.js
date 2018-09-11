//creation de mon service
appClient.factory("bvPCProvider", function ($http){
	
	//fonction pour recuperer la liste
	function recupListe(callBack){
		$http({
			method: "GET",
			url:"http://localhost:8080/Projet_AppSystemeAgence/wsBv/liste"
		}).then(function successCallback(response){
			callBack(response.data);
		}, function errorCallback(response){
			console.log("erreur : "+response.statusText);
		});
	}
	return {
		getAll : recupListe
	}
	
	//fonction pour rechercher par ID
	function searchByAdresse(adresse, callBack){
		$http.get("http://localhost:8080/Projet_AppSystemeAgence/wsBv/listeRegion", {params: {pRegion:adresse}})
		.then(function successCallback(response){
			callBack(response.data);
		}, function errorCallback(response){
			console.log("erreur : "+response.statusText);
		});
	}
	
});