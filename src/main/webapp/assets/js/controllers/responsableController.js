// créer mes controllers
monApp
.controller("getAllRCtrl", function($scope,responsableProvider, $rootScope, $location){
	// appel de la fonction getListe de mon service
	responsableProvider.getAll(function(donnees) {
		//stocker les données récupérées de service
		$scope.liste=donnees;
	});
	//fonction appelée à partir du lien de la liste des responsables pour supprimer un responsable
	$scope.deleteLien=function(rIn){
		responsableProvider.del(rIn.id, function(retour) {
			//mettre à jour la liste
			responsableProvider.getListe(function(donnees) {
			$scope.liste=donnees;
		});
	})
}
	// initialiser le responsable de rootScope
	$rootScope.rUpdate={
			id:undefined,
			nom:"",
			telPerso:"",
			mail:"",
			identifiant:"",
			mdp:""
	};
	$scope.modifLien=function(rIn){
		responsableProvider.update(rIn, function() {
			//mettre à jour la liste
			responsableProvider.getListe(function(donnees) {
			$scope.liste=donnees;
		});
	})
}
	
})
.controller("getIdRCtrl", function($scope,responsableProvider) {
	$scope.id=undefined;
    $scope.rechercher=function () {
        //appel de la fonction responsableProvider de de monService
    	responsableProvider.getResponsable($scope.id, function(donnees){
    		
        	$scope.responsable=donnees;
        })
    }
	
})
.controller("addRCtrl", function($scope, responsableProvider, $location) {
	$scope.rForm={
			nom:"",
			telPerso:"",
			mail:"",
			identifiant:"",
			mdp:""
	};
	$scope.ajouter=function(){
		responsableProvider.add($scope.rForm,function(donnees){
			if(typeof donnees == 'object'){
				$scope.msg="";
				// ridiriger vers accueil
				$location.path("listeResponsable");
			}else{
				$scope.msg="L'ajout a echoue !";
			}
		})
	}
})
.controller("updateRCtrl", function($scope, responsableProvider, $location) {

	$scope.rForm={
			id:undefined,
			nom:"",
			telPerso:"",
			mail:"",
			identifiant:"",
			mdp:""
	};
	$scope.modifier=function(){
		responsableProvider.update($scope.rForm,function(donnees){
			if(typeof donnees == 'object'){
				$scope.msg="";
				// ridiriger vers accueil
				$location.path("listeResponsable");
			}else{
				$scope.msg="La modification a echoue !";
			}
		})
	}
})
.controller("deleteRCtrl", function($scope, responsableProvider, $location) {
	$scope.id=undefined;
	// la fonction appelée à partir du bouton supprimer d ela vue
	$scope.supprimer=function(){
		// appel de la fonction service pour supprimer dans la BD
		responsableProvider.del($scope.id, function(retour) {
			if(retour == 'OK'){
				$scope.msg="";
				// ridiriger vers accueil
				$location.path("listeResponsable");
			}else{
				$scope.msg="La suppression a echoue !";
			}
		})
	}
});