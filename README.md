# Codigo-Postal api
API for get ZipCode in Mexico

**GET http://35.199.26.233:8090/zip-codes/{zipcode}**

**Example:**

Request: 
GET http://35.199.26.233:8090/zip-codes/06140

Response:
```json
[
  {
    "zip_code": "06140",
    "locality": "Ciudad de México",
    "federal_entity": "Ciudad de México",
    "settlements": {
      "name": "Condesa",
      "zone_type": "Urbano",
      "settlement_type": "Colonia"
    },
    "municipality": "Cuauhtémoc"
  }
]

```

if the zip code is not found an http 404 code is returned and an empty json array will be returned:
```json
[
]
```

**Project created with "Spring Tools Suite 4 4.5.1"**
To test open the project and run locally you need to have the file CPdescarga.txt in the path "/ home /" of your server.

Download it at the following link
https://www.correosdemexico.gob.mx/SSLServicios/ConsultaCP/CodigoPostal_Exportar.aspx

