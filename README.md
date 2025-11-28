AI Workflow Automation System

This project implements a complete Loan Approval Workflow System using:

FastAPI (Python) → Machine Learning prediction service

Spring Boot (Java) → Workflow Engine

REST APIs for microservice communication

The system processes a loan request, performs ML prediction, applies business rules, and returns a final decision.

Features
🔹 ML Service (FastAPI)

Receives loan applicant data

Predicts loan approval based on rules

Returns PREDICTED_APPROVED or PREDICTED_REJECTED

🔹 Workflow Engine (Spring Boot)

Receives workflow requests

Calls the ML service

Applies workflow rules

Produces outcomes:

AUTO_APPROVE

AUTO_REJECT

MANUAL_REVIEW


Architecture Overview
Client
   ↓
Workflow Engine (Spring Boot)
   ↓ (REST API)
ML Service (FastAPI)
Two microservices communicate using REST to process loan applications.



How to Run the Project
1️⃣ Start the ML Service (FastAPI)
cd ml-service
uvicorn app:app --reload --port 8000

The ML API will run at:
📌 http://localhost:8000/docs

2️⃣ Start the Workflow Engine (Spring Boot)
cd workflow-engine
mvn spring-boot:run
The workflow API will run at:
📌 http://localhost:8081/workflow/process

📡 Sample Request (cURL)
curl -X POST http://localhost:8081/workflow/process \
-H "Content-Type: application/json" \
-d '{
  "id": "L1",
  "customerId": "C1",
  "amount": 3000,
  "creditScore": 780,
  "existingDebt": 1000
}'


Example Response
{
  "loanId": "L1",
  "status": "AUTO_APPROVE"
}

📁 Project Structure
AI-Workflow-Project/
│── workflow-engine/       # Spring Boot workflow service
│── ml-service/            # FastAPI ML prediction service
│── README.md

Technologies Used

Java 17

Spring Boot

Python 3

FastAPI

Uvicorn

REST APIs

Maven

📜 License

This project is released under the MIT License.

