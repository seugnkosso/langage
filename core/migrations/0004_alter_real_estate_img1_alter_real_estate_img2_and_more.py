# Generated by Django 5.1.2 on 2024-10-13 12:35

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('core', '0003_alter_real_estate_state'),
    ]

    operations = [
        migrations.AlterField(
            model_name='real_estate',
            name='img1',
            field=models.ImageField(blank=True, null=True, upload_to='media/images/'),
        ),
        migrations.AlterField(
            model_name='real_estate',
            name='img2',
            field=models.ImageField(blank=True, null=True, upload_to='media/images/'),
        ),
        migrations.AlterField(
            model_name='real_estate',
            name='img3',
            field=models.ImageField(blank=True, null=True, upload_to='media/images/'),
        ),
        migrations.AlterField(
            model_name='real_estate',
            name='img4',
            field=models.ImageField(blank=True, null=True, upload_to='media/images/'),
        ),
        migrations.AlterField(
            model_name='real_estate',
            name='libel',
            field=models.CharField(error_messages={'unique': 'le libelle exist deja'}, max_length=255, unique=True),
        ),
    ]
