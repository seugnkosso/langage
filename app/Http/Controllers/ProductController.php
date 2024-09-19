<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\View;

class ProductController extends Controller
{
    public function index(){
        // return "retourner un string"; //on peut retourner un string
        $nom = "kosso";
        $categorie = "dev web";
        $produits = ["ordinateur", "imprimante", "serveur"];
        // return $nom; //on peut retourner une variable

        // return redirect('products/create'); //on peut rediriger vers une autre page
        // return redirect()->route('product.create'); //on peut rediriger vers une autre page avec le nom de la route
        // return redirect()->away('https://www.youtube.com/watch?v=_UqOHEPkGms&list=RDEMrHRJ9PmBmTZM5Uxj6OFzMg&index=2'); //on peut rediriger vers ailleur

        return view('produits.index',
        [
            'name' => $nom,
            'categorie' => $categorie,
            'produits' => $produits
        ]); //on peut retourner une view

        // return response()->json(
        //     [
        //         'nom' => 'dieng',
        //         'prenom' => 'Kosso',
        //         'age' => '25'
        //     ]
        // ); //on peut retourner du json

        // return response()->file(); on peut retourner du file

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
