'use client'

export default function LoginForm() {
    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
    }

    return (
        <form
            onSubmit={handleSubmit}>
            <div>
                <label htmlFor="username">아이디</label>
                <input type="text" name="username" placeholder="아이디"/>
            </div>
            <div>
                <label htmlFor="password">비밀번호</label>
                <input type="text" name="password" placeholder="비밀번호"/>
            </div>
            <div>
                <button type="submit">로그인</button>
            </div>
        </form>
    )
}