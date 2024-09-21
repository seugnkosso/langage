<?php

namespace Database\Seeders;

use App\Models\Customer;
use Illuminate\Database\Seeder;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;

class CustomerSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run()
    {
        Customer::factory()->count(25)->hasInvoices(5)->create();
        Customer::factory()->count(20)->hasInvoices(3)->create();
        Customer::factory()->count(40)->hasInvoices(6)->create();
        Customer::factory()->count(10)->hasInvoices(9)->create();
        Customer::factory()->count(10)->create();
    }
}
