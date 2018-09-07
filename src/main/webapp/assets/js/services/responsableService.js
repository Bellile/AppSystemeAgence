// création de mon service
monApp.factory("responsableProvider", function($http) {
	// récupérer la liste du serveur
	function recupListe(callBack) {
		// récupérer la liste à partir du serveur
		$http({
			method : "GET",
			url : "http://localhost:8080/Projet_AppSystemeAgence/wsResp/liste"
		}).then(function successCallback(response) {
			// stocker les données dans la callBack afin des les tranférer au
			// controller de manière asynchrone
			callBack(response.data);
		}, function errorCallback(response) {

		});

	}

	// récupérer le responsable par l'ID
	function recherche(id, callBack) {
		
		$http.get("http://localhost:8080/Projet_AppSystemeAgence/wsResp/recherche",
				{params : {pId : id}})
				.then(function successCallback(response) {
			// stocker les données dans la callBack afin des les tranférer au controller de manière asynchrone
			callBack(response.data);
		}, function errorCallback(response) {
		});
	}
	

	function ajout(rIn,callBack) {
		
		$http({
			method : "POST",
			url : "http://localhost:8080/Projet_AppSystemeAgence/wsResp/ajout",
			data:angular.toJson(rIn),
			headers: {'Content-Type':'application/json'}
		}).then(function successCallback(response) {
			// stocker les données dans la callBack afin des les tranférer au
			// controller de manière asynchrone
			callBack(response.data);
		}, function errorCallback(response) {
		});
	}
	

	function modif(rIn,callBack) {
		// récupérer la liste à partir du serveur
		$http({
			method : "PUT",
			url : "http://localhost:8080/Projet_AppSystemeAgence/wsResp/modif",
			data:angular.toJson(rIn),
			headers: {'Content-Type':'application/json'}
		}).then(function successCallback(response) {
			// stocker les données dans la callBack afin des les tranférer au
			// controller de manière asynchrone
			callBack(response.data);
		}, function errorCallback(response) {
		});
	}
	
	
	function suppr(id,callBack) {
		
		$http({
			method : "DELETE",
			url : "http://localhost:8080/Projet_AppSystemeAgence/wsResp/suppr/" + id
		
		}).then(function successCallback(response) {
			// stocker les données dans la callBack afin des les tranférer au
			// controller de manière asynchrone
			callBack(response.statusText);
		}, function errorCallback(response) {
			callBack(response.statusText);
		});
	}
	
	
	// le retour de la fonction factory
	return {
		getAll : recupListe,
		getId : recherche,
		add:ajout,
		update:modif,
		del:suppr
	}
})