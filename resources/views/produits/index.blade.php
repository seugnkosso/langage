    <x-base.header title="liste des produits"/>

    <ul>
        @foreach ($produits as $produit)
            <li>{{$produit}}</li>
        @endforeach
    </ul>

    {{$global_var}}
    <footer>&copy; kosso beau 2024</footer>
</body>
</html>
