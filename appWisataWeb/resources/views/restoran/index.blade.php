@extends('layouts.app')

@section('content')
    <div class="container">
        <div class="col mt-4">
            <h3>Data Restoran</h3>
        </div>
        <div class="col mt-4">
            <a href="/restoran/create" class="btn btn-success">Tambah Data</a>
        </div>
        
        <table class="table table-striped table-hover mt-3">
            <tr>
                <th>ID</th>
                <th>Nama Hotel</th>
                <th>Alamat</th>
                <th>Desa</th>
                <th>Kecamatan</th>
                <th>Kabupaten</th>
                <th>Latitude</th>
                <th>Longitude</th>
                <th>Deskripsi</th>
                <th>Gambar</th>
                <th>Action</th>
            </tr>

            @foreach ($data_restoran as $data)
                <tr>
                    <td>{{$data->id}}</td>
                    <td>{{$data->nama_restoran}}</td>
                    <td>{{$data->alamat}}</td>
                    <td>{{$data->desa}}</td>
                    <td>{{$data->kecamatan}}</td>
                    <td>{{$data->kabupaten}}</td>
                    <td>{{$data->latitude}}</td>
                    <td>{{$data->longitude}}</td>
                    <td>{{$data->deskripsi}}</td>
                    <td>{{$data->gambar}}</td>
                    <td>
                        <div class="col p-2">
                            <a href="/restoran/edit/{{$data->id}}" class="btn btn-warning">Edit Data</a>
                        </div>
                        <div class="col p-2">
                            <a href="/restoran/delete/{{$data->id}}" class="btn btn-danger">Hapus Data</a>
                        </div>
                        
                    </td>
                </tr>
            @endforeach
          </table>
    </div>
@endsection