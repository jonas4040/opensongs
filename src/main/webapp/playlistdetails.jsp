<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<jsp:useBean id="Usuario" class="org.opensongs.model.Usuario"
	scope="session" />
<jsp:useBean id="Playlist" class="org.opensongs.model.Playlist"
	scope="session" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Detalhe da Playlist</title>


<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<img src="img/logo_opensongs.png" class="rounded mx-auto d-block"
					width="15%" align="center" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">

				<h3 class="text-center">Open Songs - Listen to free online
					songs!</h3>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">

				<h4 class="text-center">Detalhes da playlist</h4>
			</div>
		</div>

		<div class="row" id="menu">
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-2 botao btnlink">
				<span class="text-center"><a class="botaospt" href="newsong">Upload</a></span>
			</div>
			<div class="col-md-2 botao btnlink">
				<span class="text-center"><a class="botaospt"
					href="playlists">Playlists</a></span>
			</div>
			<div class="col-md-2  botao btnlink">
				<span class="text-center"><a class="botaospt"
					href="newplaylist">Add Playlist</a></span>
			</div>
			<div class="col-md-2  botao btnlink">
				<span class="text-center"><a class="botaospt" href="signout">Logout</a>
				</span>
			</div>
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-2"></div>
		</div>

		<div class="row">
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-8">
				<h4>${Playlist.titulo}</h4>
			</div>
			<div class="col-md-2">&nbsp;</div>
		</div>
		
		<div class="row">
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-8">
				<h5><a href="getsongs?playlist=${Playlist.id}">+ Adicionar M&uacute;sicas</a></h5>
			</div>
			<div class="col-md-2">&nbsp;</div>
		</div>

		<c:forEach var="musica" items="${Playlist.musicas}">
						<div class="row center">
							<div class="col-md-2">&nbsp;</div>
							<div class="col-md-8">
								<span class="musicaeartista">${musica.titulo} -
									${musica.artista}
								</span> 
								<span class="album">(${musica.album})</span>
								<span class="playsong">
									<audio controls>

										<source src="${request.contextPath}/${musica.linkMP3}" type="audio/mpeg"/>

									</audio>
								</span>
							</div>
							<div class="col-md-2">&nbsp;</div>
						</div>
					</c:forEach>

	</div>

<!-- 	<script src="https://code.jquery.com/jquery-3.6.1.min.js" -->
<!-- 		integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" -->
<!-- 		crossorigin="anonymous"></script> -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
</body>
</html>