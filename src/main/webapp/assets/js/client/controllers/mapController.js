//Création des controller et appel des méthodes service
appClient.controller("mapBlCtrl", function ($scope, mapProvider){
	//Appel de la fonction pour récupérer la liste
	var liste = "";
	mapProvider.getAll(function (donnee){
		liste = donnee;
		console.log(liste)
	});
	var tabMarker = [];
	angular.forEach(liste, function(value, key) {
		console.log(e)
		var address = e.adresse;
		console.log(address)
		var localite = [];
		var label = e.description;
		mapProvider.getCoord(address, function(donnee){
			localite = [label, donnee.geometry.location.lng(), donnee.geometry.location.lat()];
			console.log(donnee.geometry.location.lng())
		})
		tabMarker.push(localite);
	})
	console.log("je suis là")
	$scope.map = new ol.Map({
		target : 'map',
		layers : [ new ol.layer.Tile({
			source : new ol.source.OSM()
		}) ],
		view : new ol.View({
			center : ol.proj.fromLonLat([ -1.560350, 47.213780]),
			zoom : 3
		})
	});
    
    // Define markers as "features" of the vector layer:
    for (i = 0; i < tabMarker.length; i++) {
    	var feature = new ol.Feature.Vector(
    			new ol.Geometry.Point( tabMarker[i][1], tabMarker[i][2] ).transform(epsg4326, projectTo),
    			{description:tabMarker[i][0]} ,
    			{externalGraphic: 'img/marker.png', graphicHeight: 25, graphicWidth: 21, graphicXOffset:-12, graphicYOffset:-25  }
        	);  
    	
    	var vectorSource = new ol.source.Vector({
			features: [marker]
		});
	
		var markerVectorLayer = new ol.layer.Vector({
			source: vectorSource,
		});
		map.addLayer(markerVectorLayer);
    }
       
//    map.addLayer(vectorLayer);
//
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
}) 