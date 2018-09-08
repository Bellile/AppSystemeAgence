// creation des controllers du bien immo à louer
appClient.controller("findAllBVCtrl", function($scope, bvPCProvider) {

	bvPCProvider.getAll(function(donnees) {
		$scope.liste = donnees;
	});

});