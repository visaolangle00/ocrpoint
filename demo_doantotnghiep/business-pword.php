<?php
	require "config.php";
	
	$empid =$_POST["empid"];
	$old_pword=$_POST["old_pword"];
	$new_pword=$_POST["new_pword"];
	

	if($conn){
		          $sqlCheckEmail ="SELECT*FROM `taikhoan_gv` WHERE `taikhoan_id` LIKE '$empid'";
				  $emailQuery =mysqli_query($conn,$sqlCheckEmail);
				  if(mysqli_num_rows($emailQuery)>0){
					  $query ="UPDATE `taikhoan_gv` SET `matkhau` = '$new_pword' WHERE `taikhoan_id` = '$empid'";
					  if(mysqli_query($conn,$query)){
						  echo "PasswordChanged";
					  }else{
						  echo "Oldpasswordnotmatch";
					  }
				  }
				  
				  
				  else{
					  echo "This ID is not registered";
				  }
				  
	
	
	}
	
	else{
		echo "Connection Error";
	}
	
				
				
				
		
			

?>