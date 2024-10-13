from django.urls import path

from core.controllers.addressController import AddressCreateView, AddressUpdateView, AddresslistView
from core.controllers.ownerController import OwnerCreateView, OwnerUpdateView, OwnerlistView
from core.controllers.realEstateController import listRealEstateView
from core.controllers.tenantController import TenantCreateView, TenantDeleteView, TenantUpdateView, TenantlistView





urlpatterns = [
    path('tenants',TenantlistView.as_view(), name = 'tenantsList'),
    path('tenants/create',TenantCreateView.as_view(), name = 'tenantsCreate'),
    path('tenants/update/<int:pk> ',TenantUpdateView.as_view(), name = 'tenantsUpdate'),

    
    path('owners',OwnerlistView.as_view(), name = 'OwnersList'),
    path('owners/create',OwnerCreateView.as_view(), name = 'OwnersCreate'),
    path('owners/update/<int:pk> ',OwnerUpdateView.as_view(), name = 'OwnersUpdate'),
    
    path('address',AddresslistView.as_view(), name = 'addressList'),
    path('address/create',AddressCreateView.as_view(), name = 'addressCreate'),
    path('address/update/<int:pk> ',AddressUpdateView.as_view(), name = 'addressUpdate'),
    
    path('real_estate',listRealEstateView.as_view(),name='real_estateList')
]