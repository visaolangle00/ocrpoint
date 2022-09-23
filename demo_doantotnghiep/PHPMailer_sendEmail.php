<?php 
//include("../config.php"); 

header('Content-Type: text/html; charset=utf-8');

require("config.php");

  
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
 
require("PHPMailer_6/class.phpmailer.php");
			
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


$mail->Username = "hiepnm52@wru.vn";
$mail->Password = "nhungdinh";


// gui di
$mail->From = "hiepnm52@wru.vn";
$mail->SMTPSecure = "tls";
$mail->Port = 587;
$mail->FromName = "hiepnm52@wru.vn";


//gui den
$mail->AddAddress("{$email}");
$mail->WordWrap = 50;
$mail->IsHTML(true);
            
$mail->Subject = "Khôi phục mật khẩu";
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
	<font size='4'>Xin Chào <font color='orange'>{$username}<br>
	</font>Khôi phục dữ liệu từ một ứng dụng  <br>Cơ sở dữ liệu MySql</a></font></td>
</tr>
<tr>
	<td align='left' width='50%'><b>&nbsp; tên emp_id &nbsp;</b></td>
	<td align='right' width='50%'><p align='right'><b><span lang='ar-om'>&nbsp; <font color='red'>{$taikhoan_id}</font>  &nbsp; </span>
	</b></td>
</tr>
<tr>
	<td align='left' width='50%'><b>&nbsp; mật khẩu &nbsp;</b></td>
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
  