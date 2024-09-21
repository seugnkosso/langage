<?php

namespace App\Http\filters\v1;
use Illuminate\Http\Request;
use App\Http\filters\ApiFilter;

class CustomerFilter extends ApiFilter
{

    protected $safeParams= [
        'name' => ['eq'],
        'type' => ['eq'],
        'address' => ['eq'],
        'city' => ['eq'],
        'postalCode' => ['eq','gt','lt'],
    ];

    protected $columnMap = [
        'postalCode' => 'postal_code'
    ];

    protected $operatorMap = [
        'eq' => '=',
        'gt' => '>',
        'lt' => '<',
    ];
}
