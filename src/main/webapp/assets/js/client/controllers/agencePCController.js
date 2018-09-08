//Création du controller angularJS de la classe Agence
appClient.controller("findAllACtrl", function ($rootScope, $scope, aPCProvider, $location) {
		//Appel de la fonction affListe de AgenceSrevice
	aPCProvider.getAll(function (info){
			//Stocker les données récupérées de service dans le scope. Ici function = callBack et info = response.data !
			$scope.liste=info;
		});
})