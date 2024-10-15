from django.forms.models import BaseModelForm
from django.http import HttpRequest, HttpResponse
from django.shortcuts import redirect
from django.urls import reverse_lazy
from django.views import View
from django.views.generic import ListView,CreateView,UpdateView
from core.config.const import constente

from core.forms.real_estateForm import Real_estateForm
from core.forms.rentalForm import RentalForm
from core.models import Real_estate, Rental, Tenant

class listRentalView(ListView):
    model = Rental
    context_object_name = 'rentals'
    paginate_by = constente.get('page_by')
    template_name = 'rental/list.html'
    page_kwarg = 'p'
    
    def get_queryset(self):
        telClient = self.request.GET.get('tel')
        if telClient:
            return Rental.objects.filter(tenant__tel__icontains=telClient)
        return Rental.objects.all()
    
    def get_context_data(self):
        self.object_list = self.get_queryset()
        context = super().get_context_data()
        context['title'] = 'rentals'
        context['data_path'] = constente.get('data_path')
        if self.request.GET.get('tel'):
            context['telClient'] = self.request.GET.get('tel')
        else:
            context['telClient'] = ''    
        return context
    
    
class createRentalView(CreateView):
    model = Rental
    form_class = RentalForm
    template_name = 'rental/create.html'
    success_url = reverse_lazy('rentalList') 
    
    def post(self, request: HttpRequest, *args: str, **kwargs: reverse_lazy) -> HttpResponse:                              
        real_estate = Real_estate.objects.filter(id=self.request.POST.get('real_e'))              
        tenant = Tenant.objects.get(id=self.request.POST.get('tenant'))        
        rental = Rental()
        if self.request.POST.get('price') != '':
            rental.price = self.request.POST.get('price')
        else:
            rental.price = real_estate.first().price        
        rental.tenant = tenant
        rental.real_e = real_estate.first()
        rental.save()        
        real_estate.update(state='en location')
        return  redirect('/rentals')
    
                            
class UpdateRentalView(UpdateView):
    model = Rental
    form_class = RentalForm
    template_name = 'rental/create.html'
    success_url = reverse_lazy('rentalList')

def get(request: HttpRequest, *args: str, **kwargs: reverse_lazy) -> HttpResponse:
        ident = int(kwargs.get('id'))
        rental = Rental.objects.get(id=ident)        
        rental.real_e.state = 'disponible'
        rental.real_e.save()
        rental.tenant = None
        rental.real_e = None
        rental.delete()
        return  redirect('/rentals')

    