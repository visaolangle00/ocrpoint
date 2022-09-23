<?php
	require "config.php";
	
	$empid = $_POST["empid"];
	$user_name = $_POST["user_name"];
	$user_email = $_POST["user_email"];
	$user_number = $_POST["user_number"];
	
	
	if($conn){
		
			
			$sqlCheckEmail ="SELECT*FROM `taikhoan_gv` WHERE `taikhoan_id` LIKE '$empid'";
			$emailQuery =mysqli_query($conn,$sqlCheckEmail);
			
			//var_dump($emailQuery);

			if(mysqli_num_rows($emailQuery)>0)
			{
				$query ="UPDATE `taikhoan_gv` SET `tentaikhoan` = '$user_name' , `email` ='$user_email', `dienthoai` = '$user_number' WHERE `taikhoan_id` = '$empid'";
			
				if(mysqli_query($conn,$query)){
					echo "Information Update";
				}else{
						echo "Failed to update";
					}
					
					
				}
				
				else{
					echo "This ID is not registered";
				}
			}else{
				echo "Connection Error";
			}
			

?>