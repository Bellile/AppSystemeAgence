// creation des controllers du bien immo à louer
monApp.controller("getAllBLCtrl", function($scope, blProvider) {

	blProvider.getAll(function(donnees) {
		$scope.liste = donnees;
	});

}).controller("getIdBLCtrl", function($scope, blProvider) {
	$scope.id = undefined;
	$scope.indice = false;
	$scope.msg = "";

	$scope.rechercher = function(input) {

		blProvider.getID($scope.id, function(donnees) {

			if (typeof donnees == 'object') {
				$scope.indice = true;
				$scope.msg = "";
				$scope.bienlouer = donnees;
			} else {
				$scope.indice = false;
				$scope.msg = "L'identifiant est incorrect";
			}
		})
	}
}).controller("addBLCtrl", function($scope, blProvider, $location) {
	$scope.blForm = {
			typeBien : "",
			statut : "",
			revenuCadastre : "",
			description : "",
			dateSoumission: "",
			dateDisposition :"",
			listeImages:[],
			photos: [],
			caution:"",
			loyer:"",
			charges: "",
			typeBail:"",
			garniture:"",
			numRue:"",
			rue:"",
			cp:"",
			localite:"",
			pays:""
		}

	$scope.ajouter = function() {

		blProvider.add($scope.blForm, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.msg = "";
				$location.path("listeLouer");
			} else {
				$scope.msg = "L'ajout a échoué";
			}
		})

	}
}).controller("delBLCtrl", function($scope, blProvider, $location) {
	$scope.id = undefined;

	$scope.supprimer = function() {

		blProvider.del($scope.id, function(retour) {
			if (retour == 'OK') {
				$scope.msg = "";
				$location.path("listeLouer");
			} else {
				$scope.msg = "La suppression a échoué";
			}
		})
	}
}).controller("updateBLCtrl", function($scope, blProvider, $location) {

	$scope.blForm = {
		id : undefined,
		typeBien : "",
		statut : "",
		revenuCadastre : "",
		description : "",
		dateSoumission: "",
		dateDisposition :"",
		listeImages:[],
		photos: [],
		caution:"",
		loyer:"",
		charges: "",
		typeBail:"",
		garniture:"",
		numRue:"",
		rue:"",
		cp:"",
		localite:"",
		pays:""
	}

	$scope.modifier = function() {
		blProvider.update($scope.blForm, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.msg = "";
				$location.path("listeLouer");
			} else {
				$scope.msg = "La modification a échoué";
			}
		})
	}
});