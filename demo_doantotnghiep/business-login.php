<?php
	require "config.php";
	
	$email =$_POST['email'];
	$matkhau =$_POST['psw'];
	
	$isValidEmail = filter_var($email,FILTER_VALIDATE_EMAIL);
	
	if($conn){
		if($isValidEmail === true){
			echo "This Email is not valid";
		}else{
			
			$sqlCheckEmail ="SELECT*FROM `taikhoan_gv` WHERE `taikhoan_id` LIKE '$email'";
			$emailQuery =mysqli_query($conn,$sqlCheckEmail);
			
			//var_dump($emailQuery);

			if(mysqli_num_rows($emailQuery)>0)
			{
				$sqlLogin ="SELECT*FROM `taikhoan_gv` WHERE `taikhoan_id` LIKE '$email' AND `matkhau` LIKE '$matkhau'";
				$loginQuery = mysqli_query($conn,$sqlLogin);
				if(mysqli_num_rows($loginQuery)>0){
					while($row = mysqli_fetch_array($loginQuery)){
						
						$gv_id = $row['gv_id'];
						$taikhoan_id = $row['taikhoan_id'];
						$tentaikhoan =$row['tentaikhoan'];
						$get_email= $row['email'];
						$trangthai1=$row['trangthai1'];
						$trangthai2=$row['trangthai2'];
						$getmatkhau = $row['matkhau'];
						$dienthoai = $row['dienthoai'];
						
						//echo $emp_id."aaa".$get_email."bbb".$status1."ccc".$status2."ddd".$username."eee".$getpassword."fff".$mobile."nulll";
						
						
				echo $gv_id."1vv".$taikhoan_id."aaa".$get_email."bbb".$trangthai1."ccc".$trangthai2."ddd".$tentaikhoan."eee".$getmatkhau."fff".$dienthoai."nulll";
				
					}
				}else{
						echo "Wrong password";
					}
					
					
				}else{
					echo "This ID is not registered";
				}
			}
			}else{
				echo "Connection Error";
			}
			

?>