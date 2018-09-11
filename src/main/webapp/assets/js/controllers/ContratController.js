//Création du controller angularJS de la classe Contrat
monApp.controller("getAllCoCtrl", function ($rootScope, $scope, coProvider, $location) {
		//Appel de la fonction affListe de ContratSrevice
		coProvider.getAll(function (info){
			//Stocker les données récupérées de service dans le scope. Ici function = callBack et info = response.data !
			$scope.liste=info;
		});
		
		//Fonction appeler à partir du lien dans la liste pour supprimer
		$scope.delLink = function (id) {
			//Appel de la fonction affListe de ContratSrevice
			coProvider.del(id, function (donnee) {
					//Mettre à jour la liste
					//Appel de la fonction affListe de ContratSrevice
					coProvider.getAll(function (info){
					//Stocker les données récupérées de service dans le scope. Ici function = callBack et info = response.data !
					$scope.liste=info;
				});
			})
		}
		
		//initialiser l'Contrat dans rootScope
		$rootScope.coUpdate = {
				id: undefined,
				type: "",
				dateAcquisition: ""
		};
		//Fonction appeler à partir du lien dans la liste pour modifier
		$scope.updLink = function (co) {
			$rootScope.coUpdate=co;
			//rediriger vers la page modifier
			$location.path("modifContrat");
		}
	})
	.controller("addCoCtrl", function ($scope, coProvider, $location) {
		$scope.contrat = {
				type: "",
				dateAcquisition: ""
		};
		$scope.msg="";
		$scope.ajout = function () {
			//Appel de la fonction ajout de ContratSrevice
			coProvider.add($scope.contrat, function(donnee) {
				if (typeof donnee=='object'){
					$scope.msg="";
					//Rediriger vers la page accueil après ajout
					$location.path("listeContrat")
				} else {
					$scope.msg="L'ajout d'un Contrat a échoué"
				}
			});
		}
	})
	.controller("updateCoCtrl", function ($scope, coProvider, $location, $rootScope) {
		if ($rootScope.coUpdate==undefined) {
			$scope.coModif = {
					id: undefined,
					type: "",
					dateAcquisition: ""
			};
		} else {
			$scope.coModif=$rootScope.coUpdate;
		}
		$scope.msg="";
		$scope.modif = function () {
			//Appel de la fonction modif de ContratSrevice
			coProvider.update($scope.coModif, function(donnee) {
				if (typeof donnee=='object'){
					$scope.msg="";
					//Rediriger vers la page accueil après ajout
					$location.path("listeContrat")
				} else {
					$scope.msg="La modification a échoué. Veuillez réessayer !"
				}
			});
		}
	})
	.controller("delCoCtrl", function ($scope, coProvider, $location) {
		$scope.suppr = function (id) {
			//Appel de la fonction rechParId de ContratSrevice
			coProvider.del(id, function (donnee) {
				if (donnee=='OK'){
					$scope.msg="";
					//Rediriger vers la page accueil après ajout
					$location.path("listeContrat")
				} else {
					$scope.msg="La suppression a échoué"
				}
			});
		}
	})
	.controller("getIdCoCtrl", function ($scope, coProvider) {
		$scope.indice=false;
		$scope.msg="";
		$scope.rech = function (id) {
			//Appel de la fonction rechParId de ContratSrevice
			coProvider.getId(id, function (donnee){
				if (typeof donnee=='object'){
					$scope.indice=true;
					$scope.msg="";
					//Stocker les données récupérées de service dans le scope. Ici function = callBack et info = response.data !
					$scope.coOut=donnee;
				} else {
					$scope.indice=false;
					$scope.msg="Le contrat n'existe pas"
				}
			});
		}
	})
	.controller("getRespCoCtrl", function ($scope, coProvider) {
		$scope.indice=false;
		$scope.msg="";
		$scope.rech = function (id) {
			//Appel de la fonction rechParId de ContratSrevice
			coProvider.getResp(id, function (donnee){
				if (typeof donnee=='object'){
					$scope.indice=true;
					$scope.msg="";
					//Stocker les données récupérées de service dans le scope. Ici function = callBack et info = response.data !
					$scope.coOut=donnee;
				} else {
					$scope.indice=false;
					$scope.msg="Il n'y a pas de contrat associés au responsable"
				}
			});
		}
	})