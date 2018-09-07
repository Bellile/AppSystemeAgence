//creation de mon service
monApp.factory("proprietaireProvider", function ($http){
	
	//fonction pour recuperer la liste
	function recupListe(callBack){
		$http({
			method: "GET",
			url:"http://localhost:8080/Projet_AppSystemeAgence/wsp/liste"
		}).then(function successCallback(response){
			callBack(response.data);
		}, function errorCallback(response){
			console.log("erreur : "+response.statusText);
		});
	}
	
	//fonction pour rechercher par ID
	function searchById(id, callBack){
		$http.get("http://localhost:8080/Projet_AppSystemeAgence/wsp/recherche", {params: {pId:id}})
		.then(function successCallback(response){
			callBack(response.data);
		}, function errorCallback(response){
			console.log("erreur : "+response.statusText);
		});
	}
	
	//fonction pour ajouter un proprio
	function ajoutProprio(pIn, callBack){
		$http({
			method: "POST",
			url:"http://localhost:8080/Projet_AppSystemeAgence/wsp/ajout",
			data:angular.toJson(pIn),
			headers:{'Content-Type':'application/json'}	
		}).then(function successCallback(response){
			callBack(response.data);
		}, function errorCallback(response){});
		console.log("erreur : "+response.statusText);
	}
	
	//fonction pour modifier un proprio
	function modifProprio(pIn, callBack){
		$http({
			method: "PUT",
			url:"http://localhost:8080/Projet_AppSystemeAgence/wsp/modif",
			data:angular.toJson(pIn),
			headers:{'Content-Type':'application/json'}
		}).then(function successCallback(response){
			callBack(response.data);
		}, function errorCallback(response){});
			console.log("erreur : "+response.statusText);
	}
	
	//fonction pour supprimer un proprio
	function suppr(id, callBack){
		$http({
			method: "DELETE",
			url:"http://localhost:8080/Projet_AppSystemeAgence/wsp/suppr/"+id,
		}).then(function successCallback(response){
			callBack(response.statusText);
		}, function errorCallback(response){});
			console.log("erreur : "+response.statusText);
	}
	
	//retour de ma fonction factory = un objet
	return {
		getAll: recupListe,
		getID: searchById,
		add: ajoutProprio,
		update: modifProprio,
		del: suppr
	}
	
});