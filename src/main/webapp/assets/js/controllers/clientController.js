monApp.controller("getAllClCtrl", function($scope, clProvider) {

	clProvider.getAll(function(donnees) {
		$scope.liste = donnees;
	});

});

monApp.controller("getIdClCtrl", function($scope, clProvider) {

	$scope.id = undefined;
	$scope.indice = false;
	$scope.msg = "";
	$scope.recherche = function() {
		clProvider.getId($scope.id, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.indice = true;
				$scope.cl = donnees;
				$scope.msg = "";
			} else {
				$scope.indice = false;
				$scope.msg = "le client n'existe pas";
			}
		})
	}

});

monApp.controller("addClCtrl", function($scope, clProvider, $location) {

	$scope.clForm = {
		nom : "",
		telPerso : "",
		mail : "",
		acquereur : "",
		numCompostage : "",
		adresse : {
			numRue : "",
			rue : "",
			cp : "",
			localite : "",
			pays : ""
		},
	};
	$scope.ajouter = function() {
		clProvider.add($scope.clForm, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.msg = "";
				$location.path("listeClient")
			} else {
				$scope.msg = "L'ajout a echoue"
			}
		})
	}

});

monApp.controller("updateClCtrl", function($scope, clProvider, $location) {

	$scope.clForm = {
		id : undefined,
		nom : "",
		telPerso : "",
		mail : "",
		acquereur : "",
		numCompostage : "",
		adresse : {
			numRue : "",
			rue : "",
			cp : "",
			localite : "",
			pays : ""
		},
	};

	$scope.modifier = function() {

		clProvider.update($scope.clForm, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.msg = "";
				$location.path("listeClient");
			} else {
				$scope.msg = "La modification a echoue";
			}

		})
	}

});

monApp.controller("delClCtrl", function($scope, clProvider, $location) {

	$scope.id = undefined;
	$scope.supprimer = function() {

		clProvider.del($scope.id, function(retour) {
			if (retour == 'OK') {
				$scope.msg = "";
				$location.path("listeClient");
			} else {
				$scope.msg = "La suppression a echoue";
			}
		})
	}

});
