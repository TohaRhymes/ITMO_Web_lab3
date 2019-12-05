let canvas = document.getElementById('canvas');
let ctx = canvas.getContext('2d');
let size = Math.min(canvas.width, canvas.height) / 10 - 2;
let radius = 1;

let xCanvas = document.getElementById("canvas-form:xCanvas");
let yCanvas = document.getElementById("canvas-form:yCanvas");
let counter;
let table = document.getElementById("result-table").childNodes[3];
drawArea(radius);
drawAxis();
drawResize();

function handleRChange(event) {
    clearCanvas();
    radius = Number(event.target.value);
    drawArea(radius);
    drawAxis();
    setTimeout(() => drawResize(), 10);
}


function handleSubmit() {
    clearCanvas();
    drawArea(radius);
    drawAxis();
    drawResize();
}

function isPointInArea(x, y, r) {
    return ((x <= 0 && y <= 0 && x > -r && y > -r / 2 || (x >= 0 && y >= 0 && x + y <= r / 2) || (x >= 0 && y <= 0 && x ^ 2 + y ^ 2 <= (r / 2) ^ 2)));
}

function handleCanvasClick(event) {
    let obj = event.target;
    let x = Number(((event.pageX - window.pageXOffset - obj.getBoundingClientRect().x - obj.width / 2) / size).toFixed(2));
    let y = Number((-(event.pageY - window.pageYOffset - obj.getBoundingClientRect().y - obj.height / 2) / size).toFixed(2));
    console.log(x);
    console.log(x >= -3 && x <= 5);
    console.log(y);
    console.log(y >= -3 && y <= 3);
    if (x >= -3 && x <= 5 && y >= -3 && y <= 3) {
        console.log("YEAPBOIIIII");
        console.log(x);
        console.log(y);
        xCanvas.value = x;
        yCanvas.value = y;
    }
}



