# gateway
Run create-schema-gateway.sql on MySQL database.
Go to src/main/resources/application.properties and enter MySQL database IP and password

Gateway:
HTTP POST REQUEST
http://127.0.0.1:8080/gateway/save
sample JSON body
{
  "name":"test",
  "serialNumber":"testSerial",
  "ipv4":"127.0.0.1"
}


HTTP GET REQUEST
http://127.0.0.1:8080/gateway/findAll

HTTP GET REQUEST
http://127.0.0.1:8080/gateway/find?id=1
http://127.0.0.1:8080/gateway/find?id=1&serialNumber=testSerial
http://127.0.0.1:8080/gateway/find?serialNumber=testSerial


Device:
HTTP POST REQUEST
http://127.0.0.1:8080/device/save
sample JSON body
{
  "uid":"12345",
  "vendor":"LG",
  "status":"online",
  "gateway":{"id":"1"}
}

HTTP DELETE REQUEST
http://127.0.0.1:8080/device/delete/1
