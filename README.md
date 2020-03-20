# codigoPostal
API for get ZipCode in Mexico

GET https://34.94.129.221:8090/{zipcode}

Example response:
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
