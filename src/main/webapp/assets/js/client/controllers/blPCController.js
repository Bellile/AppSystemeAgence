// creation des controllers du bien immo à louer
appClient.controller("findAllBLCtrl",
		function($scope, blPCProvider, $rootScope,  $location) {

			blPCProvider.getAll(function(donnees) {
				$scope.liste = donnees;
				console.log(liste)
			});

			$rootScope.blGetOne = undefined;

			$scope.displayInfos = function(l) {

				console.log("-------------------- " + $rootScope.blGetOne)
				$rootScope.blGetOne = l;

				$location.path("detail");
			}
			})
			.controller("getIdBLCtrl", function($scope, blPCProvider,
					$rootScope) {

				$scope.msg = "";
				
				if ($rootScope.blGetOne != undefined) {
					$scope.bienlouer = $rootScope.blGetOne;
					$scope.indice = true;
				} else {
					$scope.msg = "404 Not found ( Bien introuvable ) "
				}
			});