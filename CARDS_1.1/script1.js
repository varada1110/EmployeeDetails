
const d1 = document.getElementById('get1');
const d2 = document.getElementById('delete');
function fun1(event){
  event.preventDefault();
  console.log("hi");
  var x = parseInt(document.getElementById('delete').value);
  console.log(x);
  
  const url = `http://localhost:8081/api/users/${x}`;
  const element = document.getElementById('text');
  fetch(url, { method: 'DELETE' })
    .then(() => element.innerHTML = 'Employee deleted successful');
  
       
        
           
          
        
        
     
     
    




}

d1.addEventListener('submit',fun1);