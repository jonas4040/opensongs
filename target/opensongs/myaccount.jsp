<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<jsp:useBean id="Usuario" class="org.opensongs.model.Usuario"
	scope="session" />
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Minha Conta</title>


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

				<h4 class="text-center">Bem vindo, ${Usuario.nome}!</h4>
			</div>
		</div>

		<div class="row" id="conteudo">
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-2 botao btnlink">
				<span class="text-center"><a class="botaospt"
					href="newsong">Upload</a></span>
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
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>