<?php 
    require_once 'connection.php';
    
    if($con) {
        $username = $_POST['username'];
        $password = $_POST['password'];
        $nama = $_POST['nama'];
        $email = $_POST['email'];
        $levUser = $_POST['levUser'];
        

        $query = "INSERT INTO user(username,password,nama,email,level_user) VALUES('$username','$password','$nama','$email','$levUser')";

        if($username != "" && $password != "" && $nama != "" && $email != ""&& $levUser != "") {
            $result = mysqli_query($con,$query);
            $response = array();

            if($result) {
                array_push($response, array(
                    'status' => 'OK'
                ));
            } else {
                array_push($response, array(
                    'status' => 'FAILED'
                ));
            }
        } else {
            array_push($response, array(
                'status' => 'FAILED'
            ));
        }
    } else {
        array_push($response, array(
            'status' => 'FAILED'
        ));
    }

    echo json_encode(array("server_response" => $response));
    mysqli_close($con);


?>