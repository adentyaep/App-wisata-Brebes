<?php

namespace App\Http\Controllers;

use App\Models\Hotel;
use Illuminate\Http\Request;


class HotelController extends Controller
{
    public function index(){
        
        $data_hotel = Hotel::all();
        return view('hotel.index', compact(['data_hotel']));
    }

    public function create(){
        return view('hotel.create');
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


        Hotel::create([
            'nama_hotel' => $request->frNamaHotel,
            'alamat' => $request->frAlamat,
            'desa' => $request->frDesa,
            'kecamatan' => $request->frKecamatan,
            'kabupaten' => $request->frKabupaten,
            'latitude' => $request->frLatitude,
            'longitude' => $request->frLongitude,
            'deskripsi' => $request->frDeskripsi,
            'gambar' => $imgName
        ]);

        return redirect('/hotel');
        // dd($request->all());
    }

    public function delete($id){
        Hotel::find($id)->delete();
       return redirect('/hotel');
    }

    public function edit($id){
       $data = Hotel::find($id);
        return view('hotel.edit', compact('data'));
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

            $data = Hotel::find($id)->update([
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
            
        
        
        
        return redirect('/hotel');
    }
}
