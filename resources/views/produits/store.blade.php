@extends('layout.main')
@section('content')
<h1>formulaire de connexion</h1>
<form action="{{route('product.store')}}" method="POST">
    @csrf
    {{-- @if ($errors->any())
        @foreach ($errors->all() as $item)
            {{ $item}}
        @endforeach
    @endif --}}
    <div class="">
        <input type="text" name="nom" placeholder="nom Produit" value="{{old('nom')}}">
        <input type="text" name="prix" placeholder="prix produit">
    </div>
    @error('nom')
        <small class="text-red-500">{{$message}}</small>
    @enderror
    <br>
    <div class="">
        <p>produit neuf</p>
        <input type="checkbox" name="brand_new"> oui/non
    </div>
    <br>
    <div class="">
        <input type="datetime-local" name="expiration">
    </div>
    <br>
    <div class="">
        <input type="file" name="photo">
    </div>
    <br>
    <div class="">
        <textarea name="description" placeholder="description produit" cols="30" rows="10"></textarea>
    </div>
    <br>
    <button class="bg-green-500 px-5 py-2" type="submit">creer le produit</button>
</form>
@endsection
