from django.urls import reverse_lazy
from django.views.generic import ListView,CreateView,UpdateView
from core.config.const import constente
from django.db.models import Q

from core.forms.real_estateForm import Real_estateForm
from core.models import Real_estate

class listRealEstateView(ListView):
    model = Real_estate
    context_object_name = 'Real_estates'
    paginate_by = constente.get('page_by')
    template_name = 'real_estate/list.html'
    page_kwarg = 'p'
    
    def get_queryset(self):
        search = self.request.GET.get('search_Estate')
        if search:
            return Real_estate.objects.filter(Q(libel__icontains=search) | Q(state__icontains=search) | Q(price__icontains=search) | Q(ow__full_name__icontains=search) | Q(ow__tel__icontains=search) | Q(addres__neighborhood__icontains=search) | Q(addres__street__icontains=search) | Q(addres__municipality__icontains=search))
        return Real_estate.objects.all()
    
    def get_context_data(self, **kwargs: reverse_lazy):
        self.object_list = self.get_queryset()
        context = super().get_context_data()
        context['title'] = 'real estates'
        context['data_path'] = constente.get('data_path')
        if self.request.GET.get('search_Estate'):
            context['search_Estate'] = self.request.GET.get('search_Estate')
        else:
            context['search_Estate'] = ''    
        return context
    
class createRealEstateView(CreateView):
    model = Real_estate
    form_class = Real_estateForm
    template_name = 'real_estate/create.html'
    success_url = reverse_lazy('real_estateList')    
    
class UpdateRealEstateView(UpdateView):
    model = Real_estate
    form_class = Real_estateForm
    template_name = 'real_estate/create.html'
    success_url = reverse_lazy('real_estateList')
    