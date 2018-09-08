//Configuration de la table de routing
appClient.config(function($routeProvider) {
	
	$routeProvider.when("/listeAgencePC", {
		templateUrl : "views/agence/aListePCVue.html",
		controller : "findAllACtrl"
	})
	
	$routeProvider.when("/listeLouerPC", {
		templateUrl : "views/bl/bLListePCVue.html",
		controller : "findAllBLCtrl"
	})
	
		
	$routeProvider.when("/listeVendrePC", {
		templateUrl : "views/bv/bVListePCVue.html",
		controller : "findAllBVCtrl"
	})

		$routeProvider.when("/listeClasseStandardPC", {
		templateUrl : "views/cs/cSListePCVue.html",
		controller : "findAllCSCtrl"
	})

	
});