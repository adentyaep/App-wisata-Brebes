<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Wisata extends Model
{
    use HasFactory;
    
    protected $table = "data_wisata";

    protected $fillable = [
        'nama_wisata',
        'alamat',
        'desa',
        'kecamatan',
        'kabupaten',
        'latitude',
        'longitude',
        'deskripsi',
        'gambar'
    ];
}
