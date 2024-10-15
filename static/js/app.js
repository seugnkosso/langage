
// Tenant JS ON

{
    const inputTenanttTel =document.querySelector('#tel');
    if(inputTenanttTel){
        inputTenanttTel.addEventListener("change",(event)=>{
            inputFiltreAsynchrone(event,inputTenanttTel);
        })
    }   
}

// Tenant JS off 

// Address JS ON

{

    const inputneighborhood = document.querySelector('#neighborhood');
    if(inputneighborhood){
        inputneighborhood.addEventListener("change",(event)=>{
            inputFiltreAsynchrone(event,inputneighborhood);
        })
    }   
}

// Address JS off 

// Real estate JS ON

{

    const inputsearch_Estate = document.querySelector('#search_Estate');
    if(inputsearch_Estate){
        inputsearch_Estate.addEventListener("change",(event)=>{
            inputFiltreAsynchrone(event,inputsearch_Estate);
        })
    }   

    const detailImgClick = document.querySelector('#detClick');
    const listImg = document.querySelectorAll('.imgListDet');
    const baseImg = document.querySelectorAll('#baseImg');
    if(detailImgClick){
        detailImgClick.addEventListener("click",(event)=>{
            detailImgClick.classList.toggle("detailImgClick");            
        })
        
    }
    if(baseImg){
        listImg.forEach((img)=>{
            img.addEventListener("click",(event)=>{
                baseImg[0].attributes.src.value = img.attributes.src.value
            })
        })
    }
}

// Real estate JS off 



function inputFiltreAsynchrone(event,input){
    const path = `${input.getAttribute('data-path')}?${input.id}=${input.value}`     
    window.location.href=path;    
}



// function SelectFiltreAsynchrone(event,select){
//     const option=event.target.options[select.selectedIndex];
//     const path=option.getAttribute('data-path')  
//     window.location.href=url;   
// }





// const selectFiltreProduit =document.querySelector('#select-filtre-Produit');
// if(selectFiltreProduit){
//     selectFiltreProduit.addEventListener("change",(event)=>{
//         SelectFiltreAsynchrone(event,selectFiltreProduit);
//     })
// }