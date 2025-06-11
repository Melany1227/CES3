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
![image](https://github.com/user-attachments/assets/092b8678-56f0-493a-b378-a4083b714a0e)

![image](https://github.com/user-attachments/assets/46460950-0acc-4678-a8fc-0fc4148614d9)

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

![image](https://github.com/user-attachments/assets/46460950-0acc-4678-a8fc-0fc4148614d9)

---

### 📝 PUT `/user`

Actualiza la información de un usuario existente.

**Cuerpo de solicitud:**

```json
{
  "id_user": 5,
  "name": "Carlos",
  "lastname": "Ramírez",
  "email": "carlosr@example.com",
  "password": "nuevo123",
  "phone": "3001234567",
  "is_active": true,
  "gender": "male"
}
```
![image](https://github.com/user-attachments/assets/be856c6f-a939-4fb8-a498-5b1034318433)

![image](https://github.com/user-attachments/assets/e6475534-8db9-4cb8-b5cc-07de93f12dd7)

---

### ❌ DELETE `/user?id=4`

Elimina un usuario por ID.

---

![image](https://github.com/user-attachments/assets/70767015-9bed-491e-a7ba-b5204d392aa3)

![image](https://github.com/user-attachments/assets/0d5d6582-f9bd-4fa0-bd26-78c49da4914a)

---
## 📚 Materia (`Subject`)

### 📥 GET `/subject`

Obtiene todas las materias registradas.

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

![image](https://github.com/user-attachments/assets/f07aa636-f3d4-4812-9c82-9015fd60e314)


---
### 📤 POST `/subject`

Crea una nueva materia.

**Cuerpo de solicitud:**

```json
 {
    "id": 1,
    "name": "Matemáticas 2",
    "code": "MAT102",
    "description": "Álgebra y cálculo 2",
    "credit": 3,
    "faculty_id": 2,
    "create_at": "2025-11-11T00:00:00",
    "updated_at": null
  }
```
![image](https://github.com/user-attachments/assets/c43e3307-5010-40d4-a279-7f7583c9482f)

![image](https://github.com/user-attachments/assets/40e53ecc-0b5b-4339-ae2d-58b2ab6e9f09)

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
