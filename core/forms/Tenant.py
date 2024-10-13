from django import forms
from core.models import Tenant


class TenantForm(forms.ModelForm):
    full_name = forms.CharField(widget=forms.TextInput(attrs={'class': "w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 my-[2rem] focus:ring-blue-400 focus:outline-none", "placeholder":"nom complet"}))    
    tel = forms.CharField(widget=forms.TextInput(attrs={'class': "w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none", "placeholder":"telephone"}))
    email = forms.CharField(widget=forms.EmailInput(attrs={'class': "w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none", "placeholder":"mail"}))
    class Meta :
        model = Tenant
        fields = ['full_name','tel','email']    