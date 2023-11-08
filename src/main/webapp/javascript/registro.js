function registrarse(event) {
  event.preventDefault();  // Prevenir el comportamiento predeterminado de recarga de la página

  // Recopilar los datos del formulario
  var data = {
    name: document.getElementById('name').value,
            lastname: document.getElementById('lastname').value,
            email: document.getElementById('email').value,
            cellphone: document.getElementById('cellphone').value,
            password: document.getElementById('password').value,
  };

  // Enviar una solicitud POST a la API
  fetch('http://localhost:8090/reserva/api/user/signup', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)  // Convertir los datos a una cadena JSON
  })
  .then(response => response.json())  // Convertir la respuesta a JSON
  .then(data => {
    console.log('Success:', data);
  })
  .catch((error) => {
    console.error('Error:', error);
  });
}

// Agregar el eventListener al formulario
document.addEventListener('DOMContentLoaded', (event) => {
  document.querySelector('form').addEventListener('submit', registrarse);
});