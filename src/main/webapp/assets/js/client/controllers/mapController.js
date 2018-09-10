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
	var liste = "";
	var tabMarker = [];
	mapProvider.getAll(function (donnee){
		liste = donnee;
		console.log(liste)
		
		angular.forEach(liste, function(value, key) {
		
			var coor = [value.lng, value.lat];
			console.log(coor);
			
			var marker = new ol.Feature({
				geometry: new ol.geom.Point(ol.proj.fromLonLat(coor)),
				
			});  
	    	
			var iconStyle = new ol.style.Style({
				  image: new ol.style.Icon(/** @type {olx.style.IconOptions} */ ({
				    anchor: [0.5, 46],
				    anchorXUnits: 'fraction',
				    anchorYUnits: 'pixels',
				    opacity: 0.75,
				    src: 'assets/resources/image/marker.png'
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
    
//	//----------------------------------
//	var map = new google.maps.Map(document.getElementById('map'), {
//		zoom: 10,
//	      center: new google.maps.LatLng(-33.92, 151.25),
//	      mapTypeId: google.maps.MapTypeId.ROADMAP
//	});
//	
//	var marker, i;
//
//    for (i = 0; i < tabMarker.length; i++) {  
//      marker = new google.maps.Marker({
//        position: new google.maps.LatLng(tabMarker[i][1], tabMarker[i][2]),
//        map: map
//      });
//      
//    }
//    mapProvider.getCoord(address, function(donnee){
//		console.log(donnee.geometry)
//		localite = [label, donnee.geometry.location.lng(), donnee.geometry.location.lat()];
//		
//	})
}) 