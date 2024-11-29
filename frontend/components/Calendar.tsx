'use client'
import FullCalendar from "@fullcalendar/react";
import dayGridPlugin from '@fullcalendar/daygrid'
import ScheduleDisplay from "@/components/ScheduleDisplay";
import React, {useState} from "react";

type Schedule = {
    id: number;
    name: string;
    description: string;
    date: string;
    startTime: string;
    endTime: string;
}

export default function Calendar({schedules}: { schedules: Schedule[] }) {
    const [selectedDate, setSelectedDate] = useState<string | null>('2022-11-29');
    return (<>
            <div className="w-1/2 p-5">
                <FullCalendar
                    plugins={[dayGridPlugin]}
                    initialView="dayGridMonth"
                    locale="ko"
                    events={schedules.map(i => ({title: i.name, date: i.date}))}
                />
            </div>
            <ScheduleDisplay schedules={schedules} selectedDate={selectedDate}/>
        </>
    )
}