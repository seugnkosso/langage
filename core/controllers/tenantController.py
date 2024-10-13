from typing import Any
from django.db.models.query import QuerySet
from django.shortcuts import render
from django.urls import reverse_lazy
from django.views.generic import ListView,CreateView,UpdateView,DeleteView
from django import forms, template


from core.config.const import constente
from core.forms.Tenant import TenantForm
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
    
    
    
class TenantCreateView(CreateView):        
    model = Tenant
    form_class = TenantForm
    template_name = 'tenant/create.html'
    success_url = '/tenants'
    
class TenantUpdateView(UpdateView):        
    model = Tenant
    form_class = TenantForm
    template_name = 'tenant/create.html'
    success_url = '/tenants'
    
class TenantDeleteView(DeleteView):        
    model = Tenant
    template_name = 'tenant/delete.html'
    success_url = reverse_lazy('tenantsList') 
            
        
        
    


    