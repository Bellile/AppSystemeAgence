// creation des controllers pour le proprietaire
monApp.controller("getAllPCtrl", function($scope, proprietaireProvider) {

	proprietaireProvider.getAll(function(donnees) {
		$scope.liste = donnees;
	});

}).controller("getIdPCtrl", function($scope, proprietaireProvider) {
	$scope.id = undefined;
	$scope.indice = false;
	$scope.msg = "";

	$scope.rechercher = function(input) {

		proprietaireProvider.getID($scope.id, function(donnees) {

			if (typeof donnees == 'object') {
				$scope.indice = true;
				$scope.msg = "";
				$scope.proprio = donnees;
			} else {
				$scope.indice = false;
				$scope.msg = "L'identifiant est incorrect";
			}
		})
	}
}).controller("addPCtrl", function($scope, proprietaireProvider, $location) {
	$scope.pForm = {
			nom : "",
			telPro : "",
			telPerso : "",
			mail : "",
			numRue: "",
			rue :"",
			cp:"",
			localite:"",
			pays:""
		}

	$scope.ajouter = function() {

		proprietaireProvider.add($scope.pForm, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.msg = "";
				$location.path("listeProprietaire");
			} else {
				$scope.msg = "L'ajout a échoué";
			}
		})

	}
}).controller("delPCtrl", function($scope, proprietaireProvider, $location) {
	$scope.id = undefined;

	$scope.supprimer = function() {

		proprietaireProvider.del($scope.id, function(retour) {
			if (retour == 'OK') {
				$scope.msg = "";
				$location.path("listeProprietaire");
			} else {
				$scope.msg = "La suppression a échoué";
			}
		})
	}
}).controller("updatePCtrl", function($scope, proprietaireProvider, $location) {

	$scope.pForm = {
		id : undefined,
		nom : "",
		telPro : "",
		telPerso : "",
		mail : "",
		numRue: "",
		rue :"",
		cp:"",
		localite:"",
		pays:""
	}

	$scope.modifier = function() {
		proprietaireProvider.update($scope.pForm, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.msg = "";
				$location.path("listeProprietaire");
			} else {
				$scope.msg = "La modification a échoué";
			}
		})
	}
});