function adicionar(idPlaylist,idMusica){
	var xmlhttp = new XMLHttpRequest();
	var hostname = window.location.host;
	var urlparameters = "/addtoplaylist?playlist="+idPlaylist+"&song="+idMusica;
	xmlhttp.open("GET",hostname+"/opensongs"+urlparameters);
	
	xmlhttp.onreadystatechange=function(){
		alert(xmlhttp.status);
		if(xmlhttp.status === 200 && xmlhttp.readyState === 4){ // se status da pg for 0K e recebeu response do server
			alert(xmlhttp.responseText);
		}
	};
	xmlhttp.send();
}	