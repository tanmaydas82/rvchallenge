echo "### DISPLAYING THE CITIES IN STATE 1 AK ###"
echo "\n\n"

curl -X GET http://localhost:8080/state/1/cities  

echo "\n\n"

echo "### DISPLAYING THE CITIES IN STATE 2 AL ###"
echo "\n\n"

curl -X GET http://localhost:8080/state/2/cities

echo "\n\n"

echo "### DISPLAYING THE CITIES IN STATE 3 AZ ###"
echo "\n\n"

curl -X GET http://localhost:8080/state/3/cities

echo "\n\n"


echo "### ADDING TOUR DATA FOR USER 2 JOHN SMITH ###"

echo "\n\n"

curl -i -u JoSm:JohnSmith@tour.com -X POST http://localhost:8080/user/2/visits -H 'Content-Type: application/json' --data-binary '{"city":"Akron", "state":"AL" }'

echo "\n\n"

curl -i -u JoSm:JohnSmith@tour.com -X POST http://localhost:8080/user/2/visits -H 'Content-Type: application/json' --data-binary '{"city":"Huntsville", "state":"AL" }'

echo "\n\n"

curl -i -u JoSm:JohnSmith@tour.com -X POST http://localhost:8080/user/2/visits -H 'Content-Type: application/json' --data-binary '{"city":"Adak", "state":"AK" }'

echo "\n\n"

curl -i -u JoSm:JohnSmith@tour.com -X POST http://localhost:8080/user/2/visits -H 'Content-Type: application/json' --data-binary '{"city":"Benson", "state":"AZ" }'

echo "\n\n"

echo "### ADDING TOUR DATA FOR USER 4 Jose Gonzales ###"

echo "\n\n"

curl -i -u JoGo:JoseGonzales@tour.com -X POST http://localhost:8080/user/4/visits -H 'Content-Type: application/json'  --data-binary '{"city":"Mesa", "state":"AZ" }'

echo "\n\n"

curl -i -u JoGo:JoseGonzales@tour.com -X POST http://localhost:8080/user/4/visits -H 'Content-Type: application/json' --data-binary '{"city":"Ash Fork", "state":"AZ" }'

echo "\n\n"

curl -i -u JoGo:JoseGonzales@tour.com -X POST http://localhost:8080/user/4/visits -H 'Content-Type: application/json' --data-binary '{"city":"Kotlik", "state":"AK" }'

echo "\n\n"

curl -i -u JoGo:JoseGonzales@tour.com -X POST http://localhost:8080/user/4/visits -H 'Content-Type: application/json' --data-binary '{"city":"Kwigillingok", "state":"AK" }'

echo "\n\n"

echo "### LISTING THE CITIES VISITED BY USER 2 JOHN SMITH ###"

echo "\n\n"

curl -X GET http://localhost:8080/user/2/visits


echo "\n\n"

echo "### LISTING THE STATES VISITED BY USER 2 JOHN SMITH ###"

echo "\n\n"

curl -X GET http://localhost:8080/user/2/visits/states

echo "\n\n"

echo "### LISTING THE CITIES VISITED BY USER 4 JOSH GONZALES ###"

echo "\n\n"

curl -X GET http://localhost:8080/user/4/visits


echo "\n\n"

echo "### LISTING THE STATES VISITED BY USER 4 JOSH GONZALES ###"

echo "\n\n"

curl -X GET http://localhost:8080/user/4/visits/states

echo "\n\n"

#echo "### DELETING THE CITIES VISITED BY USER 2 JOHN SMITH ###"
#
#echo "\n\n"
#
#curl -u 'JoSm:JohnSmith@tour.com' 'http://localhost:8080/user/2/visit/2' -X DELETE -H 'Origin: chrome-extension://hgmloofddffdnphfgcellkdfbfbjeloo' -H 'Accept-Encoding: gzip, deflate, sdch' -H 'Accept-Language: en-US,en;q=0.8' -H 'Authorization: ' -H 'Content-Type: application/json' -H 'Accept: */*' -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36' -H 'Connection: keep-alive' --data-binary '{"city":"Akron", "state":"AL" }' --compressed
#
#echo "\n\n"
#
#curl -u 'JoSm:JohnSmith@tour.com' 'http://localhost:8080/user/2/visit/2' -X DELETE -H 'Origin: chrome-extension://hgmloofddffdnphfgcellkdfbfbjeloo' -H 'Accept-Encoding: gzip, deflate, sdch' -H 'Accept-Language: en-US,en;q=0.8' -H 'Authorization: ' -H 'Content-Type: application/json' -H 'Accept: */*' -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36' -H 'Connection: keep-alive' --data-binary '{"city":"Akron", "state":"AL" }' --compressed
#
#echo "\n\n"

echo "####PAGING###"

curl -X GET 'http://localhost:8080/state/1/cities?page=0&size=2'
