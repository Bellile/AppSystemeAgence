//creation de mon service
monApp.factory("bvProvider", function ($http){
	
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
	
	//fonction pour rechercher par ID
	function searchById(id, callBack){
		$http.get("http://localhost:8080/Projet_AppSystemeAgence/wsBv/recherche", {params: {pId:id}})
		.then(function successCallback(response){
			callBack(response.data);
		}, function errorCallback(response){
			console.log("erreur : "+response.statusText);
		});
	}
	
	//fonction pour ajouter un bv
	function ajoutBV(bvIn, callBack){
		
		bvIn.listeImage=bvIn.listeImage.base64;
		$http({
			method: "POST",
			url:"http://localhost:8080/Projet_AppSystemeAgence/wsBv/ajout",
			data:angular.toJson(bvIn),
			headers:{'Content-Type':'application/json'}	
		}).then(function successCallback(response){
			callBack(response.data);
		}, function errorCallback(response){});
		console.log("erreur : "+response.statusText);
	}
	
	//fonction pour modifier un bv
	function modifV(bvIn, callBack){
		$http({
			method: "PUT",
			url:"http://localhost:8080/Projet_AppSystemeAgence/wsBv/modif",
			data:angular.toJson(bvIn),
			headers:{'Content-Type':'application/json'}
		}).then(function successCallback(response){
			callBack(response.data);
		}, function errorCallback(response){});
			console.log("erreur : "+response.statusText);
	}
	
	//fonction pour supprimer un bv
	function supprBV(id, callBack){
		$http({
			method: "DELETE",
			url:"http://localhost:8080/Projet_AppSystemeAgence/wsBv/suppr/"+id,
		}).then(function successCallback(response){
			callBack(response.statusText);
		}, function errorCallback(response){});
			console.log("erreur : "+response.statusText);
	}
	
	//retour de ma fonction factory = un objet
	return {
		getAll: recupListe,
		getID: searchById,
		add: ajoutBV,
		update: modifBV,
		del: supprBV
	}
	
});