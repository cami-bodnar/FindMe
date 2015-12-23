<?php
$servername = "localhost";
$username = "root";
$password = "";

// Create connection
$conn = new mysqli($servername, $username, $password);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

// Create database
$sql = "CREATE DATABASE findmedb";
if ($conn->query($sql) === TRUE) {
    echo "Database created successfully";
} else {
    echo "Error creating database: " . $conn->error;
}

$sql1 = "CREATE TABLE User (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(45) NOT NULL,
email VARCHAR(45) NOT NULL,
password VARCHAR(40) NOT NULL )";

$sql2 = "CREATE TABLE Group (
idGroup INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(45) NOT NULL,
description VARCHAR(100) NOT NULL,
owner INT(6) NOT NULL )";

$sql3 = "CREATE TABLE UserGroup (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
userId INT(6) NOT NULL,
groupId INT(6) NOT NULL )";

$sql4 = "CREATE TABLE UserLocation (
idLocation INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
user_id INT NOT NULL,
longitude DOUBLE NOT NULL,
latitude Double NOT NULL,
created  DATE )";

$sql5 = "CREATE TABLE Invitation (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
id_group INT NOT NULL,
id_user INT NOT NULL,
isAccepted BOOlean NOT NULL,
created DATE )";

$conn->close();
?>