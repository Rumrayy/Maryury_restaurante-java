function loginUser() {
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    // Datos a enviar
    var data = {
        email: email,
        password: password
    };

    // URL de la API
    var apiURL = 'http://localhost:8090/reserva/api/user/login';

    // Enviar solicitud a la API
    fetch(apiURL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
    .then(response => {
        if (!response.ok) {
            // Si el estado no es 200 OK, se maneja como un inicio de sesión fallido.
            throw new Error('Inicio de sesión fallido');
        }
        return response.json(); // Asumimos que la API siempre responde con JSON.
    })
    .then(data => {
        // Asegúrate de que esta lógica coincide con la estructura de la respuesta de tu API.
        if (data.message && data.message === 'Login exitoso') {
            window.location.href = 'reservarmesa.jsp';
        } else {
            alert('Correo electrónico o contraseña incorrectos.');
        }
    })

    .catch((error) => {
        console.error('Error:', error);
    });
}
