//Configuration de la table de routing
monApp.config(function($routeProvider) {

	$routeProvider.when("/listeAgence", {
		templateUrl : "views/aListeVue.html",
		controller : "getAllACtrl"
	})
	$routeProvider.when("/rechercheAgence", {
		templateUrl : "views/aRechercheVue.html",
		controller : "getIdACtrl"
	})
	$routeProvider.when("/ajoutAgence", {
		templateUrl : "views/aAjoutVue.html",
		controller : "addACtrl"
	})
	$routeProvider.when("/modifAgence", {
		templateUrl : "views/aModifVue.html",
		controller : "updateACtrl"
	})
	$routeProvider.when("/supprAgence", {
		templateUrl : "views/aSupprVue.html",
		controller : "delACtrl"
	})

	
	$routeProvider.when("/listeLouer", {
		templateUrl : "views/bLListeVue.html",
		controller : "getAllBLCtrl"
	})
	$routeProvider.when("/rechercheLouer", {
		templateUrl : "views/bLRechercheVue.html",
		controller : "getIdBLCtrl"
	})
	$routeProvider.when("/ajoutLouer", {
		templateUrl : "views/bLAjoutVue.html",
		controller : "addBLCtrl"
	})
	$routeProvider.when("/modifAgence", {
		templateUrl : "views/bLModifVue.html",
		controller : "updateBLCtrl"
	})
	$routeProvider.when("/supprLouer", {
		templateUrl : "views/bLSupprVue.html",
		controller : "delBLCtrl"
	})

	
	$routeProvider.when("/listeVendre", {
		templateUrl : "views/bVListeVue.html",
		controller : "getAllBVCtrl"
	})
	$routeProvider.when("/rechercheVendre", {
		templateUrl : "views/bVRechercheVue.html",
		controller : "getIdBVCtrl"
	})
	$routeProvider.when("/ajoutVendre", {
		templateUrl : "views/bLAjoutVue.html",
		controller : "addBVCtrl"
	})
	$routeProvider.when("/modifVendre", {
		templateUrl : "views/bVModifVue.html",
		controller : "updateCtrl"
	})
	$routeProvider.when("/supprVendre", {
		templateUrl : "views/bVSupprVue.html",
		controller : "delBVCtrl"
	})

	
	$routeProvider.when("/listeClasseStandard", {
		templateUrl : "views/cSListeVue.html",
		controller : "getAllCSCtrl"
	})
	$routeProvider.when("/rechercheClasseStandard", {
		templateUrl : "views/cSRechercheVue.html",
		controller : "getIdCSCtrl"
	})
	$routeProvider.when("/ajoutClasseStandard", {
		templateUrl : "views/cSAjoutVue.html",
		controller : "addCSCtrl"
	})
	$routeProvider.when("/modifClasseStandard", {
		templateUrl : "views/cSModifVue.html",
		controller : "updateCSCtrl"
	})

	
	$routeProvider.when("/listeClient", {
		templateUrl : "views/clListeVue.html",
		controller : "getAllClCtrl"
	})
	$routeProvider.when("/rechercheClient", {
		templateUrl : "views/clRechercheVue.html",
		controller : "getIdClCtrl"
	})
	$routeProvider.when("/ajoutClient", {
		templateUrl : "views/clAjoutVue.html",
		controller : "addClCtrl"
	})
	$routeProvider.when("/modifClient", {
		templateUrl : "views/clModifVue.html",
		controller : "updateClCtrl"
	})
	$routeProvider.when("/supprClient", {
		templateUrl : "views/clSupprVue.html",
		controller : "delClCtrl"
	})

	
	$routeProvider.when("/listeContrat", {
		templateUrl : "views/coListeVue.html",
		controller : "getAllCoCtrl"
	})
	$routeProvider.when("/rechercheContrat", {
		templateUrl : "views/coRechercheVue.html",
		controller : "getIdCoCtrl"
	})
	$routeProvider.when("/ajoutContrat", {
		templateUrl : "views/coAjoutVue.html",
		controller : "addCoCtrl"
	})
	$routeProvider.when("/modifContrat", {
		templateUrl : "views/coModifVue.html",
		controller : "updateCtrl"
	})
	$routeProvider.when("/supprContrat", {
		templateUrl : "views/coSupprVue.html",
		controller : "delCoCtrl"
	})
	
	
	$routeProvider.when("/listeProprietaire", {
		templateUrl : "views/pListeVue.html",
		controller : "getAllPCtrl"
	})
	$routeProvider.when("/rechercheProprietaire", {
		templateUrl : "views/pRechercheVue.html",
		controller : "getIdPCtrl"
	})
	$routeProvider.when("/ajoutProprietaire", {
		templateUrl : "views/pAjoutVue.html",
		controller : "addPCtrl"
	})
	$routeProvider.when("/modifProprietaire", {
		templateUrl : "views/pModifVue.html",
		controller : "updatePCtrl"
	})
	$routeProvider.when("/supprProprietaire", {
		templateUrl : "views/pSupprVue.html",
		controller : "delPCtrl"
	})

	
	$routeProvider.when("/listeResponsable", {
		templateUrl : "views/rListeVue.html",
		controller : "getAllRCtrl"
	})
	$routeProvider.when("/rechercheResponsable", {
		templateUrl : "views/rRechercheVue.html",
		controller : "getIdRCtrl"
	})
	$routeProvider.when("/ajoutResponsable", {
		templateUrl : "views/rAjoutVue.html",
		controller : "addRCtrl"
	})
	$routeProvider.when("/modifResponsable", {
		templateUrl : "views/rModifVue.html",
		controller : "updateRCtrl"
	})
	$routeProvider.when("/supprResponsable", {
		templateUrl : "views/rSupprVue.html",
		controller : "delRCtrl"
	})
	
	
	$routeProvider.when("/listeVisite", {
		templateUrl : "views/vListeVue.html",
		controller : "getAllVCtrl"
	})
	$routeProvider.when("/rechercheVisite", {
		templateUrl : "views/vRechercheVue.html",
		controller : "getIdVCtrl"
	})
	$routeProvider.when("/ajoutVisite", {
		templateUrl : "views/vAjoutVue.html",
		controller : "addVCtrl"
	})
	$routeProvider.when("/modifVisite", {
		templateUrl : "views/vModifVue.html",
		controller : "updateVCtrl"
	})
	$routeProvider.when("/supprVisite", {
		templateUrl : "views/vSupprVue.html",
		controller : "delVCtrl"
	})
	
	
	
});