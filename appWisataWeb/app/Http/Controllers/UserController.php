<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;

class UserController extends Controller
{
    //
    public function index(){
        
        $data_user = User::all();
        return view('user.index', compact(['data_user']));
    }

    public function checkLogin(Request $request){
        $username    = $request->username;
        $password    = $request->password;
        $data        = User::where('username', $username)->first();
        $cek         = Hash::check($password, $data->password);
        $response    = array();

        if($cek) { 
            array_push($response, array(
                'status' => 'OK'
            ));
        } else {
            array_push($response, array(
                'status' => 'FAILED'
            ));
        }    
    
        //echo json_encode(array("server_response" => $response));
        dd($response);
        //mysqli_close($con);
    }
}
