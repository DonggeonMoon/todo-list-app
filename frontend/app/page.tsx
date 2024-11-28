import NavBar from "@/components/NavBar";
import {Metadata} from "next";

export const metadata: Metadata = {
    title: "홈"
}

export default function Home() {
    return (
        <div>
            <NavBar/>
            홈페이지
        </div>
    );
}
