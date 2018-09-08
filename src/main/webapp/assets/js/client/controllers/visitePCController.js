/** Pour l'instant le service est à l'intérieur du controller, je le séparerai plus tard */
appClient.controller("myNgController", ["$scope", "$http", "uiCalendarConfig", function ($scope, $http, uiCalendarConfig) {
    
    $scope.SelectedEvent = null;
    var isFirstTime = true;
 
    $scope.events = [];
    $scope.eventSources = [$scope.events];
 
 
    //Récupérer les visites du WS
    $http.get("http://localhost:8080/Projet_AppSystemeAgence/wsV/liste", {
        cache: true,
        params: {}
    }).then(function (data) {
    	
        $scope.events.slice(0, $scope.events.length);
        angular.forEach(data.data, function (value) {
        	console.log("La date est : "+value.dateHeure);
        	// création des objets visite pouvant être affichés sur le calendrier
            $scope.events.push({
                title: "Visite",
                description: "Visite de bien immobilier",
                start: new Date(value.dateHeure),
                end: new Date((value.dateHeure)+1800000), // on rajoute 30 min 
                allDay : false,
                stick: true
            });
        });
    });
 
    // configuration du calendrier
    $scope.uiConfig = {
        calendar: {
            height: 450,
            editable: true,
            displayEventTime: false,
            header: {
                left: 'month basicWeek basicDay agendaWeek agendaDay',
                center: 'title',
                right:'today prev,next'
            },
            eventClick: function (event) {
                $scope.SelectedEvent = event;
            },
            eventAfterAllRender: function () {
                if ($scope.events.length > 0 && isFirstTime) {
                    
                    uiCalendarConfig.calendars.myCalendar.fullCalendar('gotoDate', $scope.events[0].start);
                    isFirstTime = false;
                }
            }
        }
    };
 
}])