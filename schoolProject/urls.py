from django.contrib import admin
from django.urls import path
from studentApp import views

urlpatterns = [
    path('students',views.studentApi),
    path('students',views.studentApi),
    path('students/delete/<int:id>',views.studentApi),
    path('students/update/<int:id>',views.studentApi),
    path('admin/', admin.site.urls),
]