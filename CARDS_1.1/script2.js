
const y = document.getElementById('view');
const url = `http://localhost:8081/api/users`;
fetch(url)
.then(response => {
    return response.json();
   
  } )
  .then(data => {
    
     for (var i = 0; i<data.length; i++){


         let name = data[i].name;
         let emId = data[i].emId;
         let emAdd= data[i].emAdd;
          document.querySelector("#demo1").innerHTML += `
          <div class=\"col-12 col-md-4 col-lg-4 \" style=\"padding-bottom:20px;  width:15rem; text-align:center;\">
            <div class=\"card-body mx-auto\" style=\" background-color:#A66CFF; border-top-right-radius: 10px;
            border-top-left-radius: 10px;\ ">
            <h5 class=\"card-title fs-2\"><b>${name}</b></h5>
            
          </div>
          <ul class=\"list-group list-group-flush mx-auto\" >
  
            
            <li class=\"list-group-item \" style=\" background-color:#9C9EFE; \">${emId}</li>
            <li class=\"list-group-item \" style=\" background-color:#AFB4FF ;     border-bottom-right-radius: 10px;
            border-bottom-left-radius: 10px;\">${emAdd}</li>
            
          </ul></div><br></div>`;
}
})

