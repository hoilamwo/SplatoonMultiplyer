var socket = io.connect({transports: ['websocket']});
socket.on('gameState', parseGameState);

var canvas = document.getElementById("canvas");
var context = canvas.getContext("2d");
context.globalCompositeOperation = 'source-over';

drawGameBoard()

function parseGameState(event) {
    const gameState = JSON.parse(event);

    for (let player of gameState['players']) {
        placePlayer(player['x'], player['y'], player['id'] === socket.id ? '#ffff00' : '#56bcff', 50.0);
    }
}

function drawGameBoard() {

    const gridWidth = 1500;
    const gridHeight = 800;

    canvas.setAttribute("width", gridWidth);
    canvas.setAttribute("height", gridHeight);

    context.fillStyle = "#beeaff";
    context.fillRect(0, 0, gridWidth, gridHeight);
}


function placePlayer(x, y, color, size) {
    context.fillStyle = color;
    context.fillRect(x, y, size, size)
}
