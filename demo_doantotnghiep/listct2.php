<?php

	include"config.php";
	
	//$gv_id=(isset($_POST['gv_id']) ? $_POST['gv_id'] : '');
	
	$sv_id=(isset($_POST['sv_id']) ? $_POST['sv_id'] : '');
	 
	 //$query="SELECT * FROM monhoc where gv_id='$gv_id'";
	 
	 $query="SELECT A.sv_id, B.tensv, B.lopql, A.lop_id, A.diem_gk from sv_hocphan A join sv B on A.sv_id=B.sv_id where B.sv_id='$sv_id'";
	 
	
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
					
			"sv_id" => $row['sv_id'],
				"tensv" => $row['tensv'],
				"lopql" => $row['lopql'],
				"lop_id" => $row['lop_id'],
					"diem_gk" => $row['diem_gk']
			 );
			 array_push($monhocs, $monhoc);


		}


		echo json_encode(array ("monhocs" => $monhocs));


		
		
		
       
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
  ?>