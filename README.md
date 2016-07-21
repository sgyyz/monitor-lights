## Monitor-Lights APIs
===========================

### Create Product
We need to create the product via UI, UI can call this API to create it.
#### URL 
```POST http://localhost:8080/monitor-lights```
#### Body
```
{
    "productName": "test",
    "lightId": 1,
    "statusList": [
        {"rgbValue": 500, "startValue": 0, "endValue": 70},
        {"rgbValue": 5000, "startValue": 70, "endValue": 80},
        {"rgbValue": 50000, "startValue": 80, "endValue": 100}
    ]
}
```
#### Response
```
{
  "id": "572ad76c-e8fa-4cfa-9407-9567dd38a4ee",
  "productName": "test",
  "statusList": [
    {
      "rgbValue": 500,
      "startValue": 0,
      "endValue": 70
    },
    {
      "rgbValue": 5000,
      "startValue": 70,
      "endValue": 80
    },
    {
      "rgbValue": 50000,
      "startValue": 80,
      "endValue": 100
    }
  ],
  "lightId": 1
}
```

### Update Product
After create the product, we can update the product by id.
#### URL
```PUT http://localhost:8080/monitor-lights/{id}```
`id` will be generated from create method.
#### Body
```
{
    "productName": "test",
    "lightId": 1,
    "statusList": [
        {"rgbValue": 500, "startValue": 0, "endValue": 70},
        {"rgbValue": 5000, "startValue": 70, "endValue": 80},
        {"rgbValue": 50000, "startValue": 80, "endValue": 100}
    ]
}
```
#### Response
```
{
  "id": "572ad76c-e8fa-4cfa-9407-9567dd38a4ee",
  "productName": "test",
  "statusList": [
    {
      "rgbValue": 500,
      "startValue": 0,
      "endValue": 70
    },
    {
      "rgbValue": 5000,
      "startValue": 70,
      "endValue": 80
    },
    {
      "rgbValue": 50000,
      "startValue": 80,
      "endValue": 100
    }
  ],
  "lightId": 1
}
```

### Get All Products
#### URL
```GET http://localhost:8080/monitor-lights```
#### Response
```
[
  {
    "id": "572ad76c-e8fa-4cfa-9407-9567dd38a4ee",
    "productName": "test",
    "statusList": [
      {
        "rgbValue": 500,
        "startValue": 0,
        "endValue": 70
      },
      {
        "rgbValue": 5000,
        "startValue": 70,
        "endValue": 80
      },
      {
        "rgbValue": 50000,
        "startValue": 80,
        "endValue": 100
      }
    ],
    "lightId": 1
  }
]
```
### Change Light Color
This will call xiaodong's service to change the light color.
#### URL
```POST http://localhost:8080/monitor-lights/{id}```
`id` will be generated from create method.
#### Body
```
{"value": 20}
```
#### Response
```
{
  "lightId": 1,
  "power": "on",
  "rgbValue": 500,
  "method": "SET_RGB"
}
```



