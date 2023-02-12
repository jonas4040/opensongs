function adicionar(idPlaylist,idMusica){
	var xmlhttp = new XMLHttpRequest();
	var hostname = window.location.host;
	var urlparameters = "/addtoplaylist?playlist="+idPlaylist+"&song="+idMusica;
	var url = "http://"+hostname+"/opensongs"+urlparameters;
	xmlhttp.open("GET",url);
	
	xmlhttp.onreadystatechange=function(){
		//alert("Status: "+xmlhttp.status);
		if(xmlhttp.status === 200 && xmlhttp.readyState === 4){ // se status da pg for 0K e recebeu response do server
			alert("Adicionada com sucesso!");//alert("response: "+xmlhttp.responseText);
		}
	};
	xmlhttp.send();
}	