<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

// creer un routeur get  
Route::get('/hello',function(){
    return view('hello');
});

// Route avec paramettre
Route::get('/hello/{id}',function($id){
    return view('hello',['user_id'=>$id]);
});