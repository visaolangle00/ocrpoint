<?php

    require "config.php";
    
    // PRUEBAS
    //$usuario = "cheko";
    
    $sql = "SELECT * FROM sv";
    $query = mysqli_query($conn,$sql);
    
    $sinhvien = array();
    
    while($resultsinhvien = $query->fetch_assoc()) {
        $sinhvien[] = $resultsinhvien;
    }
    
    //echo json_encode($datos);
    echo json_encode(array("Fitter" => $sinhvien));
	
	 header('Content-Type: application/json');
?>
