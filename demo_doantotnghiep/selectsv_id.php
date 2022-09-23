<?php 

 /*
	$connect = mysqli_connect("localhost","root","","studentpoint");
	mysqli_query($connect, "SETNAMES 'utf8'");

	$query = "SELECT sv_id FROM `sv_hocphan`";

	$data = mysqli_query($connect, $query);

	class listSV{
		function listSV( $sv_id){
		
			$this->sv_id = $sv_id;
                        
		}
	}
	$sv = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($sv, new listSV($row['sv_id']));
	}
	echo json_encode($sv);
	
	header('Content-Type: application/json');
	
	*/
	
	
	function getCities()
{
require 'config.php';
// array for json response
    $response = array();
    $response["lophocphan"] = array();
	

    /*
	$query1 = "DELETE e1 from monhoc e1,monhoc e2 Where e1.TenMon=e2.TenMon AND e1.id>e2.id";
	
	$result1=mysqli_query($conn,$query1);
	
	*/
	
	
	
	/*
	if(mysqli_fetch_array($result)>0){
		//echo "loi";
	}
	else
	*/



    /*
	{
		
		 $sql_query="select * from monhoc;";
    $result=mysqli_query($conn,$sql_query);
	
	while($row = mysqli_fetch_array($result))
	{
        // temporary array to create single category
        $tmp = array();
        $tmp["mamon"] = $row["MaMon"];
        $tmp["tenmon"] = $row["TenMon"];
         
        // push category to final json array
        array_push($response["monhoc"], $tmp);
        }
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
    $sql_query="SELECT sv_id FROM `sv_hocphan`;";
    $result=mysqli_query($conn,$sql_query);
	
	while($row = mysqli_fetch_array($result))
	{
        // temporary array to create single category
        $tmp = array();
               $tmp["sv_id"] = $row["sv_id"];
         
        // push category to final json array
        array_push($response["lophocphan"], $tmp);
        }
		
		
		



// keeping response header to json
    header('Content-Type: application/json');
     
    // echoing json result
    echo json_encode($response);
}
getCities();
	
	
?>