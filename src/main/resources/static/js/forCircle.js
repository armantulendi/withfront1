// Draw Circle dashboard
var doghnutCharts = document.querySelectorAll('.doghnutChartGroup .circular-progress');

for (var h = 0; h < doghnutCharts.length; h++) {
    var percent = doghnutCharts[h].getAttribute('data-percent');
    console.log(percent);
    var degree = 90 + ( ( 360 / 100 ) * Number(percent) );
    console.log(degree);

    if (percent > 0 && percent <= 25) {
        doghnutCharts[h].style.background = 'linear-gradient(90deg, #E0E0E0 50%, transparent 50%, transparent), linear-gradient(' + degree + 'deg , #FF70A6 50%, #E0E0E0 50%, #E0E0E0)';
    } else if (percent > 25 && percent <= 50) {
        doghnutCharts[h].style.background = 'linear-gradient(90deg, #E0E0E0 50%, transparent 50%, transparent), linear-gradient(' + degree + 'deg , #FF70A6 50%, #E0E0E0 50%, #E0E0E0)';
    } else if (percent > 50 && percent <= 75) {
        doghnutCharts[h].style.background = 'linear-gradient(-90deg, #FF70A6 50%, transparent 50%, transparent), linear-gradient(' + degree + 'deg , #FF70A6 50%, #E0E0E0 50%, #E0E0E0)';
    } else if (percent > 75 && percent <= 100) {
        doghnutCharts[h].style.background = 'linear-gradient(-90deg, #FF70A6 50%, transparent 50%, transparent), linear-gradient(' + degree + 'deg , #FF70A6 50%, #E0E0E0 50%, #E0E0E0)';
    } else {
        doghnutCharts[h].style.background = 'linear-gradient(90deg, #E0E0E0 50%, transparent 50%, transparent), linear-gradient(90deg , #FF70A6 50%, #E0E0E0 50%, #E0E0E0)';
    }

    //doghnutCharts[h].style.background = 'linear-gradient(90deg, #E0E0E0 50%, transparent 50%, transparent), linear-gradient(' + degree + 'deg , #FF70A6 50%, #E0E0E0 50%, #E0E0E0)';
    console.log(doghnutCharts[h].style.background);
}