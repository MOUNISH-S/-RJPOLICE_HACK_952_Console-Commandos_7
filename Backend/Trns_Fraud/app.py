import joblib
import pandas as pd

def load_model(model_path):
    model = joblib.load(model_path)
    return model

def make_prediction(model, input_data):
    prediction = model.predict(input_data)
    return prediction

if __name__ == "__main__":
    model_path = 'fraud_detection_model.joblib'
    trained_model = load_model(model_path)

    example_data = pd.DataFrame({
        'step': [100],
        'type': [2],
        'amount': [1000.0],
        'oldbalanceOrg': [5000.0],
        'newbalanceOrig': [4000.0],
        'oldbalanceDest': [0.0],
        'newbalanceDest': [0.0],
    })

    prediction_result = make_prediction(trained_model, example_data)
    print(f'Fraud Prediction: {prediction_result}')
