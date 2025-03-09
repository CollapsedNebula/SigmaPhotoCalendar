from flask import Blueprint, jsonify, request, send_from_directory
from flask_cors import CORS
import os

api_bp = Blueprint('api', __name__)
CORS(api_bp)

UPLOAD_FOLDER = 'uploads'  # 저장할 폴더 지정
os.makedirs(UPLOAD_FOLDER, exist_ok=True)  # 폴더가 없으면 생성

# 이미지 파일 확장자 필터링
ALLOWED_EXTENSIONS = {'png', 'jpg', 'jpeg', 'gif', 'bmp'}

def allowed_file(filename):
    return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS

@api_bp.route('/upload', methods=['POST'])
def upload_endpoint():
    
    # 이미지가 없음
    if 'image' not in request.files:
        return jsonify({"error": "No image in request"}), 400

    file = request.files['image'] 
    if file.filename == '':
        return jsonify({"error": "No selected file"}), 400
    
    # 파일 저장 경로 설정
    file_path = os.path.join(UPLOAD_FOLDER, file.filename)
    file.save(file_path)

    return jsonify({"text": "Success"}), 200



@api_bp.route('/images', methods=['GET'])
def images_endpoint():
    
    # uploads 폴더 내 모든 파일 목록을 가져옴
    files = os.listdir(UPLOAD_FOLDER)
    
    # 파일 필터링 (이미지 파일만 포함)
    image_files = [file for file in files if allowed_file(file)]

    # 이미지 파일의 URL 리스트를 반환
    image_urls = [f'/api/images/{file}' for file in image_files]

    return jsonify({"images": image_urls}), 200