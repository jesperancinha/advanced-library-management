from locust import HttpUser, task

class AdvancedLibraryManagementTest(HttpUser):
    @task
    def g1_GET(self):
        self.client.get("http://localhost:8080/api/almg/books/g1/1")

    @task
    def g2_GET(self):
        self.client.get("http://localhost:8080/api/almg/books/g2/1")

    @task
    def g3_GET(self):
        self.client.get("http://localhost:8080/api/almg/books/g3/1")

    @task
    def g4_GET(self):
        self.client.get("http://localhost:8080/api/almg/books/g4/1")

    @task
    def g5_GET(self):
        self.client.get("http://localhost:8080/api/almg/books/g5/1")
