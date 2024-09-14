<?php

use App\Http\Controllers\AboutController;
use App\Http\Controllers\HomeController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ProductController;

// nommage des routes
Route::get('/',[HomeController::class,'home'])->name('home');
Route::get('/products',[ProductController::class,'index'])->name('products');
Route::get('/about/{id}',[AboutController::class,'showAbout'])->name('about');

// Route::get('/',[HomeController::class,'home']);

// importer la fonction du controller
// Route::get('/products',[ProductController::class,'index']);

// ajout de parametre
// Route::get('/about/{id}',[AboutController::class,'showAbout']);
