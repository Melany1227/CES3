# 📘 API REST - Documentación

Esta API permite la gestión de **usuarios**, **materias** y **matrículas**. A continuación se describen todos los endpoints disponibles y ejemplos de uso.

---

## 🌐 Base URL

```
http://localhost:8081/demodb/
```

---

## 👤 Usuario (`User`)

### 📥 GET `/user`

Obtiene todos los usuarios registrados.

**Ejemplo de respuesta:**

```json
{
  "users": [
    {
      "id_user": 1,
      "name": "Mel",
      "lastname": "Suarez",
      "email": "melanysuarez@gmail.com",
      "phone": "3205277115",
      "birthdate": "2004-12-27",
      "gender": "FEMALE",
      "is_active": true,
      "created_at": "2025-04-02T19:31:01",
      "updated_at": "2025-04-02T19:31:01"
    }
  ]
}
```

---

### 📤 POST `/user`

Crea un nuevo usuario.

**Cuerpo de solicitud:**

```json
{
  "id": 5
  "name": "Laura",
  "lastname": "Gómez",
  "birthdate": "2000-05-15",
  "email": "laura@example.com",
  "password": "clave123",
  "is_active": true,
  "phone": "3216549870",
  "gender": "female"
}
```
![image](https://github.com/user-attachments/assets/5cb3c02c-75a7-4eb5-adc8-8338324557d1)

---

### 📝 PUT `/user`

Actualiza la información de un usuario existente.

**Cuerpo de solicitud:**

```json
{
  "id_user": 4,
  "name": "Laura",
  "lastname": "Gómez",
  "email": "laura@example.com",
  "phone": "3210649870",
  "birthdate": "2009-05-15",
  "gender": "FEMALE",
  "password": "nuevaclave"
}
```

---

### ❌ DELETE `/user?id=4`

Elimina un usuario por ID.

---

## 📚 Materia (`Subject`)

### 📥 GET `/subject`

Obtiene todas las materias registradas.

---

### 📤 POST `/subject`

Crea una nueva materia.

**Cuerpo de solicitud:**

```json
{
  "name": "Matemáticas",
  "description": "Curso básico de matemáticas"
}
```

---

### 📝 PUT `/subject`

Actualiza una materia existente.

**Cuerpo de solicitud:**

```json
{
  "id_subject": 1,
  "name": "Matemáticas Avanzadas",
  "description": "Curso avanzado"
}
```

---

### ❌ DELETE `/subject?id=1`

Elimina una materia por ID.

---

## 📝 Matrícula (`Enrolment`)

### 📥 GET `/enrolment`

Obtiene todas las matrículas existentes.

---

### 📤 POST `/enrolment`

Crea una nueva matrícula.

**Cuerpo de solicitud:**

```json
{
  "id_user": 1,
  "id_subject": 2
}
```

---

### 📝 PUT `/enrolment`

Actualiza una matrícula existente.

**Cuerpo de solicitud:**

```json
{
  "id_enrolment": 3,
  "id_user": 1,
  "id_subject": 4
}
```

---

### ❌ DELETE `/enrolment?id=3`

Elimina una matrícula por ID.

---

---

## 🧪 Pruebas

Puedes probar estos endpoints con herramientas como:

- Postman


---

## 🚧 Estado

Este proyecto está en desarrollo. Los endpoints actuales están activos y funcionales en pruebas locales.
