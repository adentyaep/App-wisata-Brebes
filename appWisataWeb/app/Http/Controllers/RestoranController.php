<?php

namespace App\Http\Controllers;

use App\Models\Restoran;

use Illuminate\Http\Request;

class RestoranController extends Controller
{
    public function index(){
        
        $data_restoran = Restoran::all();
        return view('restoran.index', compact(['data_restoran']));
    }

    public function create(){
        return view('restoran.create');
    }

    public function tambah(Request $request){
        // $request->validate([
        //     'frNamaWisata' => 'required',
        //     'frAlamat' => 'required',
        //     'frDesa' => 'required',
        //     'frKecamatan' => 'required',
        //     'frKabupaten' => 'required',
        //     'frLatitude' => 'required',
        //     'frLongitude' => 'required',
        //     'frDeskripsi' => 'required',
        //     'frGambar' => 'required',
        // ]);

        

        $imgName = $request->frGambar->getClientOriginalName() . '-' . time() . '.' . $request->frGambar->extension();
        

        $request->frGambar->move(public_path('image'), $imgName);


        Restoran::create([
            'nama_restoran' => $request->frNamaRestoran,
            'alamat' => $request->frAlamat,
            'desa' => $request->frDesa,
            'kecamatan' => $request->frKecamatan,
            'kabupaten' => $request->frKabupaten,
            'latitude' => $request->frLatitude,
            'longitude' => $request->frLongitude,
            'deskripsi' => $request->frDeskripsi,
            'gambar' => $imgName
        ]);

        return redirect('/restoran');
        // dd($request->all());
    }

    public function delete($id){
        Restoran::find($id)->delete();
       return redirect('/restoran');
    }

    public function edit($id){
       $data = Restoran::find($id);
        return view('restoran.edit', compact('data'));
    }

    public function update(Request $request, $id){
        // $request->validate([
        //     'id_jenis' => 'required|max:5',
        //     'type_mobil' => 'required|max:25|min:4',
        //     'merk' => 'required|max:25|min:4',
        //     'no_polisi' => 'required|max:25|min:4',
        //     'warna' => 'required|max:25|min:4',
        //     'harga' => 'required|max:15|min:4',
        // ]);

            $imgName = $request->foto_lama;

        
            if($request->frGambar){
                $imgName = $request->frGambar->getClientOriginalName() . '-' . time() . '.' . $request->frGambar->extension();

                $request->frGambar->move(public_path('image'), $imgName);
                
            }

            $data = Restoran::find($id)->update([
                'nama_wisata' => $request->frNamaHotel,
                'alamat' => $request->frAlamat,
                'desa' => $request->frDesa,
                'kecamatan' => $request->frKecamatan,
                'kabupaten' => $request->frKabupaten,
                'latitude' => $request->frLatitude,
                'longitude' => $request->frLongitude,
                'deskripsi' => $request->frDeskripsi,
                'gambar' => $imgName
            ]);
            
        
        
        
        return redirect('/restoran');
    }
}
