<?php

use App\Http\Controllers\AboutController;
use App\Http\Controllers\HomeController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ProductController;

// nommage des routes
Route::get('/',[HomeController::class,'home'])->name('home');

Route::get('/products',[ProductController::class,'index'])->name('products'); // afficher les produit
Route::get('/products/create',[ProductController::class,'create'])->name('product.create'); // afficher le formulaire de création
Route::post('/products',[ProductController::class,'store'])->name('product.store'); // fonction de d'ajout d'un produit
Route::get('/products/{id}/edit',[ProductController::class,'edit'])->name('products.edit'); // afficher le formulaire de modification
Route::put('/products/{id}',[ProductController::class,'update'])->name('products.update'); //fonction qui fait la modification

Route::get('/about/{id}',[AboutController::class,'showAbout'])->name('about');

// Route::get('/',[HomeController::class,'home']);

// importer la fonction du controller
// Route::get('/products',[ProductController::class,'index']);

// ajout de parametre
// Route::get('/about/{id}',[AboutController::class,'showAbout']);
