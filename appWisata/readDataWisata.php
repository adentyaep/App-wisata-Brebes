<?php 
    require_once 'connection.php';
    
    $query = "SELECT * FROM data_wisata";
    $result =  mysqli_query($con, $query);
    $response = array();

    while ($row = mysqli_fetch_array($result)){
        array_push($response, array(
                "id" => $row[0],
                "nama_wisata" => $row[1],
                "alamat" => $row[2],
                "desa" => $row[3],
                "kecamatan" => $row[4],
                "kabupaten" => $row[5],
                "latitude" => $row[6],
                "longitude" => $row[7],
                "deskripsi" => $row[8],
                "gambar" => $row[9]
        ));
    }

    echo json_encode(array("server_response" => $response));
    mysqli_close($con);

?>