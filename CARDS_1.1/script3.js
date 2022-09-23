var form=document.getElementById('get2')

form.addEventListener('submit', function(e){
 e.preventDefault()

 var name=document.getElementById('name').value
 var emId=document.getElementById('emId').value
 var emAdd=document.getElementById('emAdd').value

 const element = document.getElementById('text');
 fetch('http://localhost:8081/api/users', {
  method: 'POST',
  body: JSON.stringify({
    name:name,
    emId:emId,
    emAdd:emAdd

  }),
  headers: {
    'Content-type': 'application/json',
  }
  })
  .then(function(response){ 
  return response.json()
 
})
  
})
