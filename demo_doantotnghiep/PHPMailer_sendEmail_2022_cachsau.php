

<?php
//Import PHPMailer classes into the global namespace
//These must be at the top of your script, not inside a function
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\SMTP;
use PHPMailer\PHPMailer\Exception;

require 'PHPMailer/src/Exception.php';

require 'PHPMailer/src/PHPMailer.php';

require 'PHPMailer/src/SMTP.php';

require("config.php");

//Load Composer's autoloader


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













//Create an instance; passing `true` enables exceptions
$mail = new PHPMailer(true);

try {
	
	
	$NewPass = substr(str_shuffle("abcdefghijklmnopqrstuvwxyz"), 0, 5);
$md5Pass = ($NewPass);
	$sqlPass = "UPDATE `taikhoan_gv` SET matkhau='$md5Pass' WHERE email LIKE '$email'";
	$conn->query($sqlPass);
	
	//$imgAvatar = "http://192.168.1.193/forgotpassword/uploads/".$AVLink;

	//$imgAvatar = "https://www.yourSite/Images/".$AVLink;
	
	
	
	
	
    //Server settings
    //$mail->SMTPDebug = SMTP::DEBUG_SERVER;                      //Enable verbose debug output
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
    
    
    //Add a recipient
    /*
    $mail->addAddress('ellen@example.com');               //Name is optional
    $mail->addReplyTo('info@example.com', 'Information');
    $mail->addCC('cc@example.com');
    $mail->addBCC('bcc@example.com');

    */

    //Attachments

    //$mail->addAttachment('/var/tmp/file.tar.gz');         //Add attachments
   // $mail->addAttachment('/tmp/image.jpg', 'new.jpg');    //Optional name

    //Content
    $mail->isHTML(true);                                  //Set email format to HTML
    $mail->Subject = 'Here is the subject';
    $mail->Body    = 'This is the HTML message body <b>in bold!</b>';
    //$mail->AltBody = 'This is the body in plain text for non-HTML mail clients';

    $mail->send();
    echo 'Message has been sent';
} catch (Exception $e) {
    echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
}