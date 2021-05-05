sleep 30
mongoimport --host mongodb_container --db films --collection user --type json --file /init.json --jsonArray