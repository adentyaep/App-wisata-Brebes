@extends('layouts.app')

@section('content')
    <div class="container">
        <div class="col mt-4">
            <h3>Data User</h3>
        </div>
      
        <table class="table table-striped table-hover mt-3">
            <tr>
                <th>ID</th>
                <th>Nama</th>
                <th>Username</th>
                <th>Email</th>
            </tr>

            @foreach ($data_user as $data)
                <tr>
                    <td>{{$data->id}}</td>
                    <td>{{$data->nama}}</td>
                    <td>{{$data->username}}</td>
                    <td>{{$data->email}}</td>
                </tr>
            @endforeach
          </table>
    </div>
@endsection