//Configuration de la table de routing
appClient.config(function($routeProvider) {
	
	$routeProvider.when("/listeAgencePC", {
		templateUrl : "views/pc/aListePCVue.html",
		controller : "findAllACtrl"
	})
	
	$routeProvider.when("/listeLouerPC", {
		templateUrl : "views/pc/bLListePCVue.html",
		controller : "findAllBLCtrl"
	})
	
	$routeProvider.when("/detail", {
		templateUrl : "views/pc/bLDetailPCVue.html",
		controller : "getIdBLCtrl"
	})
	
	
		
	$routeProvider.when("/listeVendrePC", {
		templateUrl : "views/pc/bVListePCVue.html",
		controller : "findAllBVCtrl"
	})

		$routeProvider.when("/listeClasseStandardPC", {
		templateUrl : "views/pc/cSListePCVue.html",
		controller : "findAllCSCtrl"
	})
	
	$routeProvider.when("/listeVisitePC", {
		templateUrl : "views/pc/vListePCVue.html",
		controller : "myNgController"
	})

		$routeProvider.when("/mapPC", {
		templateUrl : "views/pc/mapPCVue.html",
		controller : "mapBlCtrl"
	})
	
});