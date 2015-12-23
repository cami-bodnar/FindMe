<?php


$username = "u904130616_root";
$password = "findme";
$hostname = "mysql.hostinger.in"; 
$dbName   = "u904130616_findm";

//connection to the database
$connect = mysqli_connect($hostname, $username, $password, $dbName)
or die("Unable to connect to MySQL");
echo "Connected to MySQL<br>";
createUser();




function createUser()
{
	
	global $connect;
	$response = array();
	if(isset($_POST['username'])&& isset($_POST['email']) && isset($_POST['password']))
	{
	$name  = $_POST['username'];
	$email = $_POST['email'];
	$password = $_POST['password'];
	
	
	$query = "Insert into user(username,email,password) values ('$name','$email','$password');";
	
	$result = mysqli_query($connect, $query) or die (mysqli_error($connect));
	// chech if row inserted or not 
	if ($result)
	{
		//successfully into db 
	//	$response["success"] = 1;
		//$response["message"] = "user successfully inserted";
		echo "user successfully inserted";
		//echoing Json response
		//echo json_encode($response);
	}
	else 
	{
		//successfully into db 
		$response["success"] = 0;
		$response["message"] = "An error occured";
		echo "An error occured";
		//echoing Json response
		//echo json_encode($response);
	}
	}
	else 
	{
		
		
		//successfully into db 
		$response["success"] =0;
		$response["message"] = "Required field(s) is missing ";
		echo "Required field(s) is missing";
		//echoing Json response
		//echo json_encode($response);
	}
		
	
	mysqli_close($connect);
	
}
	
	


?>