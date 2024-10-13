
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