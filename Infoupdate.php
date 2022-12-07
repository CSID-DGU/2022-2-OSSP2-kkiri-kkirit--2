<?php
    $con = mysqli_connect("localhost", "root", "", "appfood");
    mysqli_query($con,'SET NAMES utf8');
    
    $editUserName = $_POST["editUserName"];
    $editUserPass = $_POST["editUserPass"];
    $editUserAge = $_POST["editUserAge"];
    $editUserId= $_POST["editUserId"];

    $statement = mysqli_prepare($con, "UPDATE user SET userPassword = ?, userName = ?, userAge = ? WHERE userID = ?");
    mysqli_stmt_bind_param($statement, "ssss", $editUserPass, $editUserName, $editUserAge, $editUserId);
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;

    echo json_encode($response);
?>