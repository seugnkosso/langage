<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\View;

class ProductController extends Controller
{
    public function index(){
        $nom = "kosso";
        $categorie = "dev web";
        $produits = ["ordinateur", "imprimante", "serveur"];

        return view('produits.index',
        [
            'name' => $nom,
            'categorie' => $categorie,
            'produits' => $produits
        ]);
    }

    public function create(){
        return view('produits.store');
    }
    public function store(Request $request){
        dd($request->all());
        return view('produits.store');
    }
    public function edit($id){
        return view('produits.edit',['id'=>$id]);
    }
    public function update(Request $request,$id){

        dd($request->all());
    }

    public function show(){
        return view('produits.show');
    }
}
