//var xhttp = new XMLHttpRequest();
//xhttp.onreadystatechange = function() {
    //if (this.readyState == 4 && this.status == 200) {
      //var out="";
      //var obj=JSON.parse(this.responseText);
      
      
      //for(var i=0;i<obj.length;i++){
        //if (i%3==0){
          //  out+="\n"+"<ul class=\"list-group list-group-flush\"><li class=\"list-group-item\">"+obj[i].name+"</li><li class=\"list-group-item\">"+obj[i].emId+"</li><li class=\"list-group-item\">"+obj[i].emAdd+"</li></ul>";
  
        //}
       // else{
     //       out+="<ul class=\"list-group list-group-flush\"><li class=\"list-group-item\">"+obj[i].name+"</li><li class=\"list-group-item\">"+obj[i].emId+"</li><li class=\"list-group-item\">"+obj[i].emAdd+"</li></ul>";
  
   //     }
       
 //}
  //document.getElementById("demo").innerHTML=out;
   
 //   }
//};
//xhttp.open("GET", "data.json", true);
//xhttp.send();



const y = document.getElementById('get');
const z = document.getElementById('demo1');


function fun(event){
  event.preventDefault();
  console.log("hi");
  var x = parseInt(document.getElementById('demo').value);
  console.log(x);
  
  const url = `http://localhost:8081/api/users/${x}`;
  let fetchRes = fetch(url);
  
  fetchRes.then(res =>
    res.json()).then(data => {
        console.log(data)
 
     
     
         if((data.name == undefined)){
          alert("Employee ID not available.");
          
         }
         else{
         
          z.innerHTML = `
            <div class=\"col-12 col-md-12 col-lg-12 \" style=\"padding-bottom:20px;  width:15rem; text-align:center;\">
            <div class=\"card-body mx-auto\" style=\" background-color:#A66CFF; border-top-right-radius: 10px;
            border-top-left-radius: 10px;\ ">
            <h5 class=\"card-title fs-2\"><b>${data.name}</b></h5>
            
          </div>
          <ul class=\"list-group list-group-flush mx-auto\" >
  
            
            <li class=\"list-group-item \" style=\" background-color:#9C9EFE; \">${data.emId}</li>
            <li class=\"list-group-item \" style=\" background-color:#AFB4FF ;     border-bottom-right-radius: 10px;
            border-bottom-left-radius: 10px;\">${data.emAdd}</li>
            
          </ul></div><br></div>`;
          
         }
       
        
           
          
        
        
     
     
    

})



}
y.addEventListener('submit',fun);



 



    