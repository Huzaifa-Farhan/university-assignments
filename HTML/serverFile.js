var http = require('http');
var fs = require('fs');
var server = http.createServer (onRequest);
function onRequest (req, res) {
    if(req.method=='GET'&& req.url== '/')
        {res.writeHead (200,{"Content-Type": "text/html"}); 
        fs.createReadStream("./lab2.html").pipe(res);
        }
    else{
        send404Response(res)

  }
};

function send404Response(res){
    res.writeHead (404,{'Content-Type': 'text/plain'}); 
    res.write("Error 404: page not found!");
    res.end();
}

server.listen(1337, '127.0.0.1');

console.log('Server running at http://127.0.0.1:1337/');