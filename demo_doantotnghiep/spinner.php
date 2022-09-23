<?php

ob_start();

require 'config.php';

$result=mysqli_query($conn,"select A.sv_id, B.tensv, B.lopql, A.diem_gk from sv_hocphan A join sv B on A.sv_id=B.sv_id;");

//tenmon,masv,tensv  


//select A.MaMon ,B.TenSV, B.TenLop from monhocdangky A join sinhvien B on A.MaSV =B.MaSV



$response = array();
$response["lophocphan"] = array();
if(mysqli_num_rows($result)>0)
{
	/*
	while($row=mysqli_fetch_array($result))
	{
	$tmp=array();
	$tmp["tenlop"]=$row["TenLop"];
	$tmp["masv"]=$row["MaSV"];
	$tmp["tensv"]=$row["TenSV"];
	array_push($response["sinhvienlop"],$tmp);
	}
	*/
	
	
	
	while($row=mysqli_fetch_array($result))
	{
	$tmp=array();
	$tmp["sv_id"]=$row["sv_id"];
	$tmp["tensv"]=$row["tensv"];
	$tmp["lopql"]=$row["lopql"];
	$tmp["diem_gk"]=$row["diem_gk"];
	array_push($response["lophocphan"],$tmp);
	}

}
else
{
	
}
echo json_encode($response);

  header('Content-Type: application/json');
  //ob_enf_fluch();
  

?>

