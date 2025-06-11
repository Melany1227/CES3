[REST API basics- CRUD, test & variable.postman_collection.json](https://github.com/user-attachments/files/20698946/REST.API.basics-.CRUD.test.variable.postman_collection.json)# 📘 API REST - Documentación

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
    "subjects": [
        {
            "code": "MAT101",
            "updated_at": "2025-06-10 22:17:25.0",
            "name": "Matemáticas",
            "description": "Álgebra y cálculo",
            "id": 2,
            "credit": 3,
            "create_at": "2025-06-10 22:17:25.0",
            "faculty": "ART"
        },
        {
            "code": "MAT102",
            "updated_at": "2025-06-11 17:50:13.0",
            "name": "Matemáticas 2",
            "description": "Álgebra y cálculo 2",
            "id": 4,
            "credit": 3,
            "create_at": "2025-06-11 17:50:13.0",
            "faculty": "ART"
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
  "id": 1,
  "name": "Bases de Datos II",
  "code": "BD2345",
  "description": "Curso avanzado de sistemas de bases de datos",
  "credit": 4,
  "faculty_id": "1"
}
```
---

![image](https://github.com/user-attachments/assets/7268f805-d769-426d-9218-a94d0a3a4c59)

![image](https://github.com/user-attachments/assets/eddb0653-f866-48e5-a3cd-372f3e9f5c5e)


---

### ❌ DELETE `/subject`

Elimina una materia por ID.

```json
{
  "id": 2
}

```

---
![image](https://github.com/user-attachments/assets/c84dc37c-3aa6-4b6b-bd8d-a93b9dabca10)

![image](https://github.com/user-attachments/assets/3db91fa5-dc64-4931-a406-d8de67c0c217)

---

## 📝 Matrícula (`Enrollement`)

### 📥 GET `/enrollement`

Obtiene todas las matrículas existentes.

**Ejemplo de respuesta:**

```json
{
    "enrollements": [
        {
            "date_enrollement": "2025-06-10 10:00:00.0",
            "updated_at": "2025-06-11 17:58:47.0",
            "term": "2025-2",
            "id_user": 6,
            "state": "active",
            "id_subject": 4,
            "create_at": "2025-06-11 17:58:47.0"
        }
    ]
}
```
---
![image](https://github.com/user-attachments/assets/1c6bb122-2cfa-47b5-b5de-54bfe32ce5cf)

![image](https://github.com/user-attachments/assets/faa25cce-c1ce-45c7-b1d7-cd0772d5aa69)

---

### 📤 POST `/enrollement`

Crea una nueva matrícula.

**Cuerpo de solicitud:**

```json
{
  "id_user": 6,
  "id_subject": 4,
  "date_enrollement": "2025-06-10 10:00:00",
  "state": "active",
  "term": "2025-2"
}

```
---
![image](https://github.com/user-attachments/assets/7e23e59a-e91e-4755-98a8-dd185648fec5)

![image](https://github.com/user-attachments/assets/4a5b3834-d5f0-4838-9157-917adc7ce032)

---

### 📝 PUT `/enrollement`

Actualiza una matrícula existente.

**Cuerpo de solicitud:**

```json
{
  "id_enrolment": 3,
  "id_user": 1,
  "id_subject": 4
}
```
![image](https://github.com/user-attachments/assets/550292dc-d984-4071-9635-0eafc790f40a)

![image](https://github.com/user-attachments/assets/cde03118-8807-4a24-8775-8b93b5e28405)

---

### ❌ DELETE `/enrollement`

Elimina una matrícula por ID.

```json
{
  "id": 2
}

```
![image](https://github.com/user-attachments/assets/0c909b6e-6d33-44f5-a107-38e1ac7c9717)

![image](https://github.com/user-attachments/assets/b96a63be-f6c6-4a3f-bc36-9729d35e0ef6)

---

---

## 🧪 Pruebas

Puedes probar estos endpoints con herramientas como Postman importando este paquete:
