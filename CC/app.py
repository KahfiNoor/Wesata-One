from flask import Flask, request, jsonify
from tensorflow.python.keras.models import model_from_json
import numpy as np
import os
from flask_cors import CORS

app = Flask(__name__)
CORS(app)  # Mengizinkan cross-origin requests

@app.route('/')
def index():
    return "API is running"

# Load model dari file JSON
with open('model.json', 'r') as json_file:
    loaded_model_json = json_file.read()
model = model_from_json(loaded_model_json)

# Load bobot ke dalam model
model.load_weights('modelwesataone.h5')

@app.route('/recommend', methods=['POST'])
def recommend():
    input_data = request.json['input']
    input_array = np.array(input_data).reshape(1, -1)

    prediction = model.predict(input_array)
    output = prediction[0][0]

    return jsonify({'recommendation': output})

@app.route('/register', methods=['POST'])
def register():
    email = request.json['email']
    password = request.json['password']
    # Simpan detail registrasi ke Firestore (atau layanan autentikasi yang sesuai)
    # Placeholder untuk penyimpanan lokal
    # Logika penyimpanan user (misalnya, ke file lokal atau memori) bisa ditambahkan di sini
    return jsonify({'message': 'User registered successfully'})

@app.route('/login', methods=['POST'])
def login():
    email = request.json['email']
    password = request.json['password']
    # Placeholder untuk verifikasi user dari penyimpanan lokal
    # Logika verifikasi user bisa ditambahkan di sini
    return jsonify({'message': 'Login successful'})

if __name__ == '__main__':
    app.run(debug=True)
