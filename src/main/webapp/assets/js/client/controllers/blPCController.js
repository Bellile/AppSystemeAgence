// creation des controllers du bien immo à louer
appClient.controller("findAllBLCtrl",
		function($scope, blPCProvider, $rootScope,  $location) {

			blPCProvider.getAll(function(donnees) {
				$scope.liste = donnees;
				
			});

			$rootScope.blGetOne = undefined;

			$scope.displayInfos = function(l) {

				console.log("-------------------- " + $rootScope.blGetOne)
				$rootScope.blGetOne = l;

				$location.path("detail");
			}
		})
		.controller("getIdBLCtrl", function($scope, blPCProvider,$rootScope) {
				$scope.msg = "";
				
				if ($rootScope.blGetOne != undefined) {
					$scope.bienlouer = $rootScope.blGetOne;
				} else {
					$scope.msg = "404 Not found ( Bien introuvable ) "
				}
		})
		.controller("getAdresseBLCtrl", function($scope, blPCProvider) {
				$scope.id = undefined;// creation des controllers du bien immo à louer
				$scope.indice = false;
				$scope.msg = "";
		
				$scope.rechercher = function(input) {

					blPCProvider.getID($scope.id, function(donnees) {

						if (typeof donnees == 'object') {
							$scope.indice = true;
							$scope.msg = "";
							$scope.bienlouer = donnees;
						} else {
							$scope.indice = false;
							$scope.msg = "L'identifiant est incorrect";
						}
					})
				}
		});