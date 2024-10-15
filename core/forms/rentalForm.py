from django import forms
from core.models import  Real_estate, Rental, Tenant

class RentalForm(forms.ModelForm):
    price = forms.CharField(required=False,widget=forms.NumberInput(attrs={'class': 'w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none', 'placeholder': 'tarif/mois'}))    
    tenant = forms.ModelChoiceField(Tenant.objects.all(),empty_label='locataire',widget=forms.Select(attrs={'class': 'w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none'}))
    real_e = forms.ModelChoiceField(Real_estate.objects.filter(state="disponible"),empty_label='biens disponibles',widget=forms.Select(attrs={'class': 'w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none'}))
    class Meta:
        model = Rental
        fields = ['price','tenant','real_e']