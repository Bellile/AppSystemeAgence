//Creation du service classeStandardService

monApp
		.factory(
				"classeStandardProvider",
				function($http) {

					// recuperer la liste des CS
					function recupListeCS(callBack) {
						$http(
								{
									method : "GET",
									url : "http://localhost:8080/Projet_AppSystemeAgence/wsCS/liste"
								}).then(function successCallback(response) {
							callBack(response.data);
						}, function errorCallback(response) {
						});

					}

					// recuperer une CS avec son id
					function recupByIdCS(id, callBack) {
						$http
								.get(
										"http://localhost:8080/Projet_AppSystemeAgence/wsCS/recherche",
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
					function ajoutCS(csIn, callBack) {
						$http(
								{
									method : "POST",
									url : "http://localhost:8080/Projet_AppSystemeAgence/wsCS/ajout",
									data : angular.toJson(csIn),
									headers : {
										'Content-Type' : 'application/json'
									}
								}).then(function successCallback(response) {
							callBack(response.data);
						}, function errorCallback(response) {
						});

					}

					// modifier une ClasseStandard
					function modifCS(csIn, callBack) {
						$http(
								{
									method : "PUT",
									url : "http://localhost:8080/Projet_AppSystemeAgence/wsCS/modif",
									data : angular.toJson(csIn),
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
					function supprCS(id, callBack) {
						$http(
								{
									method : "DELETE",
									url : "http://localhost:8080/Projet_AppSystemeAgence/wsCS/suppr/"
											+ id
								}).then(function successCallback(response) {

							callBack(response.statusText);

						}, function errorCallback(response) {
							callBack(response.tatusText);
						});
					}
					// le retour de ma fonction factory
					return {
						getAll : recupListeCS,
						getId : recupByIdCS,
						add : ajoutCS,
						update : modifCS,
						del : supprCS
					}
				})
