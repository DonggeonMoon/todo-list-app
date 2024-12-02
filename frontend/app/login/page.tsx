import {Metadata} from "next";
import LoginForm from "@/components/LoginForm";

export const metadata: Metadata = {
    title: '로그인'
}

export default function Page() {
    return (
        <div className="min-h-screen flex justify-center items-center">
            <div className="flex text-center">
                <LoginForm/>
            </div>
        </div>
    )
}