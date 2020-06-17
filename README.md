# Şirketler için Toplantı Odası Kiralama   

## API Listesi  

- İl Kaydet  
**/api/province/province => POST**  

```

{
  "id": 0,
  "name": "string"
}
```

- İl Listele  
**/api/province/province => GET**  

- İlçe Kaydet  
**/api/district/district => POST**  

```
{
  "id": 0,
  "name": "string",
  "provinceId": 0
}
```

- İlçe Listele  
**/api/district/district => GET**  

- Şirket Kaydet  
**/api/company/company => POST**  

```
{
  "id": 0,
  "locationId": 0,
  "name": "string",
  "totalEmployeeNumber": 0
}
```

- Şirket Listele  
**/api/company/company => GET**  

- Toplantı Odası Kaydet  
**/api/meeting-room/meeting-room => POST**  

```
{
  "districtId": 0,
  "id": 0,
  "name": "string",
  "personCapacity": 0,
  "provinceId": 0
}
```

- Toplantı Odası Listele  
**/api/meeting-room/meeting-room => GET**  

- Üye Ol  
**/api/register/register => POST**  

```
{
  "companyId": 0,
  "createDate": "string",
  "id": 0,
  "status": true,
  "title": "string"
}
```

- Üye Listele  
**/api/register/register => GET**  

- Rezervasyon Yap  
**/api/reservation/reservation => POST**  

```
{
  "code": "string",
  "companyId": 0,
  "endDate": "2020-06-17T11:57:54.990Z",
  "id": 0,
  "meetingRoomId": 0,
  "startDate": "2020-06-17T11:57:54.990Z"
}
```

- Rezervasyon Listele  
**/api/reservation/reservation => GET**  