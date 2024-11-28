import React from "react";
import axios from "axios";
import {Metadata} from "next";
import Calendar from "@/components/Calendar";
import NavBar from "@/components/NavBar";
import ScheduleDisplay from "@/components/ScheduleDisplay";

export const metadata: Metadata = {
    title: "달력"
}

axios.defaults.baseURL = "http://localhost:8080";

const fetchSchedules = async () => {
    try {
        const response = await axios.get(`/api/schedules`);
        console.log(response.data.data.schedules)
        return response.data
            .data.schedules;
    } catch (error) {
        console.error(error);
        return [];
    }
};

export default async function Page() {
    const schedules = await fetchSchedules();
    return (
        <>
            <NavBar/>
            <div className="flex justify-center">
                <Calendar schedules={schedules}/>
                <ScheduleDisplay schedules={schedules}/>
            </div>
        </>
    );
}
