<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class AboutController extends Controller
{
    public function showAbout($id){
        return view('about',['id'=>$id]);
    }
}
