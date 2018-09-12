// creation des controllers du bien immo à louer
monApp.controller("getAllBVCtrl", function($scope, bvProvider) {

	bvProvider.getAll(function(donnees) {
		$scope.liste = donnees;
	});

$rootScope.blGetOne=undefined;

	
	$scope.displayInfos=function(l){
		
		console.log("-------------------- " + $rootScope.blGetOne)
		$rootScope.blGetOne=l;

		$location.path("listeVendrePC");
	}	
	
}).controller("getIdBVCtrl", function($scope, bvProvider) {
	$scope.id = undefined;
	$scope.indice = false;
	$scope.msg = "";

	if($rootScope.blGetOne!=undefined){
		$scope.bienlouer=$rootScope.blGetOne;
		$scope.indice = true;
	}
	
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
			adresse : {
				numRue : "",
				rue : "",
				cp : "",
				localite : "",
				pays : ""
			},
			lat : "",
			lng : ""
		}

	$scope.ajouter = function() {
		bvProvider.geoAdresse($scope.bvForm.adresse.pays,$scope.bvForm.adresse.numRue,$scope.bvForm.adresse.rue, $scope.bvForm.adresse.cp,$scope.bvForm.adresse.localite, function(calback) {
			if ((calback != 0) && (calback != "")) {
				// $scope.montrerMap=true;
				$scope.map = calback;
				$scope.bvForm.lat = $scope.map[0].lat;
				$scope.bvForm.lng = $scope.map[0].lon;
				
				bvProvider.add($scope.bvForm, function(donnees) {
					if (typeof donnees == 'object') {
						$scope.msg = "";
						$location.path("listeVendre");
					} else {
						$scope.msg = "L'ajout a échoué";
					}
				})
			}
		});
		

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
}).controller("updateBVDispoCtrl", function($scope, bvProvider, $location){
	$scope.bvForm = {
			id : undefined,
			statut : "",
		}

		$scope.modifierDispo = function() {
			bvProvider.updateDispo($scope.bvForm, function(donnees) {
				if (typeof donnees == 'object') {
					$scope.msg = "";
					$location.path("listeVendre");
				} else {
					$scope.msg = "Le changement de disponibilité a échoué";
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