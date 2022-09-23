<?php

	include"config.php";
	
	$gv_id=(isset($_POST['gv_id']) ? $_POST['gv_id'] : '');
	 
	 $query="SELECT * FROM monhoc where gv_id='$gv_id'";
	 
	
	 //$query="SELECT * FROM tbl_task ";
	 
	 $result=mysqli_query($conn,$query);
	 
	 // $tasks = array();
	 
	 $thoikhoabieus=array();
	  
	 

	if($result){
		while ($row = mysqli_fetch_array($result)){
			$thoikhoabieu = array(
			
			
					//"MaMon" => $row['MaMon'],
					"TenMon" => $row['TenMon'],
					"TKB" => $row['TKB']
					//"MaSV" => $row['MaSV'],
					//"GV_ID" => $row['GV_ID']
			);
			array_push($thoikhoabieus, $thoikhoabieu);
		}
		echo json_encode(array ("thoikhoabieus" => $thoikhoabieus));
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
  ?>