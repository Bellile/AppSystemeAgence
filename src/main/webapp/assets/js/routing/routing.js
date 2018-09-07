//Configuration de la table de routing
monApp.config(function($routeProvider) {

	$routeProvider.when("/listeAgence", {
		templateUrl : "views/agence/aListeVue.html",
		controller : "getAllACtrl"
	})
	$routeProvider.when("/rechercheAgence", {
		templateUrl : "views/agence/aRechercheVue.html",
		controller : "getIdACtrl"
	})
	$routeProvider.when("/ajoutAgence", {
		templateUrl : "views/agence/aAjoutVue.html",
		controller : "addACtrl"
	})
	$routeProvider.when("/modifAgence", {
		templateUrl : "views/agence/aModifVue.html",
		controller : "updateACtrl"
	})
	$routeProvider.when("/supprAgence", {
		templateUrl : "views/agence/aSupprVue.html",
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
		templateUrl : "views/client/clListeVue.html",
		controller : "getAllClCtrl"
	})
	$routeProvider.when("/rechercheClient", {
		templateUrl : "views/client/clRechercheVue.html",
		controller : "getIdClCtrl"
	})
	$routeProvider.when("/ajoutClient", {
		templateUrl : "views/client/clAjoutVue.html",
		controller : "addClCtrl"
	})
	$routeProvider.when("/modifClient", {
		templateUrl : "views/client/clModifVue.html",
		controller : "updateClCtrl"
	})
	$routeProvider.when("/supprClient", {
		templateUrl : "views/client/clSupprVue.html",
		controller : "delClCtrl"
	})

	
	$routeProvider.when("/listeContrat", {
		templateUrl : "views/contrat/coListeVue.html",
		controller : "getAllCoCtrl"
	})
	$routeProvider.when("/rechercheContrat", {
		templateUrl : "views/contrat/coRechercheVue.html",
		controller : "getIdCoCtrl"
	})
	$routeProvider.when("/ajoutContrat", {
		templateUrl : "views/contrat/coAjoutVue.html",
		controller : "addCoCtrl"
	})
	$routeProvider.when("/modifContrat", {
		templateUrl : "views/contrat/coModifVue.html",
		controller : "updateCtrl"
	})
	$routeProvider.when("/supprContrat", {
		templateUrl : "views/contrat/coSupprVue.html",
		controller : "delCoCtrl"
	})
	
	
	$routeProvider.when("/listeProprietaire", {
		templateUrl : "views/proprietaire/pListeVue.html",
		controller : "getAllPCtrl"
	})
	$routeProvider.when("/rechercheProprietaire", {
		templateUrl : "views/proprietaire/pRechercheVue.html",
		controller : "getIdPCtrl"
	})
	$routeProvider.when("/ajoutProprietaire", {
		templateUrl : "views/proprietaire/pAjoutVue.html",
		controller : "addPCtrl"
	})
	$routeProvider.when("/modifProprietaire", {
		templateUrl : "views/proprietaire/pModifVue.html",
		controller : "updatePCtrl"
	})
	$routeProvider.when("/supprProprietaire", {
		templateUrl : "views/proprietaire/pSupprVue.html",
		controller : "delPCtrl"
	})

	
	$routeProvider.when("/listeResponsable", {
		templateUrl : "views/responsable/rListeVue.html",
		controller : "getAllRCtrl"
	})
	$routeProvider.when("/rechercheResponsable", {
		templateUrl : "views/responsable/rRechercheVue.html",
		controller : "getIdRCtrl"
	})
	$routeProvider.when("/ajoutResponsable", {
		templateUrl : "views/responsable/rAjoutVue.html",
		controller : "addRCtrl"
	})
	$routeProvider.when("/modifResponsable", {
		templateUrl : "views/rModifVue.html",
		controller : "updateRCtrl"
	})
	$routeProvider.when("/supprResponsable", {
		templateUrl : "views/responsable/rSupprVue.html",
		controller : "delRCtrl"
	})
	
	
	$routeProvider.when("/listeVisite", {
		templateUrl : "views/visite/vListeVue.html",
		controller : "getAllVCtrl"
	})
	$routeProvider.when("/rechercheVisite", {
		templateUrl : "views/visite/vRechercheVue.html",
		controller : "getIdVCtrl"
	})
	$routeProvider.when("/ajoutVisite", {
		templateUrl : "views/visite/vAjoutVue.html",
		controller : "addVCtrl"
	})
	$routeProvider.when("/modifVisite", {
		templateUrl : "views/visite/vModifVue.html",
		controller : "updateVCtrl"
	})
	$routeProvider.when("/supprVisite", {
		templateUrl : "views/visite/vSupprVue.html",
		controller : "delVCtrl"
	})
	
	
	
});