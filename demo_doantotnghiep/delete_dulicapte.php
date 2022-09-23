<?php  
	//$connect = mysqli_connect("localhost","root","","appocrchuan");
	//mysqli_query($connect, "SETNAMES 'utf8'");
	require 'config.php';

	//$id = $_POST['id'];

	$query = "DELETE e1 from diem e1,diem e2 Where e1.MaSV=e2.MaSV AND e1.id>e2.id";
	if (mysqli_query($conn, $query)) {
		echo "success";
	}
	
	else{
		echo "error";
	}
	
?>