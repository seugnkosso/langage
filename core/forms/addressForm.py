from django import forms
from core.models import Address


class AddressForm(forms.ModelForm):
    municipality = forms.CharField(widget=forms.TextInput(attrs={'class': "w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 my-[2rem] focus:ring-blue-400 focus:outline-none", "placeholder":"commune"}))    
    neighborhood = forms.CharField(widget=forms.TextInput(attrs={'class': "w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none", "placeholder":"quartier"}))
    street = forms.CharField(widget=forms.TextInput(attrs={'class': "w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none", "placeholder":"rue"}))
    class Meta :
        model = Address
        fields = ['municipality','neighborhood','street']    