# Generated by Django 5.1.2 on 2024-10-10 15:43

import django.db.models.deletion
from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('core', '0001_initial'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='real_estate',
            name='renta',
        ),
        migrations.AddField(
            model_name='rental',
            name='real_e',
            field=models.OneToOneField(default='', on_delete=django.db.models.deletion.CASCADE, primary_key=True, serialize=False, to='core.real_estate'),
            preserve_default=False,
        ),
        migrations.AlterField(
            model_name='real_estate',
            name='superentity_ptr',
            field=models.OneToOneField(auto_created=True, on_delete=django.db.models.deletion.CASCADE, parent_link=True, primary_key=True, serialize=False, to='core.superentity'),
        ),
        migrations.AlterField(
            model_name='rental',
            name='superentity_ptr',
            field=models.OneToOneField(auto_created=True, on_delete=django.db.models.deletion.CASCADE, parent_link=True, to='core.superentity'),
        ),
    ]
