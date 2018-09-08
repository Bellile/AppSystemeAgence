// creation des controllers du bien immo à louer
appClient.controller("findAllBLCtrl", function($scope, blPCProvider) {

	blPCProvider.getAll(function(donnees) {
		$scope.liste = donnees;
	});


});