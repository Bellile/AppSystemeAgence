monApp
		.factory(
				"clProvider",
				function($http) {

					function recupListe(callback) {
						$http(
								{
									method : "GET",
									url : "http://localhost:8080/Projet_AppSystemeAgence/wsCl/liste"

								}).then(function successCallback(response) {

							callBack(response.data);

						}, function errorCallback(response) {

							console.log("----- erreur" + response.statusText)

						});

					}

					function recupById(id, callback) {

						$http
								.get(
										"http://localhost:8080/Projet_AppSystemeAgence/wsCl/recherche",
										{
											params : {
												"pId" : id
											}
										}).then(
										function successCallback(response) {

											callBack(response.data);

										},
										function errorCallback(response) {

											console.log("----- erreur"
													+ response.statusText)

										});
					}

					function ajout(cIn, callback) {
						$http(
								{
									method : "POST",
									url : "http://localhost:8080/Projet_AppSystemeAgence/wsCl/ajout",
									data : angular.toJson(cIn),
									headers : {
										'Content-type' : 'application/json'
									}
								}).then(function successCallback(response) {

							callBack(response.data);

						}, function errorCallback(response) {

							console.log("----- erreur" + response.statusText)

						});
					}

					function modif(cIn, callback) {
						$http(
								{
									method : "PUT",
									url : "http://localhost:8080/Projet_AppSystemeAgence/wsCl/modif",
									data : angular.toJson(eIn),
									headers : {
										'Content-type' : 'application/json'
									}
								}).then(function successCallback(response) {

							callBack(response.data);

						}, function errorCallback(response) {

							console.log("----- erreur" + response.statusText)

						});
					}

					function suppr(id, callback) {
						$http(
								{
									method : "DELETE",
									url : "http://localhost:8080/Projet_AppSystemeAgence/wsCl/suppr"
											+ id
								}).then(function successCallback(response) {

							callBack(response.data);

						}, function errorCallback(response) {

							console.log("----- erreur" + response.statusText)

						});
					}
					
					
					return { 
						getAll : recupListe,
						getId : recupById,
						add : ajout,
						update : modif,
						del : suppr
					
				}
					
					
					
					

				})
