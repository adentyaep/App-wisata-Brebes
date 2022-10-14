<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('data_hotel', function (Blueprint $table) {
            $table->id();
            $table->string("nama_hotel");
            $table->string("alamat");
            $table->string("desa");
            $table->string("kecamatan");
            $table->string("kabupaten");
            $table->string("latitude");
            $table->string("longitude");
            $table->text("deskripsi");
            $table->string("gambar");
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('data_hotel');
    }
};
