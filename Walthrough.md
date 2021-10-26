# Avanced Library Mananagement Walthrough

1. Start demo with:

```shell
make docker-clean-build-start
```

2. Start locust in another tab:

```shell
make locust-start
```

3. Open locust on http://0.0.0.0:8089/

4. Start locust with 10 user and 10 users / second

5. Wat 1 minute

6. Stop reactive service

```shell
make docker-stop-reactive
```

7. Wait 1 minute

8. Stop non-reactive service

```shell
make doker-stop-mvc
```
