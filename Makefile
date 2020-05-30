build:
	./gradlew build && docker build -t pismo .

clean:
	./gradlew clean

local:
	docker-compose -f docker-compose.local.yml up

dev:
	docker-compose -f docker-compose.dev.yml up