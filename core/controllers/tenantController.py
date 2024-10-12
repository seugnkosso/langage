from typing import Any
from django.db.models.query import QuerySet
from django.shortcuts import render
from django.views.generic import ListView,CreateView

from core.config.const import constente
from core.models import Tenant

class TenantlistView(ListView):
    model = Tenant
    context_object_name = 'tenants'
    paginate_by = constente.get('page_by')
    template_name = 'tenant/list.html'
    page_kwarg = 'p'
    
    
    def get_queryset(self):
        telClient = self.request.GET.get('tel')
        if telClient:
            return Tenant.objects.filter(tel__icontains=telClient)
        return Tenant.objects.all()
    
    def get_context_data(self):
        self.object_list = self.get_queryset()
        context = super().get_context_data()
        context['title'] = 'tenants'
        context['data_path'] = constente.get('data_path')
        if self.request.GET.get('tel'):
            context['telClient'] = self.request.GET.get('tel')
        else:
            context['telClient'] = ''    
        return context
    
    
    
# class TenantView(CreateView):

    