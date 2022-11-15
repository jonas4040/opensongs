<!DOCTYPE html>
<jsp:useBean id="Usuario" class="org.opensongs.model.Usuario" scope="session"/>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Upload de Música</title>


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
					${Usuario.nome}, faça upload de suas m&uacute;sicas.
				</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<form role="form" action="uploadsong" method="POST" enctype="multipart/form-data">
							<div class="form-group">
								<label for="songName"> Titulo da M&uacute;sica </label> <input
									type="text" class="form-control" id="songName"
									name="txtSongName">
							</div>
							<div class="form-group">
								<label for="artista"> Artista </label> <input
									type="text" class="form-control" id="artista"
									name="txtArtista">
							</div>
							<div class="form-group">
								<label for="album"> &Aacute;lbum </label> <input
									type="text" class="form-control" id="album"
									name="txtAlbum">
							</div>
							<div class="form-group">
								<label for="estillo"> Estilo </label> 
								<select id="estilo"	name="swtEstilo">
									<option value="1">Rock</option>
									<option value="2">Moda de Viola</option>
									<option value="3">Blues</option>
									<option value="4">Samba/Pagode</option>
									<option value="5">Pop</option>
									<option value="6">Outros</option>
								</select>
							</div>
							<div class="form-group">
								<label for="inputFile"> &Aacute;lbum </label> <input
									type="file" class="form-control-file" id="fileMP3" name="fileMP3">
							</div>
							<button type="submit" class="btn btn-primary">Upload de M&uacute;sica </button>
						</form>
					</div>
					<br/>
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