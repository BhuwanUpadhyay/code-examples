FROM postgres:9.6.17-alpine
COPY setup-primary.sh /docker-entrypoint-initdb.d/setup-primary.sh
RUN chmod 0666 /docker-entrypoint-initdb.d/setup-primary.sh