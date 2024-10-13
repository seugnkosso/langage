from typing import Any
from django.db.models.query import QuerySet
from django.shortcuts import render
from django.urls import reverse_lazy
from django.views.generic import ListView,CreateView,UpdateView,DeleteView
from django import forms, template


from core.config.const import constente
from core.forms.ownerForm import OwnerForm
from core.models import Owner

class OwnerlistView(ListView):
    model = Owner
    context_object_name = 'Owners'
    paginate_by = constente.get('page_by')
    template_name = 'owner/list.html'
    page_kwarg = 'p'
    
    
    def get_queryset(self):
        telClient = self.request.GET.get('tel')
        if telClient:
            return Owner.objects.filter(tel__icontains=telClient)
        return Owner.objects.all()
    
    def get_context_data(self):
        self.object_list = self.get_queryset()
        context = super().get_context_data()
        context['title'] = 'Owners'
        context['data_path'] = constente.get('data_path')
        if self.request.GET.get('tel'):
            context['telClient'] = self.request.GET.get('tel')
        else:
            context['telClient'] = ''    
        return context
    
    
    
class OwnerCreateView(CreateView):        
    model = Owner
    form_class = OwnerForm
    template_name = 'owner/create.html'
    success_url = reverse_lazy('OwnersList')
    
class OwnerUpdateView(UpdateView):        
    model = Owner
    form_class = OwnerForm
    template_name = 'owner/create.html'
    success_url = reverse_lazy('OwnersList')

            
        
        
    


    