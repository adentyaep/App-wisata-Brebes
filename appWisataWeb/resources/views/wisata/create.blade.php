@extends ('layouts.app')

@section ('content')
    <div class="container mt-5">
        <div class="mb-2">
            <h2>Form Tambah Data Wisata</h2>
        </div>

        <form action="/wisata/tambah" method="post" enctype="multipart/form-data">
            @csrf
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">Nama Wisata</label>
                <input type="text" class="form-control" name="frNamaWisata" placeholder="Masukkan nama wisata">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput2" class="form-label">Alamat</label>
                <input type="text" class="form-control" name="frAlamat" placeholder="Masukkan alamat">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">Desa</label>
                <input type="text" class="form-control" name="frDesa" placeholder="Masukkan Desa">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput2" class="form-label">Kecamatan</label>
                <input type="text" class="form-control" name="frKecamatan" placeholder="Masukkan kecamatan">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">Kabupaten</label>
                <input type="text" class="form-control" name="frKabupaten" placeholder="Masukkan kabupaten">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput2" class="form-label">Latitude</label>
                <input type="text" class="form-control" name="frLatitude" placeholder="Masukkan latitude wisata">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">Longitude</label>
                <input type="text" class="form-control" name="frLongitude" placeholder="Masukkan longitude wisata">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput2" class="form-label">Deskripsi</label>
                <textarea class="form-control" placeholder="Masukkan Deskripsi" name="frDeskripsi" style="height: 100px"></textarea>
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput2" class="form-label">Gambar</label>
                <input type="file" class="form-control" name="frGambar" placeholder="Pilih file gambar">
            </div>
            <div class="mb-3">
                <input type="submit" value="Simpan" class="btn btn-success mt-2">
                <a href="/wisata" class="btn btn-danger mt-2">Kembali</a>
            </div>
        </form>
    </div>
    
@endsection