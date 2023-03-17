Run below API to store 100 data 
curl --location 'http://localhost:5060/cards' \
--header 'Content-Type: application/json' \
--data '{
    "customerId" : 1,
    "cardType" : "Credit",
    "totalLimit" : 50000,
    "amountUsed" : 50000,
    "availableAmount" : 50000,
    "createdate" : "17-Mar-2023"
}'


Demo API which causes delay of 10s 
http://localhost:5059/demo - to verify memory sizes in flight recorder
