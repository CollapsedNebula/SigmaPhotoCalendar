import { Link } from 'react-router-dom'

function SignupPage () {

    return (
        <>
            <div className="flex flex-col items-center space-y-2">
                <div className="text-5xl font-bold mr-35 pt-10 leading-20">회원가입</div>
                <div>
                    <input type='text' placeholder='이메일을 입력해주세요'
                           className='border border-stone-400 p-2 pl-4 pr-4 w-xs rounded-lg'></input>
                </div>
                <div>
                    <input type='password' placeholder='비밀번호를 입력해주세요'
                           className='border border-stone-400 p-2 pl-4 pr-4 w-xs rounded-lg'></input>
                </div>
                <div className="flex items-center space-x-2 mr-30">
                    <p>계정이 이미 있나요?</p>
                    <Link to='/login' className='text-blue-500'>로그인</Link>
                </div>
                <button className="bg-stone-700 text-white p-2 mt-5 w-xs rounded-lg">회원가입</button>
            </div>
        </>
    )
}

export default SignupPage