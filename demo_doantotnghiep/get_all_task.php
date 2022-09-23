<?php

	include"config.php";
	
	$gv_id=(isset($_POST['gv_id']) ? $_POST['gv_id'] : '');
	 
	 $query="SELECT tenmon,monhoc_id,tkb,sotinchi,gv_id,lich FROM monhoc where gv_id='$gv_id'";
	 
	
	 //$query="SELECT * FROM tbl_task ";
	 
	 $result=mysqli_query($conn,$query);
	 
	 // $tasks = array();
	 
	 $monhocs=array();
	  
	 

	if($result){
		while ($row = mysqli_fetch_array($result)){
			$monhoc = array(
			
			
					"tenmon" => $row['tenmon'],
					"monhoc_id" => $row['monhoc_id'],
					"tkb" => $row['tkb'],
					"sotinchi" => $row['sotinchi'],
					"gv_id" => $row['gv_id'],
					"lich" => $row['lich']
			);
			array_push($monhocs, $monhoc);
		}
		echo json_encode(array ("monhocs" => $monhocs));
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
  ?>