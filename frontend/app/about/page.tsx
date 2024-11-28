import NavBar from "@/components/NavBar";
import {Metadata} from "next";


export const metadata: Metadata = {
    title: "소개"
}

export default function Page() {
    return (
        <>
            <NavBar/>
            소개 페이지
        </>
    )
}