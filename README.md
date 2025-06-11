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
[Uplo{
	"info": {
		"_postman_id": "77581b04-e512-4576-a0eb-0f260c9a9451",
		"name": "REST API basics: CRUD, test & variable",
		"description": "# 🚀 Get started here\n\nThis template guides you through CRUD operations (GET, POST, PUT, DELETE), variables, and tests.\n\n## 🔖 **How to use this template**\n\n#### **Step 1: Send requests**\n\nRESTful APIs allow you to perform CRUD operations using the POST, GET, PUT, and DELETE HTTP methods.\n\nThis collection contains each of these [request](https://learning.postman.com/docs/sending-requests/requests/) types. Open each request and click \"Send\" to see what happens.\n\n#### **Step 2: View responses**\n\nObserve the response tab for status code (200 OK), response time, and size.\n\n#### **Step 3: Send new Body data**\n\nUpdate or add new data in \"Body\" in the POST request. Typically, Body data is also used in PUT request.\n\n```\n{\n    \"name\": \"Add your name in the body\"\n}\n\n ```\n\n#### **Step 4: Update the variable**\n\nVariables enable you to store and reuse values in Postman. We have created a [variable](https://learning.postman.com/docs/sending-requests/variables/) called `base_url` with the sample request [https://postman-api-learner.glitch.me](https://postman-api-learner.glitch.me). Replace it with your API endpoint to customize this collection.\n\n#### **Step 5: Add tests in the \"Scripts\" tab**\n\nAdding tests to your requests can help you confirm that your API is working as expected. You can write test scripts in JavaScript and view the output in the \"Test Results\" tab.\n\n<img src=\"https://content.pstmn.io/fa30ea0a-373d-4545-a668-e7b283cca343/aW1hZ2UucG5n\" alt=\"\" height=\"1530\" width=\"2162\">\n\n## 💪 Pro tips\n\n- Use folders to group related requests and organize the collection.\n    \n- Add more [scripts](https://learning.postman.com/docs/writing-scripts/intro-to-scripts/) to verify if the API works as expected and execute workflows.\n    \n\n## 💡Related templates\n\n[API testing basics](https://go.postman.co/redirect/workspace?type=personal&collectionTemplateId=e9a37a28-055b-49cd-8c7e-97494a21eb54&sourceTemplateId=ddb19591-3097-41cf-82af-c84273e56719)  \n[API documentation](https://go.postman.co/redirect/workspace?type=personal&collectionTemplateId=e9c28f47-1253-44af-a2f3-20dce4da1f18&sourceTemplateId=ddb19591-3097-41cf-82af-c84273e56719)  \n[Authorization methods](https://go.postman.co/redirect/workspace?type=personal&collectionTemplateId=31a9a6ed-4cdf-4ced-984c-d12c9aec1c27&sourceTemplateId=ddb19591-3097-41cf-82af-c84273e56719)",
		"schema": "https://schema.getpostman.com/json/collection/v2.0.0/collection.json",
		"_exporter_id": "33494583"
	},
	"item": [
		{
			"name": "User",
			"item": [
				{
					"name": "Get/User",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Status code is 200\", function () {",
									"    pm.response.to.have.status(200);",
									"});"
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "GET",
						"header": [],
						"url": "{{base_url}}/user",
						"description": "This is a GET request and it is used to \"get\" data from an endpoint. There is no request body for a GET request, but you can use query parameters to help specify the resource you want data on (e.g., in this request, we have `id=1`).\n\nA successful GET response will have a `200 OK` status, and should include some kind of response body - for example, HTML web content or JSON data."
					},
					"response": []
				},
				{
					"name": "Post/User",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Successful POST request\", function () {",
									"    pm.expect(pm.response.code).to.be.oneOf([200, 201]);",
									"});",
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n  \"name\": \"Laura\",\n  \"lastname\": \"Gómez\",\n  \"birthdate\": \"2000-05-15\",\n  \"email\": \"laura@example.com\",\n  \"password\": \"clave123\",\n  \"is_active\": true,\n  \"phone\": \"3216549870\",\n  \"gender\": \"female\"\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "{{base_url}}/user",
						"description": "This is a POST request, submitting data to an API via the request body. This request submits JSON data, and the data is reflected in the response.\n\nA successful POST request typically returns a `200 OK` or `201 Created` response code."
					},
					"response": []
				},
				{
					"name": "Update/User",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Successful PUT request\", function () {",
									"    pm.expect(pm.response.code).to.be.oneOf([200, 201, 204]);",
									"});",
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n  \"id_user\": 6,\n  \"name\": \"Carlos\",\n  \"lastname\": \"Ramírez\",\n  \"email\": \"carlosr@example.com\",\n  \"password\": \"nuevo123\",\n  \"phone\": \"3001234567\",\n  \"is_active\": true,\n  \"gender\": \"male\"\n}\n",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{base_url}}/user",
							"host": [
								"{{base_url}}"
							],
							"path": [
								"user"
							],
							"query": [
								{
									"key": "id",
									"value": "1",
									"disabled": true
								}
							]
						},
						"description": "This is a PUT request and it is used to overwrite an existing piece of data. For instance, after you create an entity with a POST request, you may want to modify that later. You can do that using a PUT request. You typically identify the entity being updated by including an identifier in the URL (eg. `id=1`).\n\nA successful PUT request typically returns a `200 OK`, `201 Created`, or `204 No Content` response code."
					},
					"response": []
				},
				{
					"name": "Delete/User",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Successful DELETE request\", function () {",
									"    pm.expect(pm.response.code).to.be.oneOf([200, 202, 204]);",
									"});",
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "DELETE",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\"id_user\": 5}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{base_url}}/user",
							"host": [
								"{{base_url}}"
							],
							"path": [
								"user"
							],
							"query": [
								{
									"key": "id",
									"value": "1",
									"disabled": true
								}
							]
						},
						"description": "This is a DELETE request, and it is used to delete data that was previously created via a POST request. You typically identify the entity being updated by including an identifier in the URL (eg. `id=1`).\n\nA successful DELETE request typically returns a `200 OK`, `202 Accepted`, or `204 No Content` response code."
					},
					"response": []
				},
				{
					"name": "Patch/User",
					"request": {
						"method": "POST",
						"header": [
							{
								"key": "Content-Type",
								"value": "application/json",
								"type": "text"
							},
							{
								"key": "X-HTTP-Method-Override",
								"value": "PATCH",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\r\n  \"id_user\": 4,\r\n  \"phone\": \"3110002233\",\r\n  \"is_active\": false\r\n}\r\n",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "{{base_url}}/user/patch"
					},
					"response": []
				}
			]
		},
		{
			"name": "Subject",
			"item": [
				{
					"name": "Get",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Status code is 200\", function () {",
									"    pm.response.to.have.status(200);",
									"});"
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "GET",
						"header": [],
						"url": "{{base_url}}/subject",
						"description": "This is a GET request and it is used to \"get\" data from an endpoint. There is no request body for a GET request, but you can use query parameters to help specify the resource you want data on (e.g., in this request, we have `id=1`).\n\nA successful GET response will have a `200 OK` status, and should include some kind of response body - for example, HTML web content or JSON data."
					},
					"response": []
				},
				{
					"name": "Post",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Successful POST request\", function () {",
									"    pm.expect(pm.response.code).to.be.oneOf([200, 201]);",
									"});",
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": " {\n    \"id\": 1,\n    \"name\": \"Matemáticas 2\",\n    \"code\": \"MAT102\",\n    \"description\": \"Álgebra y cálculo 2\",\n    \"credit\": 3,\n    \"faculty_id\": 2,\n    \"create_at\": \"2025-11-11T00:00:00\",\n    \"updated_at\": null\n  }",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "{{base_url}}/subject",
						"description": "This is a POST request, submitting data to an API via the request body. This request submits JSON data, and the data is reflected in the response.\n\nA successful POST request typically returns a `200 OK` or `201 Created` response code."
					},
					"response": []
				},
				{
					"name": "Update",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Successful PUT request\", function () {",
									"    pm.expect(pm.response.code).to.be.oneOf([200, 201, 204]);",
									"});",
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n  \"id\": 2,\n  \"name\": \"CES3\",\n  \"code\": \"CES\",\n  \"description\": \"Curso avanzado de software\",\n  \"credit\": 4,\n  \"faculty_id\": \"1\"\n}\n",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "{{base_url}}/subject",
						"description": "This is a PUT request and it is used to overwrite an existing piece of data. For instance, after you create an entity with a POST request, you may want to modify that later. You can do that using a PUT request. You typically identify the entity being updated by including an identifier in the URL (eg. `id=1`).\n\nA successful PUT request typically returns a `200 OK`, `201 Created`, or `204 No Content` response code."
					},
					"response": []
				},
				{
					"name": "Delete",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Successful DELETE request\", function () {",
									"    pm.expect(pm.response.code).to.be.oneOf([200, 202, 204]);",
									"});",
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "DELETE",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n  \"id\": 2\r\n}\r\n",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "{{base_url}}/subject",
						"description": "This is a DELETE request, and it is used to delete data that was previously created via a POST request. You typically identify the entity being updated by including an identifier in the URL (eg. `id=1`).\n\nA successful DELETE request typically returns a `200 OK`, `202 Accepted`, or `204 No Content` response code."
					},
					"response": []
				}
			]
		},
		{
			"name": "Enrollement",
			"item": [
				{
					"name": "Get",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Status code is 200\", function () {",
									"    pm.response.to.have.status(200);",
									"});"
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "GET",
						"header": [],
						"url": "{{base_url}}/enrollement",
						"description": "This is a GET request and it is used to \"get\" data from an endpoint. There is no request body for a GET request, but you can use query parameters to help specify the resource you want data on (e.g., in this request, we have `id=1`).\n\nA successful GET response will have a `200 OK` status, and should include some kind of response body - for example, HTML web content or JSON data."
					},
					"response": []
				},
				{
					"name": "Post",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Successful POST request\", function () {",
									"    pm.expect(pm.response.code).to.be.oneOf([200, 201]);",
									"});",
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n  \"id_user\": 6,\n  \"id_subject\": 4,\n  \"date_enrollement\": \"2025-06-10 10:00:00\",\n  \"state\": \"active\",\n  \"term\": \"2025-2\"\n}\n",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "{{base_url}}/enrollement",
						"description": "This is a POST request, submitting data to an API via the request body. This request submits JSON data, and the data is reflected in the response.\n\nA successful POST request typically returns a `200 OK` or `201 Created` response code."
					},
					"response": []
				},
				{
					"name": "Update",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Successful PUT request\", function () {",
									"    pm.expect(pm.response.code).to.be.oneOf([200, 201, 204]);",
									"});",
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n  \"id_user\": 6,\n  \"id_subject\": 4,\n  \"date_enrollement\": \"2025-06-10 14:00:00\",\n  \"state\": \"finalized\",\n  \"term\": \"2025-2\"\n}\n",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "{{base_url}}/enrollement",
						"description": "This is a PUT request and it is used to overwrite an existing piece of data. For instance, after you create an entity with a POST request, you may want to modify that later. You can do that using a PUT request. You typically identify the entity being updated by including an identifier in the URL (eg. `id=1`).\n\nA successful PUT request typically returns a `200 OK`, `201 Created`, or `204 No Content` response code."
					},
					"response": []
				},
				{
					"name": "Delete",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Successful DELETE request\", function () {",
									"    pm.expect(pm.response.code).to.be.oneOf([200, 202, 204]);",
									"});",
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "DELETE",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n  \"id_user\": 6,\r\n  \"id_subject\": 4\r\n}\r\n",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "{{base_url}}/enrollement",
						"description": "This is a DELETE request, and it is used to delete data that was previously created via a POST request. You typically identify the entity being updated by including an identifier in the URL (eg. `id=1`).\n\nA successful DELETE request typically returns a `200 OK`, `202 Accepted`, or `204 No Content` response code."
					},
					"response": []
				}
			]
		}
	],
	"event": [
		{
			"listen": "prerequest",
			"script": {
				"type": "text/javascript",
				"exec": [
					""
				]
			}
		},
		{
			"listen": "test",
			"script": {
				"type": "text/javascript",
				"exec": [
					""
				]
			}
		}
	],
	"variable": [
		{
			"key": "id",
			"value": "1"
		},
		{
			"key": "base_url",
			"value": "https://postman-rest-api-learner.glitch.me/"
		}
	]
}ading REST API basics- CRUD, test & variable.postman_collection.json…]()







---
