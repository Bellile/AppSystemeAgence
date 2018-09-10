// creation des controllers du bien immo à louer
monApp.controller("getAllBVCtrl", function($scope, bvProvider) {

	bvProvider.getAll(function(donnees) {
		$scope.liste = donnees;
	});

}).controller("getIdBVCtrl", function($scope, bvProvider) {
	$scope.id = undefined;
	$scope.indice = false;
	$scope.msg = "";

	$scope.rechercher = function(input) {

		bvProvider.getID($scope.id, function(donnees) {

			if (typeof donnees == 'object') {
				$scope.indice = true;
				$scope.msg = "";
				$scope.bienvendre = donnees;
			} else {
				$scope.indice = false;
				$scope.msg = "L'identifiant est incorrect";
			}
		})
	}
}).controller("addBVCtrl", function($scope, bvProvider, $location) {
	$scope.bvForm = {
			typeBien : "",
			statut : "",
			revenuCadastre : "",
			description : "",
			dateSoumission: "",
			dateDisposition :"",
			listeImages:[],
			photos: [],
			prix:"",
			etat:"",
			numRue:"",
			rue:"",
			cp:"",
			localite:"",
			pays:""
		}

	$scope.ajouter = function() {

		bvProvider.add($scope.bvForm, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.msg = "";
				$location.path("listeVendre");
			} else {
				$scope.msg = "L'ajout a échoué";
			}
		})

	}
}).controller("delBVCtrl", function($scope, bvProvider, $location) {
	$scope.id = undefined;

	$scope.supprimer = function() {

		bvProvider.del($scope.id, function(retour) {
			if (retour == 'OK') {
				$scope.msg = "";
				$location.path("listeVendre");
			} else {
				$scope.msg = "La suppression a échoué";
			}
		})
	}
}).controller("updateBVCtrl", function($scope, bvProvider, $location) {

	$scope.bvForm = {
		id : undefined,
		typeBien : "",
		statut : "",
		revenuCadastre : "",
		description : "",
		dateSoumission: "",
		dateDisposition :"",
		listeImages:[],
		photos: [],
		prix:"",
		etat:"",
		numRue:"",
		rue:"",
		cp:"",
		localite:"",
		pays:""
	}

	$scope.modifier = function() {
		bvProvider.update($scope.bvForm, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.msg = "";
				$location.path("listeVendre");
			} else {
				$scope.msg = "La modification a échoué";
			}
		})
	}
});