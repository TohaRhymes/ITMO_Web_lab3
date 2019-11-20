beginTime();
function beginTime() {
    let container = document.getElementById("time-container");
    changeTime(container)
    const interval =13;
    setInterval(()=>changeTime(container), interval*1000)
}
function changeTime(container) {
    let d = new Date();
    let hours = d.getHours();
    let minutes = d.getMinutes();
    let seconds = d.getSeconds();

    if (hours <= 9) hours = "0" + hours;
    if (minutes <= 9) minutes = "0" + minutes;
    if (seconds <= 9) seconds = "0" + seconds;

    let date_time =  hours + ":" + minutes + ":" + seconds;
    container.innerHTML = `<p>Time: ${date_time}</p><p>Updated every 13 seconds</p>`
}