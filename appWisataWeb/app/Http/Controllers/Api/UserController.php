<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use App\Models\User;

class UserController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function login(Request $request)
    {
        $username    = $request->username;
        $password    = $request->password;
        $data        = User::where('username', $username)
            ->where("password", $password)
            ->get()
            ->toArray();
        $response    = array();

        if(count($data) > 0) { 
            // array_push($response, array(
            //     'status' => 'OK'
            // ));
            return response()->json([
                'server_response' => [
                    "status" => 'OK'
                ]
                ], 200);
        } else {
            return response()->json([
                'server_response' => [
                    "status" => 'FAILED'
                ]
                ], 200);
            // array_push($response, array(
            //     'status' => 'FAILED'
            // ));
        }    
    
        //echo json_encode(array("server_response" => $response));
        // dd($response);
    }

    public function tambah(Request $request)
    {

        User::create([
            'username' => $request->username,
            'password' => $request->password,
            'nama'  => $request->nama,
            'email' => $request->email,
        ]);

        return response()->json([
            'server_response' => [
                "status" => 'OK'
            ]
            ], 200);
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }
}
