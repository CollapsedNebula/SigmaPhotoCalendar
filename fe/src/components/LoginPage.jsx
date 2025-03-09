import "../css/LoginPage.css";
import { Link } from "react-router-dom";

function LoginPage() {
    return (
        <>
            <div className="flex flex-col items-center space-y-2">
                <div className="text-5xl font-bold mr-45 pt-10 leading-20">로그인</div>
                <div>
                    <input
                        type="text"
                        placeholder="이메일을 입력해주세요"
                        className="border border-stone-400 p-2 pl-4 pr-4 w-xs rounded-lg"
                    ></input>
                </div>
                <div>
                    <input
                        type="password"
                        placeholder="비밀번호를 입력해주세요"
                        className="border border-stone-400 p-2 pl-4 pr-4 w-xs rounded-lg"
                    ></input>
                </div>
                <div className="flex items-center space-x-2 mr-35">
                    <p>계정이 없나요?</p>
                    <Link to="/signup" className="text-blue-500">
                        회원가입
                    </Link>
                </div>
                <button className="bg-stone-700 text-white p-2 mt-5 w-xs rounded-lg">로그인</button>
            </div>
        </>
    );
}

export default LoginPage;
