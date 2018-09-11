//Création des controller et appel des méthodes service
appClient.controller("mapBlCtrl", function ($scope, mapProvider){
	$scope.map = new ol.Map({
		target : 'map',
		layers : [ new ol.layer.Tile({
			source : new ol.source.OSM()
		}) ],
		view : new ol.View({
			center : ol.proj.fromLonLat([ -1.560350, 47.213780]),
			zoom : 10
		})
	});
	
	//Appel de la fonction pour récupérer la liste
	var listeBl = "";
	
	mapProvider.getAllBl(function (donnee){
		listeBl = donnee;
		console.log(listeBl)
		
		angular.forEach(listeBl, function(value, key) {
		
			var coor = [value.lng, value.lat];
			console.log(coor);
			
			var marker = new ol.Feature({
				geometry: new ol.geom.Point(ol.proj.fromLonLat(coor)),
				description: value.description
			});  
	    	
			var iconStyle = new ol.style.Style({
				  image: new ol.style.Icon(/** @type {olx.style.IconOptions} */ ({
				    anchor: [0.5, 46],
				    anchorXUnits: 'fraction',
				    anchorYUnits: 'pixels',
				    opacity: 0.75,
				    src: 'assets/resources/image/marker_red.png'
				  }))
				});
			
			marker.setStyle(iconStyle);
			
	    	var vectorSource = new ol.source.Vector({
				features: [marker]
			});
		
			var markerVectorLayer = new ol.layer.Vector({
				source: vectorSource
			});
			$scope.map.addLayer(markerVectorLayer);
			
		})
	});
	
	var listeBv = "";
	
	mapProvider.getAllBv(function (donnee){
		listeBv = donnee;
		console.log(listeBv)
		
		angular.forEach(listeBv, function(value, key) {
		
			var coor = [value.lng, value.lat];
			console.log(coor);
			
			var marker = new ol.Feature({
				geometry: new ol.geom.Point(ol.proj.fromLonLat(coor)),
				description: value.description
			});  
	    	
			var iconStyle = new ol.style.Style({
				  image: new ol.style.Icon(/** @type {olx.style.IconOptions} */ ({
				    anchor: [0.5, 46],
				    anchorXUnits: 'pixels',
				    anchorYUnits: 'pixels',
				    opacity: 0.75,
				    src: 'assets/resources/image/marker_green.png'
				  }))
				});
			
			marker.setStyle(iconStyle);
			
	    	var vectorSource = new ol.source.Vector({
				features: [marker]
			});
		
			var markerVectorLayer = new ol.layer.Vector({
				source: vectorSource
			});
			$scope.map.addLayer(markerVectorLayer);
			
		})
	});


	var popup = new ol.Overlay({
      element: $scope.popup,
      positioning: 'bottom-center',
      stopEvent: false,
      offset: [0, -50]
    });
    $scope.map.addOverlay(popup);
	

    // display popup on click
    $scope.map.on('click', function(evt) {
      var feature = $scope.map.forEachFeatureAtPixel(evt.pixel,
        function(feature) {
          return feature;
        });
      if (feature) {
        var coordinates = feature.getGeometry().getCoordinates();
        popup.setPosition(coordinates);
        $($scope.popup).popover({
          placement: 'top',
          html: true,
          content: feature.get('description')
        });
        $($scope.popup).popover('show');
      } else {
        $($scope.popup).popover('destroy');
      }
    });

//    // change mouse cursor when over marker
//    $scope.map.on('pointermove', function(e) {
//      if (e.dragging) {
//        $(element).popover('destroy');
//        return;
//      }
//      var pixel = $scope.map.getEventPixel(e.originalEvent);
//      var hit = $scope.map.hasFeatureAtPixel(pixel);
//      $scope.map.getTarget().style.cursor = hit ? 'pointer' : '';
//    });
	
//    //Add a selector control to the vectorLayer with popup functions
//    var controls = {
//      selector: new ol.Control.SelectFeature(vectorLayer, { onSelect: createPopup, onUnselect: destroyPopup })
//    };
//
//    function createPopup(feature) {
//      feature.popup = new ol.Popup.FramedCloud("pop",
//          feature.geometry.getBounds().getCenterLonLat(),
//          null,
//          '<div class="markerContent">'+feature.attributes.description+'</div>',
//          null,
//          true,
//          function() { controls['selector'].unselectAll(); }
//      );
//      //feature.popup.closeOnMove = true;
//      map.addPopup(feature.popup);
//    }
//
//    function destroyPopup(feature) {
//      feature.popup.destroy();
//      feature.popup = null;
//    }
//    
//    map.addControl(controls['selector']);
//    controls['selector'].activate();
}) 