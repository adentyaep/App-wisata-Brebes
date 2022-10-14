<?php

use App\Http\Controllers\HotelController;
use App\Http\Controllers\RestoranController;
use App\Http\Controllers\UserController;
use App\Http\Controllers\WisataController;
use App\Models\Wisata;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', [WisataController::class, 'index']);
Route::get('/wisata', [WisataController::class, 'index']);
Route::get('/wisata/create', [WisataController::class, 'create']);
Route::post('/wisata/tambah', [WisataController::class, 'tambah']);
Route::get('/wisata/delete/{id}', [WisataController::class, 'delete']);
Route::get('/wisata/edit/{id}', [WisataController::class, 'edit']);
Route::post('/wisata/update/{id}', [WisataController::class, 'update']);

Route::get('/hotel', [HotelController::class, 'index']);
Route::get('/hotel/create', [HotelController::class, 'create']);
Route::post('/hotel/tambah', [HotelController::class, 'tambah']);
Route::get('/hotel/delete/{id}', [HotelController::class, 'delete']);
Route::get('/hotel/edit/{id}', [HotelController::class, 'edit']);
Route::post('/hotel/update/{id}', [HotelController::class, 'update']);

Route::get('/restoran', [RestoranController::class, 'index']);
Route::get('/restoran/create', [RestoranController::class, 'create']);
Route::post('/restoran/tambah', [RestoranController::class, 'tambah']);
Route::get('/restoran/delete/{id}', [RestoranController::class, 'delete']);
Route::get('/restoran/edit/{id}', [RestoranController::class, 'edit']);
Route::post('/restoran/update/{id}', [RestoranController::class, 'update']);

// Route::get('/user', [UserController::class, 'index']);
// Route::post('/user/checkLogin', [UserController::class, 'checkLogin']);


