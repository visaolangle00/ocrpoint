<?php
require_once('config.php');



if($conn){
	//$link ="/xampp/htdocs/llapor/gambar/";
	
	$link ="/ToolDev/xampp/htdocs/DOANTOTNGHIEPNEWS/anh/";
	$hinhanh = $_POST['hinhanh'];
	$gv_id = $_POST['gv_id'];
	$tentaikhoan = $_POST['tentaikhoan'];
	$thongtin = $_POST['thongtin'];
	//$date = date("d.m.yy-h.i.sa");
	
	$date = date("d.m.yy-h.i.sa");
	
	$url = "http://192.168.43.89/DOANTOTNGHIEPNEWS/anh/".$date.".jpeg";
	$sql = "INSERT INTO `anh` (`gv_id`,`tentaikhoan`,`thongtin`,`thoigian`,`hinhanh`) VALUES
     ('$gv_id','$tentaikhoan','$thongtin',CURRENT_TIMESTAMP,'$url')";
    $upload=$link.$date.".jpeg";

    if(mysqli_query($conn,$sql)){
		file_put_contents($upload, base64_decode($hinhanh));
		echo json_encode(array('respon' =>'Image saved successfully'));
	}else{
			echo json_encode(array('respon' =>'picture failed to save'));
	}
}else{
		  echo json_encode(array('respon' =>'Connection failed'));
} mysqli_close($conn);
		 
?>