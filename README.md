# Codigo-Postal api
API for get ZipCode in Mexico

**GET http://35.199.26.233:8090/zip-codes/{zipcode}**

Example response:
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
    "municipality": "015"
  }
]

```

if the zip code is not found an http 404 code is returned and an empty json array will be returned:
```json
[
]

```
