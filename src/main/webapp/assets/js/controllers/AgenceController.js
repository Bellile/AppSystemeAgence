//Création du controller angularJS de la classe Agence
monApp.controller("getAllACtrl", function ($rootScope, $scope, aProvider, $location) {
		//Appel de la fonction affListe de AgenceSrevice
		aProvider.getAll(function (info){
			//Stocker les données récupérées de service dans le scope. Ici function = callBack et info = response.data !
			$scope.liste=info;
		});
		
		//Fonction appeler à partir du lien dans la liste pour supprimer
		$scope.delLink = function (id) {
			//Appel de la fonction affListe de AgenceSrevice
			aProvider.del(id, function (donnee) {
					//Mettre à jour la liste
					//Appel de la fonction affListe de AgenceSrevice
					aProvider.getAll(function (info){
					//Stocker les données récupérées de service dans le scope. Ici function = callBack et info = response.data !
					$scope.liste=info;
				});
			})
		}
		
		//initialiser l'agence dans rootScope
		$rootScope.aUpdate = {
				id:undefined,
				nom:"",
				adresse:{
					numRue:"",
					rue:"",
					cp:"",
					localite:"",
					pays:""
				},
		};
		//Fonction appeler à partir du lien dans la liste pour modifier
		$scope.updLink = function (a) {
			$rootScope.aUpdate=a;
			//rediriger vers la page modifier
			$location.path("modifAgence");
		}
	})
	.controller("addACtrl", function ($scope, aProvider, $location) {
		$scope.agence = {
				nom:"",
				adresse:{
					numRue:"",
					rue:"",
					cp:"",
					localite:"",
					pays:""
				},
		};
		$scope.msg="";
		$scope.ajout = function () {
			//Appel de la fonction ajout de AgenceSrevice
			aProvider.add($scope.agence, function(donnee) {
				if (typeof donnee=='object'){
					$scope.msg="";
					//Rediriger vers la page accueil après ajout
					$location.path("listeAgence")
				} else {
					$scope.msg="L'ajout d'une agence a échoué"
				}
			});
		}
	})
	.controller("updateACtrl", function ($scope, aProvider, $location, $rootScope) {
		if ($rootScope.aUpdate.id==undefined) {
			$scope.aModif = {
					id:undefined,
					nom:"",
					adresse:{
						numRue:"",
						rue:"",
						cp:"",
						localite:"",
						pays:""
					},
			};
		} else {
			$scope.aModif=$rootScope.aUpdate;
		}
		$scope.msg="";
		$scope.modif = function () {
			//Appel de la fonction modif de AgenceSrevice
			aProvider.update($scope.aModif, function(donnee) {
				if (typeof donnee=='object'){
					$scope.msg="";
					//Rediriger vers la page accueil après ajout
					$location.path("listeAgence")
				} else {
					$scope.msg="La modification a échoué. Veuillez réessayer !"
				}
			});
		}
	})
	.controller("delACtrl", function ($scope, aProvider, $location) {
		$scope.suppr = function (id) {
			//Appel de la fonction rechParId de AgenceSrevice
			aProvider.del(id, function (donnee) {
				if (typeof donnee=='OK'){
					$scope.msg="";
					//Rediriger vers la page accueil après ajout
					$location.path("listeAgence")
				} else {
					$scope.msg="La suppression a échoué"
				}
			});
		}
	})
	.controller("getIdACtrl", function ($scope, aProvider) {
		$scope.indice=false;
		$scope.msg="";
		$scope.rech = function (id) {
			//Appel de la fonction rechParId de AgenceSrevice
			aProvider.getId(id, function (donnee){
				if (typeof donnee=='object'){
					$scope.indice=true;
					$scope.msg="";
					//Stocker les données récupérées de service dans le scope. Ici function = callBack et info = response.data !
					$scope.aOut=donnee;
				} else {
					$scope.indice=false;
					$scope.msg="L'Agence n'existe pas"
				}
			});
		}
	})