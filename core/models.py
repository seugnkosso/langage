from typing import Any
from django.db import models

class SuperEntity(models.Model):    
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    archived = models.BooleanField(default=False)
    
    class meta :
        abstract = True
    
    
    
class User(SuperEntity):       
    
    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)
        
    full_name = models.CharField(max_length=255)
    username = models.CharField(max_length=255,null=True, blank=True,default='ok')
    password = models.CharField(max_length=255,null=True, blank=True,default='ok')
    tel = models.CharField(max_length=255)
    email = models.EmailField(max_length=255)
    type = models.CharField(max_length=255)
    
    
    
    def __str__(self) -> str:
        return self.full_name
    
    class meta :
        abstract = True
    
    
class Admin(User):        
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)        
        self.type = 'Admin'  
        
    def __str__(self) -> str:
        return self.full_name              
        
class Agent(User):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        
        self.type = 'Agent'
        
    def __str__(self) -> str:
        return self.full_name
        
class Tenant(User):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)        
        self.type = 'Tenant'
    
    def __str__(self) -> str:
        return self.full_name + " " + self.tel

class Owner(User):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)        
        self.type = 'Owner'        
    
    def __str__(self) -> str:
        return self.full_name + " " + self.tel  
        
class Address(SuperEntity):
    municipality = models.CharField(max_length=255,default="Sébikotane")    
    neighborhood = models.CharField(max_length=255)
    street = models.CharField(max_length=255)
    
    def __str__(self) -> str:
        return self.municipality + " " + self.neighborhood + " " + self.street
        
class Real_estate(SuperEntity):
    libel = models.CharField(max_length=255,unique=True,error_messages={'unique':'le libelle exist deja'})
    description = models.CharField(max_length=255)
    coordinate = models.CharField(max_length=255)
    price = models.IntegerField()    
    img1 = models.ImageField(upload_to='media/',null=True,blank=True)
    img2 = models.ImageField(upload_to='media/',null=True,blank=True)
    img3 = models.ImageField(upload_to='media/',null=True,blank=True)
    img4 = models.ImageField(upload_to='media/',null=True,blank=True)
    img5 = models.ImageField(upload_to='media/',null=True,blank=True)
    img6 = models.ImageField(upload_to='media/',null=True,blank=True)
    img7 = models.ImageField(upload_to='media/',null=True,blank=True)
    img8 = models.ImageField(upload_to='media/',null=True,blank=True)
    state = models.CharField(max_length=255,default='disponible')
    ow = models.ForeignKey(Owner,on_delete=models.DO_NOTHING)
    addres = models.ForeignKey(Address,on_delete=models.DO_NOTHING)
    
    
    def __str__(self) -> str:
        return self.libel + " " + self.description + " " + str(self.price)
        
class Rental(SuperEntity):    
    price = models.IntegerField(null=True,blank=True)
    tenant = models.ForeignKey(Tenant,on_delete=models.DO_NOTHING,null=True,blank=True)
    real_e = models.OneToOneField(
        Real_estate,
        on_delete=models.DO_NOTHING,
        null=True,blank=True
    )
    
    def __str__(self) -> str:
        return self.price

        
    
    