@extends ('layouts.app')

@section ('content')
    <div class="container mt-5">
        <div class="mb-2">
            <h2>Form Edit Data Hotel</h2>
        </div>

        <form action="/hotel/update/{{$data->id}}" method="post" enctype="multipart/form-data">
            @csrf
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">Nama Hotel</label>
                <input type="text" class="form-control" name="frNamaHotel" value="{{ old('nama_hotel') ? old('nama_hotel') : $data->nama_hotel }}">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput2" class="form-label">Alamat</label>
                <input type="text" class="form-control" name="frAlamat" value="{{ old('alamat') ? old('alamat') : $data->alamat }}">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">Desa</label>
                <input type="text" class="form-control" name="frDesa" value="{{ old('desa') ? old('desa') : $data->desa }}">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput2" class="form-label">Kecamatan</label>
                <input type="text" class="form-control" name="frKecamatan" value="{{ old('kecamatan') ? old('kecamatan') : $data->kecamatan }}">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">Kabupaten</label>
                <input type="text" class="form-control" name="frKabupaten" value="{{ old('kabupaten') ? old('kabupaten') : $data->kabupaten }}">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput2" class="form-label">Latitude</label>
                <input type="text" class="form-control" name="frLatitude" value="{{ old('latitude') ? old('latitude') : $data->latitude }}">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">Longitude</label>
                <input type="text" class="form-control" name="frLongitude" value="{{ old('longitude') ? old('longitude') : $data->longitude }}">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput2" class="form-label">Deskripsi</label>
                <textarea class="form-control" placeholder="Masukkan Deskripsi" name="frDeskripsi" style="height: 100px">{{$data->deskripsi}}</textarea>
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput2" class="form-label">Gambar</label>
                <input type="file" class="form-control" name="frGambar" placeholder="Pilih file gambar">
                <input type="hidden" name="foto_lama"  class="form-control" value="{{ $data->gambar }}">
            </div>
            <div class="mb-3">
                <input type="submit" value="Simpan" class="btn btn-success mt-2">
                <a href="/wisata" class="btn btn-danger mt-2">Kembali</a>
            </div>
        </form>
    </div>
    
@endsection