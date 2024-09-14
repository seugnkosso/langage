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

//        return view('produits.index')->withNom($nom)->withCategorie($categorie)->withProduits($produits);
        // return view('produits.index',
        // [
        //     'name' => $nom,
        //     'categorie' => $categorie,
        //     'produits' => $produits
        // ]);

        if(View::exists('produits.index')){
            return View::make('produits.index')
                    ->with('name',$nom)
                    ->with('categorie',$categorie)
                    ->with('produits',$produits);
        }else{
            return "l'utilateur n'a pas défini";
        }
    }
}
