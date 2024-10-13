from django.views.generic import ListView
from core.config.const import constente

from core.models import Real_estate

class listRealEstateView(ListView):
    model = Real_estate
    context_object_name = 'Real_estates'
    paginate_by = constente.get('page_by')
    template_name = 'real_estate/list.html'
    page_kwarg = 'p'
    
class createRealEstateView(ListView):
    model = Real_estate
    form_class = Real_estate
    template_name = 'real_estate/create.html'
    page_kwarg = 'p'
    
    