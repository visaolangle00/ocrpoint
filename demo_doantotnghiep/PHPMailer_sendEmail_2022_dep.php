<?php 
//include("../config.php"); 

header('Content-Type: text/html; charset=utf-8');

require("config.php");

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\SMTP;
use PHPMailer\PHPMailer\Exception;

require 'PHPMailer/src/Exception.php';

require 'PHPMailer/src/PHPMailer.php';

require 'PHPMailer/src/SMTP.php';

  
 $email = strip_tags(trim((isset($_POST['email']) ? $_POST['email'] : '')));
 
 $taikhoan_id='';
  
$sql_query = "SELECT * FROM `taikhoan_gv` WHERE email LIKE '$email'"; 
var_dump($sql_query);
$result_Users = $conn->query($sql_query);
		while($row = $result_Users->fetch_assoc()) {				    
			$taikhoan_id = $row['taikhoan_id'];
			//$matkhau = $row['matkhau'];
			$email = $row['email'];
			//$AVLink = $row['Avatar'];
		    }
			


if ($email == $email){

$NewPass = substr(str_shuffle("abcdefghijklmnopqrstuvwxyz"), 0, 5);
$md5Pass = ($NewPass);
	$sqlPass = "UPDATE `taikhoan_gv` SET matkhau='$md5Pass' WHERE email LIKE '$email'";
	$conn->query($sqlPass);
	
	//$imgAvatar = "http://192.168.1.193/forgotpassword/uploads/".$AVLink;

	//$imgAvatar = "https://www.yourSite/Images/".$AVLink;
 
			
$mail = new PHPMailer();
$mail->CharSet = 'UTF-8';
$mail->IsSMTP();
//$mail->Host = "smtp.flockmail.com";

$mail->Host = "smtp.gmail.com";

$mail->SMTPAuth = true;








/*
$mail->Username = "visaolangle00@gmail.com";
$mail->Password = "nguyenminhhiep";
*/


    $mail->isSMTP();                                            //Send using SMTP
    $mail->Host       = 'smtp.gmail.com';                     //Set the SMTP server to send through
    $mail->SMTPAuth   = true;                                   //Enable SMTP authentication
    $mail->Username   = 'untilkill101@gmail.com';                     //SMTP username
    $mail->Password   = 'ebswipaowqsdsoxd';   
    
    //$mail->Password   = 'Linhnhi12';    //SMTP password
    $mail->SMTPSecure = PHPMailer::ENCRYPTION_SMTPS;            //Enable implicit TLS encryption
    $mail->Port       = 465;                                    //TCP port to connect to; use 587 if you have set `SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS`

    //Recipients
    $mail->setFrom('visaolangle00@gmail.com', 'Doggy');
    $mail->addAddress('untilkill101@gmail.com', 'Joe User');  


//gui den
$mail->AddAddress("{$email}");
$mail->WordWrap = 50;
$mail->IsHTML(true);
            
$mail->Subject = "Kh??i ph???c m???t kh???u";
$mail->Body    = "
<table border='0' width='50%' cellspacing='0' cellpadding='0'>
<tr>
	<td align='center'>
	
<p>&nbsp;</p>
<table border='0' width='75%' cellspacing='1' style='border-collapse: collapse' bordercolor='#FF9900' bgcolor='#EFEFF4'>

<tr>
	<td colspan='2'>
	<p align='center'>
	
	



</tr>
<tr>
	<td align='center' width='100%' colspan='2'>
	<font size='4'>Xin Ch??o <font color='orange'>{$username}<br>
	</font>Kh??i ph???c d??? li???u t??? m???t ???ng d???ng  <br>C?? s??? d??? li???u MySql</a></font></td>
</tr>
<tr>
	<td align='left' width='50%'><b>&nbsp; t??n emp_id &nbsp;</b></td>
	<td align='right' width='50%'><p align='right'><b><span lang='ar-om'>&nbsp; <font color='red'>{$taikhoan_id}</font>  &nbsp; </span>
	</b></td>
</tr>
<tr>
	<td align='left' width='50%'><b>&nbsp; m???t kh???u &nbsp;</b></td>
	<td align='right' width='50%'><p align='right'><b><span lang='ar-om'>&nbsp; <font color='red'>{$NewPass}</font>  &nbsp; </span>
	</b></td>
</tr>

<br>
<br>
<tr></td>
<p><span style='font-size: 12px; '>

<br>
</td></tr>

</td>
</tr>
</table>
</td>
</tr>
</table>

";


			if(!$mail->Send())
			{
			   $check = "Send_Error";   			
			   echo "Mailer Error: " . $mail->ErrorInfo;
			   exit;
			}else{
				$check = "Send_OK";       
			}

}else{
$check = "No_Email";    
}

  $json_re=array();
	array_push($json_re,array("success"=>$check));
    echo json_encode($json_re);   

?> 
  