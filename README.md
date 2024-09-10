# API de Autenticación y Autorización de Usuarios (V1.0)

#Proyecto en mejora!!.

<p align="center">
  <b>Una API segura para gestionar la autenticación y autorización de usuarios.</b><br>
  Construida con <strong>Spring Boot v3.3.3</strong>, <strong>Spring Security v6.1.0</strong>, <strong>PostgreSQL</strong> y <strong> JWT </strong> .
</p>

---

## Características

<ul>
  <li><b>Autenticación con JWT</b>: Sistema de autenticación basado en tokens JWT.</li>
  <li><b>Gestión de usuarios</b>: Registro, autenticación y gestión de usuarios.</li>
  <li><b>PostgreSQL</b>: Almacenamiento de la información de usuarios en una base de datos.</li>
</ul>

---

## Instalación

<pre>
git clone https://github.com/usuario/repo-autenticacion-usuarios.git
cd spring_Security_API
mvn spring-boot:run
</pre>

---

## Endpoints

<table>
  <thead>
    <tr>
      <th>Método</th>
      <th>Ruta</th>
      <th>Descripción</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><b>POST</b></td>
      <td><code>/auth/register</code></td>
      <td>Registro de nuevos usuarios.</td>
    </tr>
    <tr>
      <td><b>POST</b></td>
      <td><code>/auth/login</code></td>
      <td>Autenticación de usuarios y generación de JWT.</td>
    </tr>
    <tr>
      <td><b>GET</b></td>
      <td><code>/api/v1/userProfile</code></td>
      <td>Obtención de información de el usuario (requiere autenticación).</td>
    </tr>
  </tbody>
</table>

---

## Licencia

<p align="center">
 <p>Este proyecto está licenciado bajo la Licencia Derlin.Dev - ver el archivo [LICENSE](LICENSE) para detalles.</p>
</p>
