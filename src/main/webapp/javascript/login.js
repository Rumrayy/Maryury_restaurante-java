async function loginUser(email, password) {
  event.preventDefault();
  // Define la URL de la API y los datos a enviar
  const url = 'http://localhost:8090/reserva/api/user/login';
  const data = {
    email: email,
    password: password
  };

  try {
    // Envía una solicitud POST a la API
    const response = await fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)  // Convierte los datos a una cadena JSON
    });

    // Verifica si la respuesta es exitosa
    if (response.ok) {
      // Obtén y retorna el token JWT del encabezado de autorización
      const jwtToken = response.headers.get('Authorization');
      return jwtToken;
    } else {
      // Si la respuesta no es exitosa, lanza un error
      throw new Error('Login failed: ' + response.statusText);
    }
  } catch (error) {
    // Captura y maneja cualquier error que ocurra
    console.error('Error:', error.message);
  }
  document.getElementById('loginForm').addEventListener('submit', async function(event)) {


          const email = document.getElementById('email').value;
          const password = document.getElementById('password').value;

          const jwtToken = await loginUser(email, password);
          if (jwtToken) {
              console.log('Login successful, JWT Token:', jwtToken);
          }
  }
}