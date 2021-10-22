from locust import HttpUser, task

class AdvancedLibraryManagementTest(HttpUser):
    @task
    def hello_world(self):
        self.client.get("http://localhost:8080/api/almg/books/g1/10")
