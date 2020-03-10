deploy:
	docker-compose build --no-cache && docker-compose up -d
scale:
	docker-compose scale pg_primary=2 pg_replica=5