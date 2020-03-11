deploy:
	mvn clean install && \
	cp -R employees-command/target/employees-command.jar docker/command && \
	cp -R employees-query/target/employees-query.jar docker/query && \
	docker-compose build --no-cache && docker-compose up -d
scale:
	docker-compose scale pg_primary=1 pg_replica=3 employees_command=1 employees_query=3