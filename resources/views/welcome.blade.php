<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>welcome page</h1>
    <ul>
        <li><a href="{{route('home')}}">Home</a></li>
        <li><a href="{{route('about', [id=>12])}}">about</a></li>
        <li><a href="{{route('products')}}">products</a></li>
    </ul>
    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero dolor vero at ullam fugiat voluptates quis, dolorem minima rerum? Qui dolores aliquid vel beatae quos sint in assumenda autem perspiciatis.</p>
</body>
</html>
