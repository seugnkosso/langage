
from product.models import Product
from django.http import JsonResponse
from django.forms.models import model_to_dict
# Create your views here.

def api_view(request):
    query = Product.objects.all().order_by('?').first()
    data = {}
    if query :
    #     data['title'] = query.title
    #     data['price'] = query.price
        data = model_to_dict(query)
    return JsonResponse(data)

    