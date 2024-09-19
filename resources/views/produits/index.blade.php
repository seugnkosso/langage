    <x-base.header title="liste des produits"/>
    <a href="{{route('product.create')}}" class="text-blue-600 text-2xl:">create produit</a>
    <ul>
        @foreach ($produits as $produit)
            <li>{{$produit}}</li>
        @endforeach
    </ul>

    {{$global_var}}
    <footer>&copy; kosso beau 2024</footer>
</body>
</html>
