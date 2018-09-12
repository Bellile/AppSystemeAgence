// creation des controllers du bien immo à louer
appClient.controller("findAllBLCtrl",
		function($scope, blPCProvider, bvPCProvider, $rootScope, $location) {

			blPCProvider.getAll(function(donnees) {
				$scope.liste = donnees;

			});

			bvPCProvider.getAll(function(donnees) {
				$scope.liste1 = donnees;
			});

			$rootScope.blGetOne = undefined;
			$rootScope.bvGetOne = undefined;

			$scope.displayInfosbl = function(l) {

				$rootScope.blGetOne = l;

				$location.path("detailBl");
			}

			$scope.displayInfosbv = function(l) {

				$rootScope.bvGetOne = l;

				$location.path("detailBv");
			}
		})

.controller("getIdBLCtrl", function($scope, $rootScope) {
	$scope.msg = "";

	if ($rootScope.blGetOne != undefined) {
		$scope.bienlouer = $rootScope.blGetOne;
	} else {
		$scope.msg = "404 Not found ( Bien introuvable ) "
	}
	
	
}).controller("getIdBVPCCtrl", function($scope, $rootScope) {
	$scope.msg = "";

	if ($rootScope.bvGetOne != undefined) {
		$scope.bienvendre = $rootScope.bvGetOne;
	} else {
		$scope.msg = "404 Not found ( Bien introuvable ) "
	}
	
}).controller("getAdresseBLCtrl", function($scope, blPCProvider) {
	$scope.id = undefined;// creation des controllers du bien immo à louer
	$scope.indice = false;
	$scope.msg = "";

	$scope.rechercher = function() {

		blPCProvider.getAdresse($scope.adresse, function(donnees) {

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
});