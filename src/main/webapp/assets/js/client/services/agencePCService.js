//Création du service Agence à partir du webservice
appClient.factory("aPCProvider", function($http) {
	//Methode recupération de la liste
	function affListe (callBack) {
		$http({
			method: "GET",
			url: "http://localhost:8080/Projet_AppSystemeAgence/wsA/liste"
		}).then(function successCallback(response) {
			callBack(response.data);
		  }, function errorCallback(response) {
			console.log("Erreur : " + response.statusText);
		  });
	}
});