<?php
require_once('config.php');
$respon = array();


if($_SERVER['REQUEST_METHOD']=='GET'){
	            
				 
				 $result = mysqli_query($conn,"SELECT * FROM  anh");
				 if( mysqli_num_rows($result) > 0){
					 while ($row = mysqli_fetch_assoc($result)){
						 $respon[] = ($row);
					 }
					 
				 }
				 
				 
				// $ar_result = [
				 
				 
				 //'success'=> true,
				// 'result' => $respon
				 //];
				 
				
      
	  echo json_encode($respon);
}
		 
?>