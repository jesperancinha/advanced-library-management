b: build
build: build-npm build-maven
build-npm:
	cd advanced-library-management && yarn install && npm run build
build-maven:
	mvn clean install -DskipTests
build-test:
	mvn clean install
test:
	mvn test
test-maven:
	mvn test
local: no-test
	mkdir -p bin
no-test:
	mvn clean install -DskipTests
docker-clean:
	docker-compose rm -svf
docker:
	rm -rf out
	docker-compose up -d --build --remove-orphans
docker-local:
	cd docker/local
	docker-compose up -d --build --remove-orphans
docker-clean-build-start: docker-clean b docker
docker-clean-start: docker-clean docker
docker-stop-spring:
	docker stop jofisaes_advanced_library_mngmt_reactive
	docker stop jofisaes_advanced_library_mngmt_mvc
docker-start-spring:
	docker start jofisaes_advanced_library_mngmt_reactive
	docker start jofisaes_advanced_library_mngmt_mvc
docker-stop-reactive:
	docker stop jofisaes_advanced_library_mngmt_reactive
docker-stop-mvc:
	docker stop jofisaes_advanced_library_mngmt_mvc
stop:
	docker-compose down --remove-orphans
prune-all: stop
	docker ps -a --format '{{.ID}}' -q | xargs docker stop
	docker ps -a --format '{{.ID}}' -q | xargs docker rm
	docker system prune --all
	docker builder prune
	docker system prune --all --volumes
case:
locust-start:
	cd locust && locust --host localhost
remove-lock-files:
	find . -name "package-lock.json" | xargs -I {} rm {}; \
	find . -name "yarn.lock" | xargs -I {} rm {};
update: remove-lock-files
	git pull; \
	curl --compressed -o- -L https://yarnpkg.com/install.sh | bash; \
	npm install caniuse-lite; \
	npm install -g npm-check-updates; \
	cd advanced-library-management; \
		yarn; \
		npx browserslist --update-db; \
		ncu -u; \
		yarn
deps-npm-update: update
revert-deps-cypress-update:
	if [ -f  e2e/docker-composetmp.yml ]; then rm e2e/docker-composetmp.yml; fi
	if [ -f  e2e/packagetmp.json ]; then rm e2e/packagetmp.json; fi
	git checkout e2e/docker-compose.yml
	git checkout e2e/package.json
deps-plugins-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/pluginUpdatesOne.sh | bash
deps-java-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/javaUpdatesOne.sh | bash
deps-node-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/nodeUpdatesOne.sh | bash
deps-quick-update: deps-plugins-update deps-java-update deps-node-update
accept-prs:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/acceptPR.sh | bash
