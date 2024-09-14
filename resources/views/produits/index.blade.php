<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>hello</title>
</head>
<body>
    <h1>Products page</h1>
    <h2>Salut, {{$name ?? ''}}</h2>
    <h3>Categorie: {{$category ?? ''}}</h3>
    <ul>
        @foreach ($produits as $produit)
            <li>{{$produit}}</li>
        @endforeach
    </ul>

    {{$global_var}}
    <footer>&copy; kosso beau 2024</footer>
</body>
</html>
