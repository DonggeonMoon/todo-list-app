import React from "react";
import {Metadata} from "next";
import Calendar from "@/components/Calendar";
import NavBar from "@/components/NavBar";
import axios from "axios";
import {Schedule} from "@/types/Schedule";

export const metadata: Metadata = {
    title: "할 일"
}

axios.defaults.baseURL = "http://localhost:8080";

const fetchSchedules: () => Promise<Schedule[]> = async () => {
    const response = await axios.get<ApiResponse>("/api/schedules", {
        headers: {"Cache-Control": "public, max-age=60"},
    });
    return response.data.data.schedules;
}

export default async function Page() {
    const initialSchedules = await fetchSchedules();
    return (
        <main>
            <NavBar/>
            <Calendar initialSchedules={initialSchedules}/>
        </main>
    );
}
