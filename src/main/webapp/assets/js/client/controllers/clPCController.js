monApp.controller("addClPCCtrl", function($scope, clPCProvider, $location) {

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
		clPCProvider.add($scope.clForm, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.msg = "";
				$location.path("listeClient")
			} else {
				$scope.msg = "L'ajout a echoue"
			}
		})
	}

});