//creation de mon service
monApp.factory("blProvider", function ($http){
	
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
	
	//fonction pour rechercher par ID
	function searchById(id, callBack){
		$http.get("http://localhost:8080/Projet_AppSystemeAgence/wsBl/recherche", {params: {pId:id}})
		.then(function successCallback(response){
			callBack(response.data);
		}, function errorCallback(response){
			console.log("erreur : "+response.statusText);
		});
	}
	
	//fonction pour ajouter un bl
	function ajoutBL(blIn, callBack){
		
		for(var i in blIn.photos){
			photo= {
					image: blIn.photos[i].base64
			};
			blIn.listeImages.push(photo)
		}
		
		$http({
			method: "POST",
			url:"http://localhost:8080/Projet_AppSystemeAgence/wsBl/ajout",
			data:angular.toJson(blIn),
			headers:{'Content-Type':'application/json'}	
		}).then(function successCallback(response){
			callBack(response.data);
		}, function errorCallback(response){});
		console.log("erreur : "+response.statusText);
	}
	
	//fonction pour modifier un bl
	function modifBL(blIn, callBack){
		$http({
			method: "PUT",
			url:"http://localhost:8080/Projet_AppSystemeAgence/wsBl/modif",
			data:angular.toJson(blIn),
			headers:{'Content-Type':'application/json'}
		}).then(function successCallback(response){
			callBack(response.data);
		}, function errorCallback(response){});
			console.log("erreur : "+response.statusText);
	}
	
	//fonction pour supprimer un bl
	function supprBL(id, callBack){
		$http({
			method: "DELETE",
			url:"http://localhost:8080/Projet_AppSystemeAgence/wsBl/suppr/"+id,
		}).then(function successCallback(response){
			callBack(response.statusText);
		}, function errorCallback(response){});
			console.log("erreur : "+response.statusText);
	}
	
	//retour de ma fonction factory = un objet
	return {
		getAll: recupListe,
		getID: searchById,
		add: ajoutBL,
		update: modifBL,
		del: supprBL
	}
	
});