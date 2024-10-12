from django.urls import path

from core.controllers.tenantController import TenantlistView





urlpatterns = [
    path('tenants',TenantlistView.as_view(), name = 'tenantsList'),
]