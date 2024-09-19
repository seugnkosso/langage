<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class HomeController extends Controller
{
    // Utiliser la classe Request pour intercepter les requète
    public function home(Request $request){
        $name = "kosso";
        return view('welcome',['name' => $name]);
    }
}
