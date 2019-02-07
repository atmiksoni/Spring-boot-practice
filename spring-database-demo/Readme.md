To check Data base connected or Not

http://localhost:8083/h2-console/

curl Request to Save Student Object

curl -X POST \
  http://localhost:8083/createStudent/ \
  -H 'accept: application/json' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{"id":1,"name":"Atmik","passportNumber":"pasport"}'
  
  
  Search method
  
  http://localhost:8083/searchStudent/find?id=2
  
  