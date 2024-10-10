from django.contrib import admin

from core.models import Address, Admin, Agent, Owner, Real_estate, Rental, Tenant

# Register your models here.

@admin.register(Admin)
class AdminAdmin(admin.ModelAdmin):
    list_display = [
                    'full_name',
                    'username',
                    'password',
                    'tel',
                    'email',
                    'type',
                    ]

@admin.register(Agent)
class AgentAdmin(admin.ModelAdmin):
    list_display = [
                'full_name',
                'username',
                'password',
                'tel',
                'email',
                'type',
                    ]

@admin.register(Tenant)
class TenantAdmin(admin.ModelAdmin):
    list_display = [
                    'full_name',
                    'username',
                    'password',
                    'tel',
                    'email',
                    'type',
                    ]

@admin.register(Owner)
class OwnerAdmin(admin.ModelAdmin):
    list_display = [
                    'full_name',
                    'username',
                    'password',
                    'tel',
                    'email',
                    'type',
                    ]

@admin.register(Rental)
class RentalAdmin(admin.ModelAdmin):
    list_display = [
                    'price',
                    'tenant',
                    'real_e',
                    ]
    
@admin.register(Address)
class AddressAdmin(admin.ModelAdmin):
    list_display = [
                    'municipality',
                    'neighborhood',
                    'street',
                    ]
    
@admin.register(Real_estate)
class Real_estate(admin.ModelAdmin):
    list_display = [
                    'libel',
                'description',
                'coordinate',
                'price',
                'img1',
                'img2',
                'img3',
                'img4',
                'state',
                'owner',
                'addres',
                    ]
    
    
