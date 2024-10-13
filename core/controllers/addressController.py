from django.urls import reverse_lazy
from django.views.generic import ListView,CreateView,UpdateView,DeleteView


from core.config.const import constente
from core.forms.addressForm import AddressForm
from core.models import Address

class AddresslistView(ListView):
    model = Address    
    context_object_name = 'Address'
    paginate_by = constente.get('page_by')
    template_name = 'address/list.html'
    page_kwarg = 'p'
    
    
    def get_queryset(self):
        neighborhood = self.request.GET.get('neighborhood')
        if neighborhood:
            return Address.objects.filter(neighborhood__icontains=neighborhood)
        return Address.objects.all()
    
    def get_context_data(self):
        self.object_list = self.get_queryset()
        context = super().get_context_data()
        context['title'] = 'Address'
        context['data_path'] = constente.get('data_path')
        if self.request.GET.get('neighborhood'):
            context['neighborhood'] = self.request.GET.get('neighborhood')
        else:
            context['neighborhood'] = ''    
        return context
    
    
    
class AddressCreateView(CreateView):        
    model = Address
    form_class = AddressForm
    template_name = 'address/create.html'
    success_url = reverse_lazy('addressList')
    
class AddressUpdateView(UpdateView):        
    model = Address
    form_class = AddressForm
    template_name = 'address/create.html'
    success_url = reverse_lazy('addressList')

            
        
        
    


    