


<?php
$username ="root";
$password ="";
$host ="localhost";
$dbname ="demo_doantotnghiep";

$conn=mysqli_connect($host,$username,$password,$dbname);
if(!$conn)
{
	echo 'connection error'.mysqli_connect_error();	
}

/*
else{
	echo 'connection success';
}
*/

?>