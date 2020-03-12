install:
	mvn clean install
deploy:
	docker-compose build --no-cache && docker-compose up
scale:
	docker-compose scale pg_primary=1 pg_replica=3 employees_command=1 employees_query=3
ls:
	docker container ls -a
clean:
	docker-compose rm -s -f -v && docker system prune