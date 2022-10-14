<?php

namespace App\Http\Controllers;

use App\Models\Wisata;
use Illuminate\Console\View\Components\Warn;
use Illuminate\Http\Request;

class WisataController extends Controller
{
    public function index(){
        
        $data_wisata = Wisata::all();
        return view('wisata.index', compact(['data_wisata']));
    }

    public function create(){
        return view('wisata.create');
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

        

        $imgName = 'https://wisata.oratakashi.com/image/' . $request->frGambar->getClientOriginalName() . '.' . $request->frGambar->extension();
        

        $request->frGambar->move(public_path('image'), $imgName);


        Wisata::create([
            'nama_wisata' => $request->frNamaWisata,
            'alamat' => $request->frAlamat,
            'desa' => $request->frDesa,
            'kecamatan' => $request->frKecamatan,
            'kabupaten' => $request->frKabupaten,
            'latitude' => $request->frLatitude,
            'longitude' => $request->frLongitude,
            'deskripsi' => $request->frDeskripsi,
            'gambar' => $imgName
        ]);

        return redirect('/wisata');
        // dd($request->all());
    }

    public function delete($id){
        Wisata::find($id)->delete();
       return redirect('/wisata');
    }

    public function edit($id){
       $data = Wisata::find($id);
        return view('wisata.edit', compact('data'));
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
                $imgName = 'https://wisata.oratakashi.com/image/' . $request->frGambar->getClientOriginalName() . '.' . $request->frGambar->extension();

                $request->frGambar->move(public_path('image'), $imgName);
                
            }

            $data = Wisata::find($id)->update([
                'nama_wisata' => $request->frNamaWisata,
                'alamat' => $request->frAlamat,
                'desa' => $request->frDesa,
                'kecamatan' => $request->frKecamatan,
                'kabupaten' => $request->frKabupaten,
                'latitude' => $request->frLatitude,
                'longitude' => $request->frLongitude,
                'deskripsi' => $request->frDeskripsi,
                'gambar' => $imgName
            ]);
            
        
        
        
        return redirect('/wisata');
    }

}
