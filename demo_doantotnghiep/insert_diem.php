<?php 
	//$connect = mysqli_connect("localhost","root","","testqlsv");
	//mysqli_query($connect, "SETNAMES 'utf8'");
	
	require 'config.php';
	
	//	$id = $_POST['id'];

	$diem_gk=$_POST['diem_gk'];
	
	$sv_id=$_POST['sv_id'];
	
	$lop_id=$_POST['lop_id'];

	//$query = "UPDATE `sinhvien` SET `hoTen`='$hoTen',`tenLop`='$tenLop',`namSinh`='$namSinh',`gioiTinh`='$gioiTinh' WHERE maSV = '$maSV'";
	
	
	
	
	$qry= 'SELECT * FROM `sv_hocphan` where `sv_id`="'.$sv_id.'" AND lop_id = "'.$lop_id.'" ';
	
		//$qry= 'SELECT * FROM `diem` where `MaMon`="'.$MaMon.'" AND MaSV = "'.$MaSV.'" and MaMon="'.$Diem_Gk.'" ';
		
		
		
		
	$result=mysqli_query($conn,$qry);
	

	

	
	
	
	
	if(mysqli_num_rows($result)>0){
		echo "dacodiemroinhe";
	}
	else{
		$query="INSERT INTO sv_hocphan(diem_gk,sv_id,lop_id) VALUES ('$diem_gk', '$sv_id', '$lop_id' )";
		if(mysqli_query($conn,$query)){
			echo "insertthanhcong";
		}
		else{
			echo "thongtinbisai";
		}
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

?>	