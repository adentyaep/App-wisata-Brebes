<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Restoran extends Model
{
    use HasFactory;

    protected $table = "data_restoran";

    protected $fillable = [
        'nama_restoran',
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
