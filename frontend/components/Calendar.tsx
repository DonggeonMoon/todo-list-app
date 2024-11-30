'use client'
import FullCalendar from "@fullcalendar/react";
import interactionPlugin from '@fullcalendar/interaction';
import dayGridPlugin from '@fullcalendar/daygrid'
import ScheduleDisplay from "@/components/ScheduleDisplay";
import React, {useEffect, useState} from "react";
import axios from "axios";
import {Schedule} from "@/types/Schedule";

axios.defaults.baseURL = "http://localhost:8080";

const fetchSchedules: () => Promise<Schedule[]> = async () => {
    const response = await axios.get<ApiResponse>("/api/schedules", {
        headers: {"Cache-Control": "public, max-age=60"},
    });
    return response.data.data.schedules;
}

export default function Calendar({initialSchedules}: { initialSchedules: Schedule[] }) {
    const [selectedScheduleId, setSelectedScheduleId] = useState<number | null>(null);
    const [schedules, setSchedules] = useState<Schedule[]>(initialSchedules);
    const [shouldFetch, setShouldFetch] = useState(true)

    useEffect(() => {
        if (!shouldFetch) return;
        fetchSchedules()
            .then((schedules) => setSchedules(schedules))
            .catch((error) => {
                console.error(error)
            }).finally(() => setShouldFetch(false));
    }, [shouldFetch]);

    return (
        <div className="flex justify-center">
            <div className="w-1/2 p-5">
                <FullCalendar
                    plugins={[dayGridPlugin, interactionPlugin]}
                    initialView="dayGridMonth"
                    locale="ko"
                    events={schedules.map(i => ({
                        title: i.name,
                        date: i.date,
                        extendedProps: {
                            id: i.id
                        }
                    }))}
                    eventClick={(info) => {
                        setSelectedScheduleId(info.event.extendedProps.id)
                    }}
                    dateClick={() => {
                        setSelectedScheduleId(null);
                    }}

                />
            </div>
            <ScheduleDisplay selectedScheduleId={selectedScheduleId} updateTrigger={setShouldFetch}/>
        </div>
    )
}