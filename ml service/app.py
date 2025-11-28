from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()


class LoanApplication(BaseModel):
    id: str | None = None
    customerId: str
    amount: float
    creditScore: int
    existingDebt: float


class PredictionResponse(BaseModel):
    prediction: str
    confidence: float


@app.post("/predict", response_model=PredictionResponse)
def predict(app: LoanApplication):
    # Simple rules for demo
    if app.creditScore > 750 and app.amount < 5000:
        return {"prediction": "APPROVE", "confidence": 0.92}
    elif app.creditScore < 550 and app.amount > 10000:
        return {"prediction": "REJECT", "confidence": 0.88}
    else:
        return {"prediction": "REVIEW", "confidence": 0.60}
