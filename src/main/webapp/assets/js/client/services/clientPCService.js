

appClient.factory("clPCProvider", function($http) {

function ajout(cIn, callBack) {
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

return {
	add:ajout
	
}
});