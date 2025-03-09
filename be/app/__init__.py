from flask import Flask
from flask_cors import CORS

def create_app():
    app = Flask(__name__)
    
    # CORS 설정: 특정 Origin만 허용 (ex. http://localhost:5173)
    CORS(app, resources={r"/*": {
        "origins": ["http://localhost:5173"],  # 프론트엔드 주소 명확히 지정
        "methods": ["GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"],
        "allow_headers": ["Content-Type", "Authorization"],  # 필요한 헤더 명시
        "supports_credentials": True  # 쿠키, 인증 정보 포함 허용
    }})

    # 라우트 등록
    from app.routes import api_bp
    app.register_blueprint(api_bp, url_prefix='/api')

    return app