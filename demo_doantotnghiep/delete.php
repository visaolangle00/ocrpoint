<?php  
	//$connect = mysqli_connect("localhost","root","","appocrchuan");
	//mysqli_query($connect, "SETNAMES 'utf8'");
	require 'config.php';

	$id = $_POST['id'];

	$query = "DELETE FROM sv_hocphan WHERE id = '$id'";
	if (mysqli_query($conn, $query)) {
		echo "success";
	}else{
		echo "error";
	}
?>