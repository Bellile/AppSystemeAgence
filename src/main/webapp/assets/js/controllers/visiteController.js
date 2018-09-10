//Création des controllers de VisiteController
monApp.controller("getAllVCtrl", function($scope, visiteProvider) {

	// appel de la fonction getAll de mon service etudiantProvider
	visiteProvider.getAll(function(donnees) {
		// stocker les données recuperer de service (fonction callBack)
		$scope.listeVisite = donnees;
	})

})

.controller("getIdVCtrl", function($scope, visiteProvider) {

	$scope.id = undefined;
	$scope.indice = false;
	$scope.msg = "";

	// appel de la fonction rechercher a partir du bouton de la vue
	$scope.recherche = function() {

		// appel de la fonction du service pour recup l'etudiant
		visiteProvider.getId($scope.id, function(donnees) {

			if (typeof donnees == 'object') {
				$scope.indice = true;
				$scope.visite = donnees;
			} else {
				$scope.indice = false;
				$scope.msg = "Aucune visite trouvée";
			}

		});
	}

})

.controller("addVCtrl", function($scope, visiteProvider, $location) {
	$scope.vForm = {
		dateHeure : ""		
			
	};
	// appel de la fonction ajouter a partir du bouton de la vue
	$scope.ajout = function() {
		visiteProvider.add($scope.vForm, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.msg = "";
				// rediriger vers accueil
				$location.path("listeVisite");
			} else {
				$scope.msg = "Impossible d'ajouter cette visite";
			}
		});
	}

})

.controller("updateVCtrl",
		function($scope, visiteProvider, $location) {

				$scope.vModif = {
					id : undefined,
					dateHeure : ""
				}

			// appel de la fonction modifiera partir du bouton de la vue
			$scope.modif = function() {
				visiteProvider.update($scope.vModif, function(donnees) {
					if (typeof donnees == 'object') {
						$scope.msg = "";
						// rediriger vers accueil
						$location.path("listeVisite");
					} else {
						$scope.msg = "impossible de modifier cette visite";
					}
				});
			}

		})

.controller("delVCtrl", function($scope, visiteProvider, $location) {
	$scope.id = undefined;
	// appel de la fonction ajouter a partir du bouton de la vue
	$scope.suppr = function() {
		// appel de la fonction du service pour recup la visite
		visiteProvider.del($scope.id, function(retour) {
			if (typeof retour == 'OK') {
				$scope.msg = "";
				// rediriger vers accueil
				$location.path("listeVisite");
			} else {
				$scope.msg = "la suppression a echouée";
			}

		});
	}

})