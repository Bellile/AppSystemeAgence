// creation des controllers du bien immo à louer
appClient.controller("findAllBVCtrl", function($scope, bvPCProvider) {

	bvPCProvider.getAll(function(donnees) {
		$scope.liste = donnees;

	});
	
}).controller("getAdresseBVPCCtrl", function($scope, bvPCProvider) {
	$scope.adresse = "";
	$scope.indice = false;
	$scope.msg = "";

	$scope.rechercher = function() {

		bvPCProvider.getAdresse($scope.adresse, function(donnees) {

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

});