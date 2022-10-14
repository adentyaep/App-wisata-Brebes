<?php

use App\Http\Controllers\Api\HotelController;
use App\Http\Controllers\Api\RestoranController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Api\UserController;
use App\Http\Controllers\Api\WisataController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

// Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
//     return $request->user();
// });

Route::controller(UserController::class)->group(function() {
    Route::prefix('users')->group(function () {
        Route::post("/checkLogin", "login");
        Route::post("/tambah", "tambah");
    });
});

Route::controller(WisataController::class)->group(function() {
    Route::prefix('wisata')->group(function () {
        Route::get("/readData", "index");
    });
});

Route::controller(HotelController::class)->group(function() {
    Route::prefix('hotel')->group(function () {
        Route::get("/readData", "index");
    });
});

Route::controller(RestoranController::class)->group(function() {
    Route::prefix('restoran')->group(function () {
        Route::get("/readData", "index");
    });
});