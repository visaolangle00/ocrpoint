<?php

   
  
	 
	 include 'config.php';
    
     	$diem_gk = isset($_POST['diem_gk']) ? $_POST['diem_gk'] : '';
	$sv_id = isset($_POST['sv_id']) ? $_POST['sv_id'] : '';
	$lop_id = isset($_POST['lop_id']) ? $_POST['lop_id'] : '';
	
	
	
//	$delete = "DELETE e1 from diem e1,diem e2 Where e1.MaMon=e2.MaMon AND e1.id>e2.id";
	
	//$resultde =mysqli_query($conn,$delete);
	
//	if(mysqli_num_rows($resulde)>0){
		
		  $sql = "SELECT * FROM sv_hocphan WHERE sv_id ='$sv_id' AND lop_id='$lop_id' ";
     
     $result = mysqli_query($conn,$sql);
	
	if(mysqli_num_rows($result)>0){
		$result1= mysqli_fetch_array($result,MYSQLI_ASSOC);
		$diem_record=$result1['diem_gk'];
		if($diem_record==null){
			$id=$result1['id'];
			$sql="UPDATE sv_hocphan set diem_gk='$diem_gk' Where sv_hocphan.id='$id' ";
			if(mysqli_query($conn,$sql)){
				echo "banthemthanhcong";
			}else{
				echo "bandabiloi";
			}
		}else{
			echo "khongchophepthemlan2";
		}
	}else{
		echo "thongtinbannhapkhongdung";
	}
	
	
	// $sql = "SELECT * FROM diem WHERE MaMon ='$MaMon' AND MaSV='$MaSV' "; 
	// $result = mysqli_query($conn,$sql); 
	// if(mysqli_num_rows($result)>0){ 
	// $sql="UPDATE diem set DIEM_Gk='$DIEM_Gk' WHERE MaMon ='$MaMon' AND MaSV='$MaSV'";
	// if(mysqli_query($conn,$sql)){
		// echo "banthemthanhcong"; 
		// }else{ 
		// echo "bandabiloi"; 
		// } 
		// }else{ 	
		// echo "thongtinbannhapkhongdung"; 	}
	
	

	

	
	
	
	
	 
	
	
	
	/*
	 $sql = "SELECT * FROM diem WHERE MaMon ='$MaMon' AND MaSV='$MaSV' ";
     
     $result = mysqli_query($conn,$sql);
	 //$insert = "INSERT INTO diem_sinhvien(Diem,TenSV,MaSV) VALUES ('$Diem','$TenSV','$MaSV')";
	if(mysqli_num_rows($result)>0){
		$result1= mysqli_fetch_array($result,MYSQLI_ASSOC);
		$diem_record=$result1['DIEM_Gk'];
		if($diem_record==null){
			$id=$result1['id'];
			$sql="UPDATE diem set DIEM_Gk='$DIEM_Gk' Where diem.id='$id' ";
			if(mysqli_query($conn,$sql)){
				echo "banthemthanhcong";
			}else{
				echo "bandabiloi";
			}
		}else{
			echo "khongchophepthemlan2";
		}
	}else{
		echo "xyz";
	}
	*/
	
	
	
	
	
	
	

	

?>