<?php 
	//$connect = mysqli_connect("localhost","root","","testqlsv");
	//mysqli_query($connect, "SETNAMES 'utf8'");
	
	require 'config.php';
	
		$id = $_POST['id'];

	$diem_gk=$_POST['diem_gk'];
	
	$sv_id=$_POST['sv_id'];
	
	$lop_id=$_POST['lop_id'];

	//$query = "UPDATE `sinhvien` SET `hoTen`='$hoTen',`tenLop`='$tenLop',`namSinh`='$namSinh',`gioiTinh`='$gioiTinh' WHERE maSV = '$maSV'";
	
	$query ="UPDATE `sv_hocphan` set `diem_gk`='$diem_gk' WHERE `sv_id`='$sv_id' and `lop_id`='$lop_id'";
	
	

	if (mysqli_query($conn, $query)) {
		echo "success";
	}else{
		echo "error";
	}
?>	