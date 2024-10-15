from django import forms
from core.models import Address, Owner, Real_estate

class Real_estateForm(forms.ModelForm):
    libel = forms.CharField(error_messages={'unique': 'ce type de bien existe deja'},widget=forms.TextInput(attrs={'class': 'w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none', 'placeholder': 'libelle'}))
    description = forms.CharField(widget=forms.TextInput(attrs={'class': 'w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none', 'placeholder': 'description'}))
    coordinate = forms.CharField(widget=forms.TextInput(attrs={'class': 'w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none', 'placeholder': 'map'}))
    price = forms.CharField(widget=forms.NumberInput(attrs={'class': 'w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none', 'placeholder': 'tarif'}))
    img1 = forms.ImageField(required=False,widget=forms.FileInput(attrs={'class': 'w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none', 'placeholder': 'image 1'}))
    img2 = forms.ImageField(required=False,widget=forms.FileInput(attrs={'class': 'w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none', 'placeholder': 'image 2'}))
    img3 = forms.ImageField(required=False,widget=forms.FileInput(attrs={'class': 'w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none', 'placeholder': 'image 3'}))
    img4 = forms.ImageField(required=False,widget=forms.FileInput(attrs={'class': 'w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none', 'placeholder': 'image 4'}))
    state = forms.CharField(widget=forms.TextInput(attrs={'class': 'w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none','value':'disponible'}))
    ow = forms.ModelChoiceField(Owner.objects.all(),empty_label='proprietaire',widget=forms.Select(attrs={'class': 'w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none'}))
    addres = forms.ModelChoiceField(Address.objects.all(),empty_label='address',widget=forms.Select(attrs={'class': 'w-full block rounded-lg border dark:border-none dark:bg-neutral-600 py-[9px] px-3 pr-4 text-sm focus:border-blue-400 focus:ring-1 focus:ring-blue-400 focus:outline-none'}))
    class Meta:
        model = Real_estate
        fields = ['libel','description','coordinate','price','img1','img2','img3','img4','state','ow','addres']