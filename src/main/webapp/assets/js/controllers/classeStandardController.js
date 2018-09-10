//Cr�ation des controllers de VisiteController
monApp.controller("getAllCSCtrl", function($scope, classeStandardProvider) {

	// appel de la fonction getAll de mon service etudiantProvider
	classeStandardProvider.getAll(function(donnees) {
		// stocker les donn�es recuperer de service (fonction callBack)
		$scope.listeClasseStandard = donnees;
	})

})

.controller("getIdCSCtrl", function($scope, classeStandardProvider) {

	$scope.id = undefined;
	$scope.indice = false;
	$scope.msg = "";

	// appel de la fonction rechercher a partir du bouton de la vue
	$scope.recherche = function() {

		// appel de la fonction du service pour recup l'etudiant
		classeStandardProvider.getId($scope.id, function(donnees) {

			if (typeof donnees == 'object') {
				$scope.indice = true;
				$scope.cs = donnees;
			} else {
				$scope.indice = false;
				$scope.msg = "Aucune classe standard trouvée";
			}

		});
	}

})

.controller("addCSCtrl", function($scope, classeStandardProvider, $location) {
	$scope.csForm = {
			nom:"",
			typeBien : "",
			modeOffre: "",
			prixMax:"",
			superficieMin:""
	};
	// appel de la fonction ajouter a partir du bouton de la vue
	$scope.ajout = function() {
		classeStandardProvider.add($scope.csForm, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.msg = "";
				// rediriger vers accueil
				$location.path("listeClasseStandard");
			} else {
				$scope.msg = "Impossible d'ajouter cette classe standard";
			}
		});
	}

})

.controller("updateCSCtrl",
		function($scope, classeStandardProvider, $location) {

				$scope.csModif = {
					id : undefined,
					nom:"",
					typeBien : "",
					modeOffre: "",
					prixMax:"",
					superficieMin:""
				}

			// appel de la fonction modifiera partir du bouton de la vue
			$scope.modif = function() {
					classeStandardProvider.update($scope.csModif, function(donnees) {
					if (typeof donnees == 'object') {
						$scope.msg = "";
						// rediriger vers accueil
						$location.path("listeClasseStandard");
					} else {
						$scope.msg = "impossible de modifier cette classe standard";
					}
				});
			}

		})

.controller("delCSCtrl", function($scope, classeStandardProvider, $location) {
	$scope.id = undefined;
	// appel de la fonction ajouter a partir du bouton de la vue
	$scope.suppr = function() {
		// appel de la fonction du service pour recup la visite
		classeStandardProvider.del($scope.id, function(retour) {
			if (retour == 'OK') {
				$scope.msg = "";
				// rediriger vers accueil
				$location.path("listeClasseStandard");
			} else {
				$scope.msg = "la suppression a echoue";
			}

		});
	}

})