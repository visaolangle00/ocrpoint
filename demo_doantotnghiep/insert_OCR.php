<?php

    /*
    include 'config.php';
    
		$Diem = isset($_POST['Diem']) ? $_POST['Diem'] : '';
	$TenSV = isset($_POST['TenSV']) ? $_POST['TenSV'] : '';
	$MaSV = isset($_POST['MaSV']) ? $_POST['MaSV'] : '';
	  
     
     $sql = "SELECT * FROM diem_sinhvien WHERE MaSV='$MaSV'";
     
     $result = mysqli_query($conn,$sql);
	 //$insert = "INSERT INTO diem_sinhvien(Diem,TenSV,MaSV) VALUES ('$Diem','$TenSV','$MaSV')";
	 $update = "UPDATE diem_sinhvien SET Diem = '$Diem'  WHERE MaSV ='$MaSV'";
	 
	 $result1 =mysqli_fetch_array($result,MYSQLI_ASSOC);
	 $diem=$result1['Diem'];
     
     if(mysqli_num_rows($result) > 0  && ($diem==null)){
		 if($conn->query($update) === TRUE){
			 echo "Updated";
			 mysqli_close($conn);
		 }
     }
     else{
         echo "Error";
		 //mysqli_query($conn,$insert);
		 mysqli_close($conn);
     }
	 */
	 
	 
	 
	 
	 include 'config.php';
    
     	$DIEM_Gk = isset($_POST['DIEM_Gk']) ? $_POST['DIEM_Gk'] : '';
	$MaMon = isset($_POST['MaMon']) ? $_POST['MaMon'] : '';
	$MaSV = isset($_POST['MaSV']) ? $_POST['MaSV'] : '';
	
	
	
	  
     
     //$sql = "SELECT * FROM diem WHERE MaSV='$MaSV' AND TenSV='$TenSV' ";
	 
	  $sql = "SELECT * FROM diem WHERE MaMon ='$MaMon' AND MaSV='$MaSV' ";
     
     $result = mysqli_query($conn,$sql);
	 //$insert = "INSERT INTO diem_sinhvien(Diem,TenSV,MaSV) VALUES ('$Diem','$TenSV','$MaSV')";
	 $update = "UPDATE diem SET DIEM_Gk = '$DIEM_Gk' WHERE MaMon ='$MaMon' AND MaSV='$MaSV' ";
	 
	  //$update = "UPDATE diem_sinhvien SET Diem = '$Diem' WHERE MaSV ='$MaSV' AND TenSV='$TenSV' ";
	 
	 $result1 = mysqli_fetch_array($result,MYSQLI_ASSOC);
	 $diem=$result1['DIEM_Gk'];
	 
	 
	 
	 // C1
	 
	 
       if(mysqli_num_rows($result) > 0 && ($diem==null)){
		 if($conn->query($update) === TRUE){
			 echo "Updated";
			//mysqli_close($conn);
		 }
     }
	 
     else{
         echo "Error";
		  mysqli_close($conn);
		
     }
	 
	 

	 
	
	 
	 
	 /*
     if(mysqli_num_rows($result) > 0 ){
		 if($conn->query($update) === TRUE){
			 echo "Data Updated";
			 mysqli_close($conn);
		 }
     }
     else{
         echo "Error";
		
     }
	 */
 

	 
	 
	 
 
	

?>