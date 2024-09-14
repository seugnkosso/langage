<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class HomeController extends Controller
{
    public function home(){
        $name = "kosso";
        return view('welcome',['name' => $name]);
    }
}
