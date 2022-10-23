<!DOCTYPE html>
<jsp:useBean id="Usuario" class="org.opensongs.model.Usuario" scope="session"/>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Nova Playlist</title>


<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<p id="creditos" align="right">Developed by Jonas Morais with
					the help of Professor Isidro</p>
			</div>
		</div>
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
				<h4 class="text-center">
					${Usuario.nome}, crie sua playlist.
				</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<form role="form" action="createplaylist" method="POST">
							<div class="form-group">

								<label for="playlistName"> Titulo da Playlist </label> <input
									type="text" class="form-control" id="playlistName"
									name="txtPlaylistName">
							</div>
							<div class="form-group">

								<label for="playlistDescr"> Descricao </label> <textarea
									class="form-control" id="playlistDescr"
									name="txtPlaylistDescr"></textarea>
							</div>


							<button type="submit" class="btn btn-primary">Criar Playlist</button>
						</form>
					</div>
					<div class="col-md-2"></div>
				</div>
			</div>
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>