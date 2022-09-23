<?php 
	$connect = mysqli_connect("localhost","root","","studentpoint");
	mysqli_query($connect, "SETNAMES 'utf8'");

	$query = "SELECT * FROM sv_hocphan";

	$data = mysqli_query($connect, $query);

	class listSV{
		function listSV($diem_gk,$id, $sv_id, $lop_id){
			$this->diem_gk=$diem_gk;
			$this->id = $id;
			$this->sv_id = $sv_id;
			$this->lop_id = $lop_id;
                        
		}
	}
	$sv = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($sv, new listSV($row['diem_gk'],$row['id'],$row['sv_id'],$row['lop_id'] ));
	}
	echo json_encode($sv);
	
	header('Content-Type: application/json');
?>