FROM mongo

COPY init.json /init.json

#ADD start.sh /start.sh
#RUN chmod +x /start.sh

CMD mongoimport --port 27017 --db films --collection user --type json --file /init.json --jsonArray