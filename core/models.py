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
        return self.full_name

class Owner(User):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)        
        self.type = 'Owner'        
    
    def __str__(self) -> str:
        return self.full_name + "-" + self.tel + "-" + self.email    
        
class Address(SuperEntity):
    municipality = models.CharField(max_length=255,unique=True,default="Sébikotane")    
    neighborhood = models.CharField(max_length=255,unique=True)
    street = models.CharField(max_length=255,unique=True)
    
    def __str__(self) -> str:
        return self.street + "-" + self.municipality + "-" + self.neighborhood
        
class Real_estate(SuperEntity):
    libel = models.CharField(max_length=255,unique=True)
    description = models.CharField(max_length=255)
    coordinate = models.CharField(max_length=255)
    price = models.IntegerField()    
    img1 = models.ImageField(upload_to='images/',null=True,blank=True)
    img2 = models.ImageField(upload_to='images/',null=True,blank=True)
    img3 = models.ImageField(upload_to='images/',null=True,blank=True)
    img4 = models.ImageField(upload_to='images/',null=True,blank=True)
    state = models.CharField(max_length=255,default='disponible')
    ow = models.ForeignKey(Owner,on_delete=models.CASCADE)
    addres = models.ForeignKey(Address,on_delete=models.CASCADE)
    
    
    def __str__(self) -> str:
        return self.libel
        
class Rental(SuperEntity):    
    price = models.IntegerField()
    ten = models.ForeignKey(Tenant,on_delete=models.CASCADE)
    real_e = models.OneToOneField(
        Real_estate,
        on_delete=models.CASCADE,
        primary_key=True,        
    )
    
    def __str__(self) -> str:
        return self.price

        
    
    