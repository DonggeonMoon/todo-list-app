'use client'
import FullCalendar from "@fullcalendar/react";
import dayGridPlugin from '@fullcalendar/daygrid'

type Schedule = {
    id: number;
    name: string;
    description: string;
    date: string;
    startTime: string;
    endTime: string;
}

export default function Calendar({schedules}: { schedules: Schedule[] }) {
    return (
        <div className="w-1/2 p-5">
            <FullCalendar
                plugins={[dayGridPlugin]}
                initialView="dayGridMonth"
                locale="ko"
                events={schedules.map(i => ({title: i.name, date: i.date}))}
            />
        </div>

    )
}