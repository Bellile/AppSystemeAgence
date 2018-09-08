/** Provider pour le portail client du client du WS */

//Création du service visiteService

monApp
		.factory(
				"visitePCProvider",
				function($http) {

					// recuperer la liste des visites
					function recupListeVisite(callBack) {
						$http(
								{
									method : "GET",
									url : "http://localhost:8080/Projet_AppSystemeAgence/wsV/liste"
								}).then(function successCallback(response) {
							callBack(response.data);
						}, function errorCallback(response) {
						});

					}

					// recuperer une visite avec son id
					function recupByIdVisite(id, callBack) {
						$http
								.get(
										"http://localhost:8080/Projet_AppSystemeAgence/wsV/recherche",
										{
											params : {
												pId : id
											}
										}).then(
										function successCallback(response) {
											callBack(response.data);

										}, function errorCallback(response) {
										});
					}

					// ajouter une visite
					function ajoutVisite(vIn, callBack) {
						$http(
								{
									method : "POST",
									url : "http://localhost:8080/Projet_AppSystemeAgence/wsV/ajout",
									data : angular.toJson(vIn),
									headers : {
										'Content-Type' : 'application/json'
									}
								}).then(function successCallback(response) {
							callBack(response.data);
						}, function errorCallback(response) {
						});

					}

					// modifier une visite
					function modifVisite(vIn, callBack) {
						$http(
								{
									method : "PUT",
									url : "http://localhost:8080/Projet_AppSystemeAgence/wsV/modif",
									data : angular.toJson(vIn),
									headers : {
										'Content-Type' : 'application/json'
									}
								}).then(function successCallback(response) {

							callBack(response.data);

						}, function errorCallback(response) {
							callBack(response.data);
						});

					}

					// supprimer une visite
					function supprVisite(id, callBack) {
						$http(
								{
									method : "DELETE",
									url : "http://localhost:8080/Projet_AppSystemeAgence/wsV/suppr/"
											+ id
								}).then(function successCallback(response) {

							callBack(response.statusText);

						}, function errorCallback(response) {
							callBack(response.tatusText);
						});
					}
					// le retour de ma fonction factory
					return {
						getAll : recupListeVisite,
						getId : recupByIdVisite,
						add : ajoutVisite,
						update : modifVisite,
						del : supprVisite
					}
				})
