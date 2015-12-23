<?php 

$username = "u904130616_root";
$password = "findme";
$hostname = "mysql.hostinger.in"; 
$dbName   = "u904130616_findm";

//connection to the database
$connect = mysqli_connect($hostname, $username, $password, "findMeDB")
  or die("Unable to connect to MySQL");
echo "Connected to MySQL<br>";
 
 //Creating sql query
 $sql = "SELECT * FROM user";
 
 //getting result 
 $r = mysqli_query($con,$sql);
 

 
 //looping through all the records fetched
 while($row = mysqli_fetch_array($r)){
 
	echo ( $row['id']);
	echo (" " );
	echo ($row['username']);
    echo (" ");
 
 }