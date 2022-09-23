<?php

	include"config.php";
	
	//$gv_id=(isset($_POST['gv_id']) ? $_POST['gv_id'] : '');
	
	$sv_id=(isset($_POST['sv_id']) ? $_POST['sv_id'] : '');
	 
	 //$query="SELECT * FROM monhoc where gv_id='$gv_id'";
	 
	 $query="select A.diem_gk, A.sv_id, A.lop_id, B.monhoc_id from sv_hocphan A join lophocphan B on A.lop_id=B.lop_id";
	 
	
	 //$query="SELECT * FROM tbl_task ";
	 
	 $result=mysqli_query($conn,$query);
	 
	 // $tasks = array();
	 
	 $monhocs=array();
	  
	 

	if($result){
		while ($row = mysqli_fetch_array($result)){
			 $monhoc = array(
			
			         
			// 		"tenmon" => $row['tenmon'],
			// 		"monhoc_id" => $row['monhoc_id'],
			// 		"tkb" => $row['tkb'],
			// 		"sotinchi" => $row['sotinchi'],
			// 		"gv_id" => $row['gv_id'],
			// 		"lich" => $row['lich']
					
			"lop_id" => $row['lop_id'],
				"sv_id" => $row['sv_id'],
				"monhoc_id" => $row['monhoc_id'],
			
					"diem_gk" => $row['diem_gk']
			 );
			 array_push($monhocs, $monhoc);


		}


		echo json_encode(array ("monhocs" => $monhocs));


		
		
		
       
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
  ?>