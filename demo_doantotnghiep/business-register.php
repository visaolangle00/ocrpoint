<?php
	require "config.php";
	
		$txtRegisterBy = $_POST['txtRegisterBy'];
	$txtUserId = $_POST['txtUserId'];
	$txtUserName = $_POST['txtUserName'];
	$txtEmail = $_POST['txtEmail'];
	$txtPassword = $_POST['txtPassword'];

       // $enc_password=md5($txtPassword);

	$txtMobile = $_POST['txtMobile'];
	$selectGender = $_POST['selectGender'];
	$txtStatus1 = $_POST['txtStatus1'];
	$txtStatus2 = $_POST['txtStatus2'];
	
	
	
	
	$isValidEmail = filter_var($txtEmail,FILTER_VALIDATE_EMAIL);
	
	
	if($conn){
		
		if(strlen($txtPassword)>40 || strlen($txtPassword)<6){
			echo "Password must be less than 40 and more than 6 characters";
		}else if($isValidEmail ===true){
			echo "This Email is not valid";
		}
		else{
			$sqlCheckUsername ="SELECT*FROM `taikhoan_gv` WHERE `taikhoan_id` LIKE '$txtUserId'";
			$usernameQuery = mysqli_query($conn,$sqlCheckUsername);
			if(mysqli_num_rows($usernameQuery)>0){
				echo "This employee id already registered";
			}else{
				$sqlCheckEmail ="SELECT*FROM `taikhoan_gv` WHERE `email` LIKE '$txtEmail'";
				$emailQuery = mysqli_query($conn,$sqlCheckEmail);
				if(mysqli_num_rows($emailQuery)>0){
					echo "This email is already registered, Type another email";
				}else{
					
					$sql_register = "INSERT INTO `taikhoan_gv`(`dangkyboi`,`taikhoan_id`,`tentaikhoan`,`email`,`matkhau`,`dienthoai`,`gioitinh`,`trangthai1`,`trangthai2`) VALUES
					
						('$txtRegisterBy','$txtUserId','$txtUserName','$txtEmail','$txtPassword','$txtMobile','$selectGender','$txtStatus1','$txtStatus2')";
					
					
					if(mysqli_query($conn,$sql_register)){
						echo "Successfully Registered";
					}
					
					else{
						echo "Failed to register, try again";
					}
				}
			}
		}
	}
	else{
		echo "Connection Error, Contact to Admin";
	}
	
	
	
	
	
	/*
	if($conn){
		
		if(strlen($txtPassword)>40 || strlen($txtPassword)<6){
			echo "Password must be less than 40 and more than 6 characters";
		}else if($isValidEmail ===true){
			echo "This Email is not valid";
		}
		else{
			$sqlCheckUsername ="SELECT*FROM `user_gv` WHERE `taikhoan_id` LIKE '$txtUserId'";
			$usernameQuery = mysqli_query($conn,$sqlCheckUsername);
			if(mysqli_num_rows($usernameQuery)>0){
				echo "This employee id already registered";
			}else{
				$sqlCheckEmail ="SELECT*FROM `user_gv` WHERE `email` LIKE '$txtEmail'";
				$emailQuery = mysqli_query($conn,$sqlCheckEmail);
				if(mysqli_num_rows($emailQuery)>0){
					echo "This email is already registered, Type another email";
				}else{
					
					$sql_register = "INSERT INTO `user_gv`(`dangkyboi`,`taikhoan_id`,`tentaikhoan`,`email`,`matkhau`,`dienthoai`,`gioitinh`,`trangthai1`,`trangthai2`) VALUES
					
						('$txtRegisterBy','$txtUserId','$txtUserName','$txtEmail','$txtPassword','$txtMobile','$selectGender','$txtStatus1','$txtStatus2')";
					
					
					if(mysqli_query($conn,$sql_register)){
						echo "Successfully Registered";
					}else{
						echo "Failed to register, try again";
					}
				}
			}
		}
	}
	else{
		echo "Connection Error, Contact to Admin";
	}
	
	*/
	

	
	
	
	
			
			
			

?>
		
			
			
			
