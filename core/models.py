from django.db import models

class SuperEntity(models.Model):
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    archived = models.BooleanField(default=False)
    
    class meta :
        abstract = True
    
class User(SuperEntity):
        
        
    full_name = models.CharField(max_length=255)
    username = models.CharField(max_length=255,unique=True)
    password = models.CharField(max_length=255)
    tel = models.CharField(max_length=255,unique=True)
    email = models.EmailField(max_length=255,unique=True)
    type = models.CharField(max_length=255)
    
    def __str__(self) -> str:
        return self.full_name
    
class Admin(User):        
    def __init__(self, *args, **kwargs):        
        self.type = 'Admin'  
        
    def __str__(self) -> str:
        return self.full_name              
        
class Agent(User):
    def __init__(self, *args, **kwargs):
        
        self.type = 'Agent'
        
    def __str__(self) -> str:
        return self.full_name
        
class Tenant(User):
    def __init__(self, *args, **kwargs):
        
        self.type = 'Tenant'
    
    def __str__(self) -> str:
        return self.full_name

class Owner(User):
    def __init__(self, *args, **kwargs):        
        self.type = 'Owner'
        self.username = f"proprietaire"
        self.full_name = f"Propriétaire"
        self.password = f"passer"  
    
    def __str__(self) -> str:
        return self.full_name      
        
class Address(SuperEntity):
    municipality = models.CharField(max_length=255,unique=True,default="Sébikotane")    
    neighborhood = models.CharField(max_length=255,unique=True)
    street = models.CharField(max_length=255,unique=True)
    
    def __str__(self) -> str:
        return self.street
        
class Real_estate(SuperEntity):
    libel = models.CharField(max_length=255,unique=True)
    description = models.CharField(max_length=255)
    coordinate = models.CharField(max_length=255)
    price = models.IntegerField()    
    img1 = models.ImageField(upload_to='images/',null=True,blank=True)
    img2 = models.ImageField(upload_to='images/',null=True,blank=True)
    img3 = models.ImageField(upload_to='images/',null=True,blank=True)
    img4 = models.ImageField(upload_to='images/',null=True,blank=True)
    state = models.CharField(max_length=255,default='available')
    owner = models.ForeignKey(Owner,on_delete=models.CASCADE)
    addres = models.ForeignKey(Address,on_delete=models.CASCADE)
    
    
    def __str__(self) -> str:
        return self.libel
        
class Rental(SuperEntity):    
    price = models.IntegerField()
    tenant = models.ForeignKey(Tenant,on_delete=models.CASCADE)
    real_e = models.OneToOneField(
        Real_estate,
        on_delete=models.CASCADE,
        primary_key=True,        
    )
    
    def __str__(self) -> str:
        return self.price

        
    
    