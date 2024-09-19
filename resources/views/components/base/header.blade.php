<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    @vite(['resources/css/app.css','resources/js/app.js'])
    <title>Document</title>
</head>
<body>
<h1 class="text-red-600 text-4xl">{{$title}}</h1>
<ul class="flex gap-2 text-blue-600">
    <li><a href="{{route('home')}}">Home</a></li>
    <li><a href="{{route('about', 12)}}">about</a></li>
    <li><a href="{{route('products')}}">products</a></li>
</ul>
