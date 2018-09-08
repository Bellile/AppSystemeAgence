appClient.controller("findAllCSCtrl", function($scope, cSPCProvider) {

	cSPCProvider.getAll(function(donnees) {
		$scope.liste = donnees;
	});


});