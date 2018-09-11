//Création du service Agence à partir du webservice
monApp.factory("coProvider", function($http) {
	//Methode recupération de la liste
	function affListe (callBack) {
		$http({
			method: "GET",
			url: "http://localhost:8080/Projet_AppSystemeAgence/wsCo/liste"
		}).then(function successCallback(response) {
			callBack(response.data);
		  }, function errorCallback(response) {
			console.log("Erreur : " + response.statusText);
		  });
	}
	
	function rechParId(id, callBack) {
		//Récupération de la recherche à partir du serveur
		$http.get("http://localhost:8080/Projet_AppSystemeAgence/wsCo/recherche", {params:{pId: id}})
			.then(function successCallback(response) {
			callBack(response.data);
		  }, function errorCallback(response) {
			console.log("Erreur : " + response.statusText);
		  });
	}
	
	function ajout(aIn, callBack) {
		//Récupération de la méthode ajout à partir du serveur
		$http({
			method: "POST",
			url: "http://localhost:8080/Projet_AppSystemeAgence/wsCo/ajout",
			data: angular.toJson(aIn),
			headers:{'Content-Type': 'application/json'}
		}).then(function successCallback(response) {
				callBack(response.data);
			}, function errorCallback(response) {
				console.log("Erreur : " + response.statusText);
			});
	}
	
	function modif(aIn, callBack) {
		//Récupération de la méthode ajout à partir du serveur
		$http({
			method: "PUT",
			url: "http://localhost:8080/Projet_AppSystemeAgence/wsCo/modif",
			data: angular.toJson(aIn),
			headers:{'Content-Type': 'application/json'}
		}).then(function successCallback(response) {
				callBack(response.data);
			}, function errorCallback(response) {
				console.log("Erreur : " + response.statusText);
				callBack(response.data);
			});
	}
	
	function suppr(id, callBack) {
		//Récupération de la méthode ajout à partir du serveur
		$http({
			method: "DELETE",
			url: "http://localhost:8080/Projet_AppSystemeAgence/wsCo/suppr/"+id,
		}).then(function successCallback(response) {
				callBack(response.statusText);
			}, function errorCallback(response) {
				console.log("Erreur : " + response.statusText);
			});
	}
	
	function rechParResponsable(id, callBack) {
		//Récupération de la recherche à partir du serveur
		$http.get("http://localhost:8080/Projet_AppSystemeAgence/wsCo/recherche", {params:{pId: id}})
			.then(function successCallback(response) {
			callBack(response.data);
		  }, function errorCallback(response) {
			console.log("Erreur : " + response.statusText);
		  });
	}
	
	//Le retour de ma fonction factory
	return {
		getAll:affListe,
		getId:rechParId,
		add:ajout,
		update:modif,
		del:suppr
	}
})