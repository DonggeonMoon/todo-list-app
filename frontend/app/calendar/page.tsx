import React from "react";
import axios from "axios";
import {Metadata} from "next";
import Calendar from "@/components/Calendar";
import NavBar from "@/components/NavBar";

export const metadata: Metadata = {
    title: "달력"
}

axios.defaults.baseURL = "http://localhost:8080";

export default async function Page() {
    const fetchSchedules = async () => {
        try {
            const response = await axios.get('/api/schedules');
            return response.data.data.schedules;
        } catch (error) {
            console.error(error);
            return [];
        }
    };

    const schedules = await fetchSchedules();
    return (
        <>
            <NavBar/>
            <div className="flex justify-center">
                <Calendar schedules={schedules}/>
            </div>
        </>
    );
}
